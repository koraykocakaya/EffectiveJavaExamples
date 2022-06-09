package com.kk.effectiveJava.chap4.item22;

/**
 * 1. Constantlari tutmak icin interface'i kullanmamamizi ogutlemektedir.
 * 2. Bunun yerine Enum veya Utility classlari kullanmak daha saglikli olacaktir
 * 3. Utility veya Enum olarak tanimladigimizda direkt fieldi kullanabilmek icin de classi static import etmemiz yeterli olacaktir.
 * @author korayk
 */
public class Item22Demo {

	public static void main(String[] args) {
		System.out.println(Utility.PI);
	}
}

// interface constant icin kullanilmamali
interface constInterface{
	static final Double PI = 3.14;
}

class Utility{
	// Instantiate edilememeli
	private Utility() {
		
	}
	static final Double PI = 3.14;
}
