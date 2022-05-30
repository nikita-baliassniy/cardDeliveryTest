package ru.netology.pages;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Page {

	public Page(String name) {
		this.name = name;
		this.asClass = PageObjects.getClassMap().get(name);
	}

	@NonNull
	@Getter
	private Class<? extends AbstractPageObject> asClass;

	@NonNull
	@Getter
	private String name;

	@Override
	public String toString() {
		return name;
	}
}
