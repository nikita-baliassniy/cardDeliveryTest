package ru.netology.steps.utils;

import static ru.netology.steps.AbstractStepsHolder.evalVariable;
import static ru.netology.steps.AbstractStepsHolder.setVariable;


import cucumber.api.java.en.Given;
import java.lang.reflect.Field;
import ru.netology.utils.PersonData;

public class DataParamsSteps {

	JsonDataReader jsonDataReader = new JsonDataReader();

	@Given("данные пользователя подгружены из файла (.*)$")
	public void loadUserData(String fileName) {
		PersonData personData = jsonDataReader.getPersonData(evalVariable(fileName));
		for (Field f : personData.getClass().getDeclaredFields()) {
			try {
				f.setAccessible(true);
				setVariable(f.getName(), f.get(personData));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
