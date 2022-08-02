package com.kk.effectiveJava.chap4.item24;

/**
 * 1. Static member classlari nonstatic member classlara gore kullanmamizi ogutlemektedir
 * 2. Non-static member classlar veya nanoymous classlar memory leake sebep olabilmektedir
 * 3. Static member objesi yaratirken outer class objesi yaratmak gerekmeyecektir
 * @author korayk
 */
public class Item24Demo {

	public static void main(String[] args) {
		Outer.StaticInner staticInner = new Outer.StaticInner();
		System.out.println(staticInner);
		
		
		// non-static icin outer objesi yaratilmak zorunda
		Outer outer = new Outer();
		Outer.NonStaticInner nonStaticInner = outer.new NonStaticInner();
		System.out.println(nonStaticInner);
	}
}

class Outer{
	static class StaticInner{
		
	}
	
	class NonStaticInner{
		
	}
}
