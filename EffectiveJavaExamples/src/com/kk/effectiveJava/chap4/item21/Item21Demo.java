package com.kk.effectiveJava.chap4.item21;

/**
 * 
 * 1. Java-8 oncesi existing interfacelere method eklemek sorun olabilmekteydi, Java-8 ile default method ekleyerek bu sorun cozulebildi
 * 2. Ancak bu durumda da default behavior eklendigi ve bu behavior onu Override etmeyenler icin sorun yaratabileceginden kullanimi sorun yaratabilecektir
 * 3. Ornegin Collectiondaki default removeIf metodu Apache commonsdaki List icin saglikli calismamakta (synchronized oldugu icin)
 * 4. Bu yuzden default method eklendiginde ekstra detayli testler ile yapilmasi gerekli olacaktir
 * @author korayk
 */
public class Item21Demo {
	
	class List implements Collection{
		// Onceden de implement etmekteydi, removeIf'i ayrica Override etmezse default davranis sorun yaratabilir
	}
	
	interface Collection{
		
		default void removeIf() {
			
		}
	}
}
