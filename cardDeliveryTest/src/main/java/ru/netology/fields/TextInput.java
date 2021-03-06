package ru.netology.fields;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.netology.DriverManager;

public class TextInput extends AbstractField {

	private static final String INPUT = ".";

	public TextInput(SelenideElement element) {
		super(element);
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	@Override
	public void type(String value) {
		SelenideElement element = this.element;
		int counter = 15;
		element.waitUntil(Condition.enabled, DriverManager.getDefaultImplicitlyWait());
		while (!element.getValue().equals(value) && !element.getValue().replaceAll(" ", "")
				.equals(value) && counter > 0) {
			try {
				Thread.sleep(200);
				element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				element.sendKeys(Keys.BACK_SPACE);
				element.sendKeys(value);
				counter++;
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public String getFieldValue() {
		return element.findElement(By.xpath(INPUT)).getAttribute("value");
	}
}
