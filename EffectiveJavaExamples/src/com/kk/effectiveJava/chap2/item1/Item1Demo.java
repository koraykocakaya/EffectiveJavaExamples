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
