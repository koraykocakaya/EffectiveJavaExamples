package com.kk.effectiveJava.chap3.item14;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1. Comparator kullanirken nasil tasarlamamiz gerektigini anlatmaktadir
 * 2. Comparable yapisi equals ile uyumlu olmasi gerekmektedir, yani x.compareto(y) == 0 ise x.equals(y) true donmesi gerekmektedir
 * 3. equals gibi reflexivity, symmetry ve trasivity uyması gerekmektdir
 * 4. Most significant fielddan baslayarak, least significant giderek comparison yapmak saglikli olacaktir
 * 5. Comparator static metotlari (comparing, thenComparingInt gibi) yardimiyla da tanimlayabiliriz, bu sekilde tanimlamak daha anlasilir olacaktir
 * 6. hashcode uzerinden comparator yazmak istiyorsak, direkt farkliari uzerinden degil bunu Integer.compare ile yapmak saglikli olacaktir
 * @author korayk
 *
 */
public class Item14Demo {
	public static void main(String[] args) {
		List<Car> carList = Arrays.asList(new Car("BMW", "3.20", 2015),
										  new Car("BMW", "3.18", 2015),
										  new Car("BMW", "3.20", 2021),
										  new Car("Mercedes", "C180", 2015));
		Collections.sort(carList);
		System.out.println(carList);
	}
}

class Car implements Comparable<Car>{
	private String brand;
	private String model;
	private int year;
	
	private static final Comparator<Car> comparator = Comparator.comparing((Car car) -> car.getBrand())
																.thenComparing(car -> car.getModel())
																.thenComparingInt(car -> car.getYear());
	
	private static final Comparator<Car> hashComparator = new Comparator<Car>() { // Comparator.comparingInt((Car car) -> car.hashCode()) olarak da yapabiliriz
		@Override
		public int compare(Car o1, Car o2) {
			return Integer.compare(o1.hashCode(), o2.hashCode());
		}
	};
	
	public Car(String brand, String model, int year) {
		super();
		this.brand = brand;
		this.model = model;
		this.year = year;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public int compareTo(Car o) {
		return comparator.compare(this, o);
//		int value = this.getBrand().compareTo(o.getBrand());
//		if(value == 0) {
//			value = this.getModel().compareTo(o.getModel());
//			if(value == 0) {
//				value = this.getYear() - o.getYear();
//			}
//		}
//		return value;
	}
	
	@Override
		public String toString() {
			return "[brand:" + this.getBrand() + ", model: " + this.getModel() + ", year: " + this.getYear() + "]";
		}
	
}
