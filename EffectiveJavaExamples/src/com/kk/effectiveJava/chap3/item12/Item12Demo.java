package com.kk.effectiveJava.chap3.item12;

/**
 * toString metodunun Override edilmesi gerektigini ogutlemektedir,
 * 1. Normalde objeyi print etmek isten,rse hashcodeunun hexadecimal representationi print edilecektir
 * 2. Bunun yerine objeyle ilgili gerekli bilgilerin print edilmesi bilgilendirme ve debug acisindan saglikli olacaktir
 * 3. Complex siniflarda ozet olacak sekilde verilmesi saglikli olacaktir, ozellikle objeyle ilgili gerekli ve kullanisli bilgilere yer verilmelidir
 * 4. toString'de ilgili veriyi formatlayabiliriz, boylece otomatik olarka CSV'de vs. kullanilmasini kolaylastiririz, nasil formatlandigini dokumante etmek saglikli olacaktir
 * 5. Asagidaki ornekteki gibi IDE'nin onerisi kullanilabilir ancak telefon numarasi gibi classlar icin custom yazmak gerekecektir
 * @author korayk
 *
 */
public class Item12Demo {
	
	public static void main(String[] args) {
		Person p1 = new Person("Koray", "Koca", 30);
		System.out.println(p1);
	}

	public static class Person{
		private String name;
		private String surname;
		private int age;
		
		public Person(String name, String surname, int age) {
			this.name = name;
			this.surname = surname;
			this.age = age;
		}

		/**
		 * , ile ayirarak name, surname ve age detaylari yazildi
		 * Person [name=Koray, surname=Koca, age=30] gibi
		 */
		@Override
		public String toString() {
			return "Person [name=" + name + ", surname=" + surname + ", age=" + age + "]";
		}
		
	}
}
