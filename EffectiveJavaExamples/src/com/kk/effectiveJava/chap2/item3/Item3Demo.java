package com.kk.effectiveJava.chap2.item3;

/**
 * Singleton property sadece bir kere yaratilmalidir ve her istendiginde ayni obje return edilmelidir <br>
 * 1. Bunu class içinde objeyi public final yaparak saglanilabilmektedir (constructor private olmali) - field <br>
 * 2. Class icindeki obje private olmali, static factory metot ekleyerek bu obje return edilebilmektedir - static factory <br>
 * 3. İlgili obje için enum yaratip enum'a tek bir instance ekleyerek yapilabilmektedir <br>
 * 4. 1.madde reflection ile private const cagrilabilir, 2.madde serialization-deserialization esnasinda yeni obje yaratmasi durumlarindan dolayi 3. maddeyi tercih etmek daha saglikli olacaktir
 * 
 * @author korayk
 * 
 */
public class Item3Demo{
	
	public static void main(String[] args) {
		// field
		
		
		Elvis.INSTANCE.test();
	}
}

class ElvisField {
	public static final ElvisField instance = new ElvisField();
	private ElvisField() {
		
	}
}

class ElvisStaticFactory {
	private static final ElvisStaticFactory instance = new ElvisStaticFactory();
	private ElvisStaticFactory() {
		
	}
	
	public static ElvisStaticFactory getInstance() {return instance;}
}

enum Elvis{
	INSTANCE;
	
	public void test() {
		
	}
}