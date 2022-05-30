package ru.netology.steps.fields;

import io.qameta.allure.Step;
import ru.netology.pages.AbstractPageObject;
import ru.netology.pages.IPageObject;

public class FieldScenarioSteps {

	@Step("поле \"{fieldName}\" заполняется значением \"{value}\"")
	public void fillField(String fieldName, String value) {
		IPageObject page = AbstractPageObject.getCurrentPage();
		page.getField(fieldName).type(value);
	}

	@Step("выполнено нажатие на {fieldName}")
	public void clickField(String fieldName) {
		IPageObject page = AbstractPageObject.getCurrentPage();
		page.getField(fieldName).click();
	}

	@Step
	public boolean fieldIsPresent(String fieldName) {
		IPageObject page = AbstractPageObject.getCurrentPage();
		return page.getField(fieldName).isDisplayed();
	}

	@Step("поле {fieldName} очищено")
	public void clearField(String fieldName) {
		IPageObject page = AbstractPageObject.getCurrentPage();
		page.getField(fieldName).clear();
	}

}