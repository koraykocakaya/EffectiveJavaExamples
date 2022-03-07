package com.kk.effectiveJava.chap3.item10;

import java.util.Objects;

/**
 * equals metodunu override etmeyi sadce gercekten gerekli oldugunda yapmamizi ogutlemektedir. <br>
 * 1. Bunu mumkunse gercekten sadece logical esitliklerini kontrol edecegimiz classlar icin yapmamizi onermektedir <br>
 * 2. Enum gibi bazi classlar icin logical equality direkt objenin equal olmasi anlamina geldigi icin Object classindaki equals yeterli olacaktir <br>
 * 3. equals Override ettiğimizde bu kurallar saglanmalidir <br>
 *  3.1 Reflexive null degilse x.equals(x) daima true donmeli <br>
 *  3.2 Symmetric x.equals(y) true ise y.equals.(x) de true donmeli <br>
 *  3.3 Transitive x.equals(y) = true y.equals(z) = true ise x.equals(z) = true olmalidir <br>
 *  3.4 Consistent x.equals(y) true ise extra bir degisiklik olmadan her zamana true donmelidir <br>
 *  3.5 Null olmayan hic bir kayit icin x.eqals(null) daima false donmelidir
 * 4. equals icin yapabileceklerimiz
 *  4.1 Oncelikle gelen obje this'e esit mi kontrolu yapilmali boylece null check de yapilmis olacaktir
 *  4.2 Sonrasinda gelen objenin tipini kontrolu yapilmali farkliysa direkt false donulmelidir
 *  4.3 gelen obje ilgili tipe cast edilmeli
 *  4.4 Son oalrak tum alanlarin ayni oldugu kontrol edilmeli, burada primitiveler == ile (float ve double Float.compare ile kontrol edilmeli), 
 *  digerleri equals ile kontrol edilmelidir	 
 *  Burada oncelikle farkli olmasi olasi olan fieldlari kiyaslamak performans acisindan saglikli olacaktir
 *  gercekten gerekmedikce equals metodunu Override etmemek saglikli olacaktir
 * @author korayk
 *
 */
public class Item10Demo {

	public static class Person{
		private int age;
		private String name;
		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj == this) {
				return true;
			}
			
			if(!(obj instanceof Person)) {
				return false;
			}
			
			Person person = (Person) obj;
			return this.age == person.getAge() && Objects.equals(this.name, person.getName());
		}
	}
}
