package com.kk.effectiveJava.chap4.item23;

/**
 * 1. Tagged classlar yerine class hiyerarsisi kullanmamizi onermektedir
 * 2. Tagged class kullandigimizda gereksiz kodlar olusacaktir ve error-prone olacaktir
 * 3. Tagged kullandigimizda asagidaki ornekteki gibi surekli caseli bir yapi kullanmak durumunda kalinmaktadir
 * 4. Ayrica yeni bir class geldiginde de caseleri artirmak yerine ilgili classi extend etmek daha saglikli olacaktir (Open/Closed)
 * @author korayk
 */
public class Item23Demo {
	public static void main(String[] args) {
		Figure rectangle = new Rectangle(10, 20);
		System.out.println(rectangle.area());
		
		Figure circle = new Circle(10);
		System.out.println(circle.area());
	}
}

abstract class Figure{
	abstract double area();
}

class Rectangle extends Figure{
	double width, height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	double area() {
		return width * height;
	}
}

class Circle extends Figure{
	double radius; 
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	double area() {
		return Math.PI * radius * radius;
	}
}



class FigureTagged{
	enum Type {Circle, Rectangle}
	
	private Type type;
	double radius;
	double width, height;
	
	public FigureTagged(double radius) {
		this.type = Type.Circle;
		this.radius = radius;
	}
	
	public FigureTagged(double width, double height) {
		this.type = Type.Rectangle;
		this.width = width;
		this.height = height;
	}
	
	double area() {
		if(type == Type.Circle) 
			return Math.PI * radius * radius;
		return width*height;
	}
}
