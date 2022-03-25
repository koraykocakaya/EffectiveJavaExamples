package com.kk.effectiveJava.chap3.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Clone islemini dikkatle yapmamiz gerektigini ogutlemektedir.
 * 1. Stack orneginde oldugu gibi icinde mutable obje tutan classlarda clone sonrasi ana objede degisiklik yaptigimizda clone edilen obje de bundan etkilenecektir
 * Bu tarz durumlar icin clone metodunun icinde ilgili objeleri de kopyalamak gerekli olacaktir
 * @author korayk
 *
 */
public class Item13Demo {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person();
		Person p2 = p1.clone();

		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		
		Stack s1 = new Stack();
		s1.push("s1");
		s1.push("s2");
		
		Stack s2 = (Stack) s1.clone();
		s1.push("s3");
		System.out.println(s2.getSize());
	}
}

class Person implements Cloneable {
	@Override
	protected Person clone() throws CloneNotSupportedException {

		return (Person) super.clone();
	}
}

class Stack implements Cloneable {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 1;

	public Stack() {
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		Object result = elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return result;
	}

// Ensure space for at least one more element.
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
	
	public int getSize() {
		return this.elements.length;
	}
	
	@Override
	protected Stack clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Stack)super.clone();
	}
}
