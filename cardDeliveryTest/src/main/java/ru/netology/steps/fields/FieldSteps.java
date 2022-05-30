package ru.netology.steps.fields;

import static org.junit.Assert.assertTrue;


import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.netology.steps.AbstractStepsHolder;

public class FieldSteps extends AbstractStepsHolder {

	FieldScenarioSteps fieldScenarioSteps = new FieldScenarioSteps();


	@When("^поле (.*) заполняется значением (.*)$")
	public void stepFillField(String field, String value) {
		fieldScenarioSteps.fillField(field, evalVariable(value));
	}

	@When("^заполняются поля:")
	public void stepFillFields(DataTable fields) {
		fields.asMap(String.class, String.class)
				.forEach((k, v) -> fieldScenarioSteps.fillField(k, evalVariable(v).toString()));
	}

	@When("выполнено нажатие на (.*)")
	public void stepClickField(String field) {
		fieldScenarioSteps.clickField(field);
	}

	@Then("^поле (.+) видимо$")
	public void stepFieldIsDisplayed(String fieldName) {
		boolean isPresent = fieldScenarioSteps.fieldIsPresent(fieldName);
		assertTrue("Поле " + fieldName + " не существует на странице", isPresent);
	}

	@When("^приостановлено выполнение на (.+) (?:секунд|секунду|секунды)$")
	public void stopProcessing(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("поле (.*) очищено")
	public void stepClearField(String field) {
		fieldScenarioSteps.clearField(field);
	}
}

