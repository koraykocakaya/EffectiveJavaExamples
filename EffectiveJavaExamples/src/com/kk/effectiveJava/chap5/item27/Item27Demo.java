package com.kk.effectiveJava.chap5.item27;

import java.util.Arrays;

/**
 * 1. Unchecked warninglerden mumkun oldukca kurtulmamizi onermektedir
 * 2. Hepsinden kurtuldugumuzda kodun tamamen type safe olduguna emin olabiliriz
 * 3. Typesafe olduguna emin oldugumuz durumda @SuppressWarnings("unchecked") ekleyebiliriz
 * 	Bu annotationi mumkun olan en dar scopeta kullanmaliyiz
 * 4. @SuppressWarnings ile birlikte aciklayici bir uyari verilmesi de saglikli olacaktir
 * @author korayk
 */
public class Item27Demo {

	
	int size;
	transient Object[] elements;
	
	// ArrayList implementation
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			// direkt return yerine ayri bir local variable setleyerek scope'u azaltabildik
			@SuppressWarnings("unchecked")
			T[] returnArr = (T[]) Arrays.copyOf(elements, size, a.getClass());
			return returnArr;
		}
		System.arraycopy(elements, 0, a, 0, size);
		if (a.length > size)
		a[size] = null;
		return a;
	}
}
