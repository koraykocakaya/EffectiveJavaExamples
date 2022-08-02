package com.kk.effectiveJava.chap5.item26;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1. Raw typelarin kullanilmamasini onermektedir
 * 2. Ornegin bir Collection yaratacagimiz zaman Collection yerine Collection<String> vs. yaratmamiz daha saglikli olacaktir
 * 3. Boylece bu Collectiona farkli tiplerde Objectler eklenmesinin onune gecilecektir
 * 4. List<Object> kullanmak raw type kullanmaktan daha saglikli olacaktir, boylece cast aninda Compileda uyari verecektir
 * 	raw kullandigimizda ornekteki gibi get durumunda cast hatasi atacaktir
 * 5. raw type kullanmak yerine Unbounded wildcard kullanmamiz type safety adina saglikli olacaktir
 * 6. raw type'i List.class gibi literal icin kullanabiliriz
 * 	Ayrica instanceOf operatoru icin de kullanilmaktadir, ancak sonrasinad set tipinde ise onu Set<?> cast etmek gerekmektedir 
 * @author korayk
 */
public class Item26Demo {

	static Collection collection; 
	
	public static void main(String[] args) {
		Item26Demo demo = new Item26Demo();
		Object o = new HashSet<String>();
		if(o instanceof Set) {
			Set<?> rSet = (Set<?>)o;
			System.out.println(rSet);
		}
		
		demo.addFunc();
	}
	
	public void addFunc() {
		List<String> strList = new ArrayList<>();
		// List<String> List<Object> cast edilemez
//		add(strList, Integer.valueOf(10));
		addWithoutTypeSafety(strList, Integer.valueOf(10));
		
		// Gette Integer oldugu icin hata atacaktir
		System.out.println(strList.get(0)); 
		
	}
	
	public void add(List<Object> liste, Object o) {
		liste.add(o);
	}
	
	public void addWithoutTypeSafety(List liste, Object o) {
		liste.add(o);
	}
	
	public int numElementsInCommon(Set<?> s1, Set<?> s2) {
		
		int result = 0;
		for (Object o1 : s1)
			if (s2.contains(o1))
				result++;
		return result;
		
	}
}
