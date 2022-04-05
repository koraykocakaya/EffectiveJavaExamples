package com.kk.effectiveJava.chap4.item17;

import java.math.BigDecimal;

/**
 * 1. Mutability'i minimize etmemizi onermektedir
 * 2. Classi immutable yapmak icin bazi kurallar tanimlanmaktadir
 * 2.1 Objenin durumunu degistirecek metotlar olmamalidir (mutator)
 * 2.2 Tum fieldlar final ve private olmalidir
 * 2.3 Objedeki mutable componenta erisim kisitlanmalidir (direkt accessor ile vs return edilmemeli)
 * 3. Functional paradigm kullanilmaktadir, yani bir islem yaptigimizda objeyi modify etmez yenisini return eder, bu yuzden asagidaki ornekte de metot adi add yerine plus kullanilmaktadir
 * 4. Immutable objeler thread-safe, bu yuzden ekstra bir kontrole ihtiyac duymamaktadir
 * 5. Her bir ayri deger icin yeni obje yaratmamiz gerektigi icin costly olabilmektedir.
 * 6. Bunun icin immutable classlarin companion classlari kullabilabilmektedir (String icin StringBuilder companion class gibi)
 * 7. Static class yardimiyla yeni obje return ederek de kullanabiliriz (private constructor ile), boylece classi final olmadan da kullabilmektedir (Item1)
 * 8. Immutable classlar icinde bazi degerleri cacheleyip hep ayni degerlerin donulmesi saglanabilmektedir (String hashcode'da oldugu gibi-Lazy Initialization)
 * 9. Bir classi immutable yapamasak bile elimizden geldigince mutability azaltilmalidir
 * @author korayk 
 *
 */
public class Item17Demo {

	public static void main(String[] args) {
		Complex c1 = new Complex(10, 12);
		Complex c2 = c1.plus(10, 10);
		
		// c1 degismez, yeni obje yaratildi
		System.out.println(c1);
		System.out.println(c2);
		
		BigDecimal value = new BigDecimal(100);
		// yeni obje return eder, eski modify edilmez
		value.add(BigDecimal.TEN);
		
		System.out.println(value);
	}
}

final class Complex{
	private final double real;
	private final double imaginary;
	
	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public double getReal() {
		return real;
	}
	public double getImaginary() {
		return imaginary;
	}
	
	public Complex plus(double real, double imaginary) {
		return new Complex(this.real + real, this.imaginary + imaginary);
	}
	
	@Override
	public String toString() {
		return "[real: " + real + ", imaginary: " + imaginary + "]";
	}
	
}
