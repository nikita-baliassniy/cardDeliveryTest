package ru.netology.pages;

import ru.netology.fields.AbstractField;

public interface IPageObject {

	<T extends AbstractField> T getField(String fieldName);

	<T extends AbstractField> T getField(IPageObject page, String fieldName);

	boolean isLoaded();
}
