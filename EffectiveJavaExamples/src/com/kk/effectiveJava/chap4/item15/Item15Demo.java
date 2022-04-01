package com.kk.effectiveJava.chap4.item15;

/**
 * 1. Classlara ve memberlarina erisimin mumkun oldukca kisitlanmasi gerektigi belirtilmektedir
 * 2. Ornegin bir metodu public yaptigimizda onu disarida kullananlar icin daima maintain etmemiz gerekecektir
 * 3. child class, parent classin memberini daha restricted yapamamaktadir
 * 4. length'i 0 olmayan bir array daima mutabledir, bu yuden bu arrayi public yapmayip, karsilik gelen Unmodifiablelist'i public yapmak saglikli olacaktir
 * 5. Bu acidan public static final verdigimiz bir objenin immutable oldugundan emin olunmasi gerekmektedir
 * 5. java-9'daki module yapisi ile de bazi accessebility restrictionlar uygulanabilmektedir
 * 6. Verdigimiz constantlar haric, public classlarin public fieldi olmamalidir
 * @author korayk
 *
 */
public class Item15Demo {
	
	public static void main(String[] args) {
		Parent.strArr[2] = "Custom";
		System.out.println(Parent.strArr[2]);
	}
}

class Parent{
	
	private String name;
	private String surname;
	
	// can be changed
	public static final String[] strArr = {"1", "2", "3"};
	public static final String CONSTANT = "CONSTANT";
	
	
	protected String getNameSurname() {
		return this.name + " " + this.surname;
	}
}

class Child extends Parent{
	@Override
	public String getNameSurname() {
		return super.getNameSurname();
	}
}
