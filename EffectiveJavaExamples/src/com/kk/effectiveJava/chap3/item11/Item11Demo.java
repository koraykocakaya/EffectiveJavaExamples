package com.kk.effectiveJava.chap3.item11;

import java.util.Objects;

/**
 * 1. Eger equals Override ediyorsak, hashcode'u da override etmemizi soylemektedir 
 * 2. Burada en onemli konu, eger iki obje equals true donuyorsa hashcodelari da ayni olmalidir, boylece HashMap'e key olarak atarken ayri objeler gibi davranmasi engellenmelidir 
 * 3. hashcode olarak sabit bir sayi donulmemelidir, dogru hash fonksiyonu esit olmayan objeler icin farkli degerler donmelidir 
 * 4. Performans onemli degise hash uretmek icin Objects.hash metodu kullanilabilir
 * 5. Eger obje immutable ise hashi bir kez hesaplayip istendiginde cacheten getirmek saglikli olacaktir
 * 
 * @author korayk
 *
 */
public class Item11Demo {
	
	public static void main(String[] args) {
		Person p1 = new Person("Koray", "kocaka");
		Person p2 = new Person("Koray", "Kocaka");
		Person p3 = new Person("Koray", "kocaka");
		Person p4 = new Person(null, "kocaka");
		Person p5 = new Person(null, "kocaka");
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
		
		// Hashcode'un hexadecimal representation basar
		System.out.println(p4);
		System.out.println(p5);
	}

	public static class Person {
		private String name;
		private String surname;
		
		public Person(String name, String surname) {
			super();
			this.name = name;
			this.surname = surname;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}

			if (!(obj instanceof Person)) {
				return false;
			}

			Person person = (Person) obj;
			return Objects.equals(this.name, person.getName()) && Objects.equals(this.surname, person.getSurname());
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.name, this.surname);
		}
	}
}
