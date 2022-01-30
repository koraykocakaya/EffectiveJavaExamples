package com.kk.effectiveJva.chap2.item7;

import java.util.WeakHashMap;

/**
 * 
 * Obsolete obje referanslarini elimine etmeyi onermektedir. <br>
 * 1. Elimizde bir stack (array) oldugunu dusunursek bir elemani pop ettikten sonra arrayde o elemani nulla cekmemiz gerekmektedir <br>
 * 2. Herhangi bir obje kullanilmayacaksa onu null yapmazsak bosuna memoryde yer isgal edecektir <br>
 * 3. İlgili obje kullanilmadiginda zaten GC tarfindan temizlenecektir ancak 1.maddedeki array gibi kullanmaya devam ettiggimiz yapilarda onemli olacaktir <br>
 * 4. GC'nin gerekli yerde calisabilmesi adina bir fieldi en dar scope'ta tanimlamak daha saglikli olacaktir<br>
 * 5. Benzer sekilde cachelerde unutulan verilerd de memory leake sebep olabilmektedir, belirli bir surede temizlenmesi veya guncellenmesi gerekmektedir <br>
 * 6. Bu acidan WeakHashMap kullanmak mantikli olabilecektir, WHM keylerine sadece weak referanslar tutar ve kullanilmadiginda bu enrtyi mapten silecektir
 * @author korayk
 *
 */
public class Item7Demo {

	public Integer[] array;
	static int NUM_OF_ELEMENT = 10;
	private int pointer = 0;
	
	public static void main(String[] args) {
		Item7Demo Item7Demo = new Item7Demo();
		Item7Demo.push(3);
		Item7Demo.push(7);
		Item7Demo.pop();
		// 7 popladiktan sonra nulla setledi, boylece ayni zamanda hatali kayit riskini de halletmis olduk
		System.out.println(Item7Demo.array[1]);
		
		// WeakHashMap Example
		WeakHashMap<Item7Demo, String> map = new WeakHashMap<Item7Demo, String>();
		Item7Demo key1 = new Item7Demo();
		Item7Demo key2 = new Item7Demo();
		
		
		map.put(key1, "val1");
		map.put(key2, "val2");
		key1= null;
		System.gc();
		
		// weak ref oldugu icin key1 null oldgugunda ilgili kaydi mapten cikarir
		System.out.println(map);
	}
	
	public Item7Demo(){
		array = new Integer[NUM_OF_ELEMENT];
	}
	
	public void push(Integer value) {
		array[pointer++] = value;
	}
	
	public Integer pop() {
		Integer value = array[--pointer];
		// eger bunu yapmazsak bosuna memoryde yer isgal edecektir
		array[pointer] = null;
		return value;
	}
	
	
	
	
}
