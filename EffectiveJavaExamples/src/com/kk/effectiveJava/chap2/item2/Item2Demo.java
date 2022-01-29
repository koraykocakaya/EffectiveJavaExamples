package com.kk.effectiveJava.chap2.item2;

/**
 * 
 * Cok parametreli constructorlari (ozellikle fieldlar ayni type ise) kullanmak yerine Builder kullanmamizi tavsiye etmektedir <br>
 * 1. Bu sekilde constructor kullanimlarinda telescoping constructor pattern kullanilmaktadir (Constructorlarin birbirini cagirmasi, parametre ekleyerek), kullanimi sorunlu olacaktir <br>
 * 2. Bir baska yontem JavaBeans Pattern yani parametresiz constructor ile yaratip setter ile setlemek, ancak bunda da kontrol eksikligi, immutable yaratma istegi gibi sorunlar olabilmektedir <br>
 * 3. Builder Design Pattern kullanilarak bu sorunlar cozulebilmektedir. Bu pattern yardimiyla field check vs yapilabilmektedir <br>
 * 4. Objenin yaninda Builder da yarattigimiz icin performans acisindan her durumda Builder kullanmamamiz gerekmektedir
 *  
 * @author korayk
 */
public class Item2Demo {
	
	public static void main(String[] args) {
		
		// CreditCard immutable
		CreditCard creditCard = new CreditCardBuilder("1234567891011121", "123").month("10").build();
		System.out.println(creditCard);
	}
}
