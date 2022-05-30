package ru.netology.pages;


import java.lang.reflect.InvocationTargetException;
import lombok.extern.slf4j.Slf4j;
import ru.netology.core.extractors.FieldExtractor;
import ru.netology.fields.AbstractField;

@Slf4j
public abstract class AbstractPageObject implements IPageObject {

	public abstract boolean isLoaded();

	protected static ThreadLocal<IPageObject> currentPage = new ThreadLocal<IPageObject>();
	protected static ThreadLocal<IPageObject> previousPage = new ThreadLocal<IPageObject>();

	FieldExtractor fieldExtractor;

	public static <T extends IPageObject> T getCurrentPage() {
		return (T) currentPage.get();
	}

	public static void setCurrentPage(Class<? extends IPageObject> page) {
		try {
			AbstractPageObject pageObject =
					(AbstractPageObject) page.getConstructors()[0].newInstance();
			setPreviousPage(currentPage.get());
			currentPage.set(pageObject);
		} catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T extends AbstractField> T getField(String fieldName) {
		return fieldExtractor.getField(getCurrentPage(), fieldName);
	}

	@Override
	public <T extends AbstractField> T getField(IPageObject page, String fieldName) {
		return (T) fieldExtractor.getField(page, fieldName);
	}

	public static void setPreviousPage(IPageObject page) {
		previousPage.set(page);
	}
}
