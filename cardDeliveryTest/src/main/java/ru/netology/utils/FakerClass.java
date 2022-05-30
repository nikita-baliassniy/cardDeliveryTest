package ru.netology.utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class FakerClass {

	private static FakerClass fakerClass = null;
	private static final String[] availableCities =
			{"Москва", "Санкт-Петербург", "Севастополь", "Пермь", "Петрозаводск",
					"Петропавловск-Камчатский", "Абакан", "Анадырь", "Барнаул", "Биробиджан",
					"Благовещенск", "Архангельск", "Горно-Алтайск", "Йошкар-Ола", "Калининград",
					"Калуга", "Махачкала", "Салехард", "Нальчик", "Ставрополь", "Южно-Сахалинск",
					"Ярославль", "Владивосток", "Владимир", "Владикавказ", "Новосибирск",
					"Волгоград", "Вологда", "Иваново", "Ростов-на-Дону", "Сыктывкар", "Липецк",
					"Элиста", "Челябинск", "Великий Новгород", "Псков", "Ханты-Мансийск", "Майкоп",
					"Самара", "Симферополь", "Мурманск", "Магадан"};

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
				faker.name().lastName().replaceAll("ё", "е") + " " + faker.name().firstName()
						.replaceAll("ё", "е"),
				faker.name().lastName().replaceAll("ё", "е") + " " + faker.name().firstName()
						.replaceAll("ё", "е"),
				faker.phoneNumber().phoneNumber().replaceAll("-", "").replaceAll("\\(", "")
						.replaceAll("\\)", ""),
				faker.phoneNumber().phoneNumber().replaceAll("-", "").replaceAll("\\(", "")
						.replaceAll("\\)", ""),
				availableCities[faker.number().numberBetween(0, 43)],
				availableCities[faker.number().numberBetween(0, 43)]);
		//todo заменить последние строки на faker.address().city(), когда в приложении будет адекватный словарь городов
	}
}
