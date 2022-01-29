package com.kk.effectiveJava.chap2.item4;

/**
 * 
 * Instantiate edilmesi istenmeyen classlara default private constructor ekleyerek bunun engellenmesi onerilmektedir <br>
 * 1. Utility gibi classlar icin default private constructor ekleyip kullanicinin kazara bile olsa instantiate edilmesi engellenmelidir <br>
 * 2. Bu constructorda da hata firlatmak saglikli olabilecektir, cunku class icinden de bu constructor cagrilabilecektir  <br>
 * 3. Bu sekilde bu classin extend edilmesinin de onune gecmis oluruz <br>
 * @author korayk
 */
public class Item4Demo {
	public static void main(String[] args) {
		
	}
}

class Utility{
	private Utility(){
		throw new AssertionError();
	}
}