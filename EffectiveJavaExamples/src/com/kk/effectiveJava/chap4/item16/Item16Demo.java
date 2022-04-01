package com.kk.effectiveJava.chap4.item16;

/**
 * 1. public classlarda public fieldlarin degil, accessor metotlarin kullanilmasi gerektigibi belirtmektedir
 * 2. Private veya package-private classlarda public field kullanmak sorun olmayacaktir
 * 3. Eger field immutable ise private yapip, sadece getter metodu eklemek yeterli olacaktir
 * 4. Accessor kullanmak field ile ilgili kontrolu de kolaylastiracaktir
 * @author korayk
 *
 */
public class Item16Demo {

}

class Person{
	private final String name;
	private String surname;
	private int age;
	
	public Person(String name) {
		super();
		this.name = name; 
		
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age < 0) 
			throw new IllegalArgumentException("Age can't be less than 0, age is: " + age);

		this.age = age;
	}
	
	
}
