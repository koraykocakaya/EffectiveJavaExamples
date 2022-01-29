package com.kk.effectiveJava.chap2.item1;

public class Person {

	public static Person createPersonByNameSurname(String name, String surname) {
		return new Person(name, surname, null);
	}
	
	public Person(String name, String surname, String tckn) {
		this.name = name;
		this.surname = surname;
		this.tckn = tckn;
	}
	
	private String name;
	private String surname;
	private String tckn;
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getTckn() {
		return tckn;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ");
		sb.append(this.name);
		sb.append(", Surname: ");
		sb.append(this.surname);
		sb.append(", Tckn: ");
		sb.append(this.tckn);
		
		return sb.toString();
	}
}
