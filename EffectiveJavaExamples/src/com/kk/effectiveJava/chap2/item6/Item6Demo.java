package com.kk.effectiveJava.chap2.item6;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * 
 * Gereksiz yere obje yaratmaktan kacinmamizi onermektedir <br>
 * 1. String yaratirken new kullanmamliyiz boylece her bir Stringi setledigimizde poolda varsa onu kullanacaktir <br>
 * 2. Constructor yerine static factory kullanarak gereksiz obje yaratmaktan kacinilabilmektedir <br>
 * 3. Surekli kullanacagimiz ayni objeleri bir defa yaratmaya ozen gostermemiz gerekmektedir <br>
 * 4. Mumkun oldukca boxed primitiveler yerine primitivelerin kullanilmasi gerekmektedir, cunku boxed primitive her islemde yeni bir obje yaratacaktir <br>
 * 5. Bu madde mumkun oldukca ayni objeyi kullanmamizi tavsiye etmekte ancak yeni objeye ihtiyacimiz oldugunda eskiyi kullanmamamiz gerektigini de belirtmektedir<br>
 * 
 * @author korayk
 *
 */
public class Item6Demo {

	private static final Pattern ROMAN = Pattern.compile(
			"^(?=.)M*(C[MD]|D?C{0,3})"
			+ "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	
	public static void main(String[] args) {
		
		Item6Demo demo = new Item6Demo();
		Boolean.valueOf("true");
		
		//Deprecated, bosuna obje olusturmakta
		//new Boolean("true");
		
		int repetition = 100000;
		String romanExample = "MCMLXXVI";
		long beginTime = new Date().getTime();
		
		for(int i=0; i<repetition; i++) {
			demo.isRomanNumeralWithStaticPattern(romanExample);
		}
		
		long endTime = new Date().getTime();
		System.out.println("Time for static pattern: " + (endTime - beginTime) +  " ms");
		
		beginTime = new Date().getTime();
		
		for(int i=0; i<repetition; i++) {
			demo.isRomanNumeral(romanExample);
		}
		
		endTime = new Date().getTime();
		System.out.println("Time for Regex: " + (endTime - beginTime) +  " ms");
		
		demo.compareExecutionTimeForPrimitiveAndBoxedPrimitive();
	}
	
	public void compareExecutionTimeForPrimitiveAndBoxedPrimitive() {
		
		int size = Integer.MAX_VALUE;
		long sum = 0;
		long beginTime = new Date().getTime();
		for(int i=0; i<size; i++) {
			sum += i;
		}
		long endTime = new Date().getTime();
		System.out.println("For loop with int: " + (endTime - beginTime) + " ms, sum is: " + sum);
		
		Long sumBoxing = (long) 0;
		beginTime = new Date().getTime();
		for(int i=0; i<size; i++) {
			sumBoxing += i;
		}
		endTime = new Date().getTime();
		System.out.println("For loop with int: " + (endTime - beginTime) + " ms, sum is: " + sumBoxing);
	}
	
	public boolean isRomanNumeralWithStaticPattern(String s) {
		return ROMAN.matcher(s).matches();
	}
	
	public boolean isRomanNumeral(String s) {
		return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
				+ "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	}
}
