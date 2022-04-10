package com.kk.effectiveJava.chap4.item19;

import java.time.Instant;

/**
 * 1. Inherit edilebilecek bir class içindeki overridable metotlarin dizayni ve dokumantasyonun yapilmasinin, yoksa inheritancetan kacinmamiz gerektigibi belirtmektedir
 * 2. Overriable edilebilen metotlarda, @implSpec ile metodun nasil calistigi belirtilmelidir, boylece inherit edildigi durumda nasil yazilmasi konusunda yol gosterebilecektir
 * 3. Bir classin inheritance icin uygun oldugunu test etmenin tek yolu subclasslar yazmaktir
 * 4. Inheritance icin ayri bir dokuman yazilmasi saglikli olacaktir
 * 5. Inheritance icin bazı kurallar bulunmaktadir, class'ta constructor Overridable metot cagirmamalidir, private,statik vs. sorun olmayacaktir
 * 6. Asagidaki ornekte instant Parent constructor cagrildiginda null oldugu icin final obje icin hem null hem de valeu basmis olduk
 * 7. Bir classin inherit edilmesine izin vermemek icin classi final yapılması veya tum constructolarin private (veya package-private) constructor yaratılması gerekmektedir
 * @author korayk
 *
 */
public class Item19Demo {
	public static void main(String[] args) {
		Child child = new Child();
		child.overridableMethod();
	}
}

class Parent{
	public Parent() {
		overridableMethod();
	}
	
	public void overridableMethod() {
		
	}
}

class Child extends Parent{
	private final Instant instant;
	
	public Child() {
		instant = Instant.now();
	}
	
	@Override
	public void overridableMethod() {
		System.out.println(instant);
	}
}
