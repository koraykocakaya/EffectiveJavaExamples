package com.kk.effectiveJava.chap2.item1;

import java.util.Collections;

/**
 * 
 * Bu maddede anlatilan constructor yerine static factory metotlar kullanabilecegimizi anlatmaktadir <br>
 * 1. Boylece metotlara isim verilebilmektedir ve constructordaki karmasa onlenmektedir (ayni type'taki fieldlarla yazdigimiz constructorlar ile calistigimizda) <br>
 * 2. Static factory eger yenisini yaratmaya gerek yoksa daha once yarattigini bir yerde saklayip onu donebilmektedir(Flyweight Design Pattern) <br>
 * 3. Collections.emptyList() oldugu gibi subtype return edebilmektedir <br>
 * 4. Bu metotlari bulmak zor olabilecegi icin from, of,valueOf, create, getType, getInstance, newType gibi metotlar ile yazmak kullanicinin bulmasini kolaylastiracaktir
 * @author korayk
 *
 */
public class Item1Demo {

	public static void main(String[] args) {
		
		// boolean -> Boolean cevirmek icin static factory 
		Boolean bool = Boolean.valueOf(false);
		System.out.println(bool);
		
		Collections.emptyList();
		
		Person p1 = Person.createPersonByNameSurname("koray", "koca");
		System.out.println(p1);
	}
}

class Person {

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
