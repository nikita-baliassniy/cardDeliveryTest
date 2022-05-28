package ru.netology.utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class FakerClass {

	private static FakerClass fakerClass = null;

	public static FakerClass getInstance() {
		if (fakerClass == null) {
			fakerClass = new FakerClass();
		}
		return fakerClass;
	}

	public PersonData createPerson() {
		Faker faker = new Faker(new Locale("ru-RU"));
		return new PersonData(
				//todo Убрать замены буквы ё, когда приложение починят
				faker.name().lastName().replaceAll("ё","е") + " " + faker.name().firstName().replaceAll("ё","е"),
				faker.name().lastName().replaceAll("ё","е") + " " + faker.name().firstName().replaceAll("ё","е"),
				faker.phoneNumber().phoneNumber().replaceAll("-","").replaceAll("\\(","").replaceAll("\\)",""),
				faker.phoneNumber().phoneNumber().replaceAll("-","").replaceAll("\\(","").replaceAll("\\)",""),
				faker.address().city(),
				faker.address().city()
		);
	}
}
