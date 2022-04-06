package com.kk.effectiveJava.chap4.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 1. Inheritance yerine composition kullanmamizi onermektedir
 * 2. Inheritance encapsulationi violate edebilir, yani parent metodun calisma prensibi degismesine gore child metot calismasi sorun yaratabilmektedir
 * 3. Asagidaki ornekteki gibi Parent HashSet addAll icin Collectiondaki her bir deger icin add metodunu cagirir bu yuzden count yanlis hesaplanacaktir
 * 4. Yeni versiyonda parent class icin yeniğ metotlar tanimlanabilmektedir, bu da ayrica sorun yaratabilecektir
 * 5. Inheritance sadece IS-A relationshipi kesinlikle varsa kullanilmalidir
 * 6. Javada aslinda Stack Vector degil, Properties Hashtable degil bunlar IS-A durumuna violate etmektedir
 * 7. IS-A olsa bile parent class extend edilmeye uygun olmayabilmektedir
 * 8. Bu sebeplerden dolayi Inheritance yerine Composition kullanmak saglikli olacaktir
 * 9. Burada Decorator Patterni yani Wrapper kullanarak istenilen Classi extend etmek yerine objeyi field olarak tutmak onerilmektedir
 * 10. Boylece istenildigi sekilde metotlar yazilabilecektir, asagidaki ornekte Forwarding classta set field olarak tutuldu ve ilgili classta yapilan islemler set uzerinden cagrildi
 * 11. Bu sekilde bir kullanim ile parenta yeni metot eklenmesi vs gibi durumlarda da sorun cikmayacaktir
 *  
 * @author korayk
 *
 */
public class Item18Demo {

	public static void main(String[] args) {
		
		// Inheritance Example
		InstrumentedHashSet<String> instrumentedHashSetExample = new InstrumentedHashSet<String>();
		instrumentedHashSetExample.add("4");
		instrumentedHashSetExample.add("5");
		instrumentedHashSetExample.addAll(Set.of("1", "2", "3"));
		System.out.println("Inheritance Set Count: " + instrumentedHashSetExample.count);
		
		// CompositionExample
		CompositionSet<String> compositionSet = new CompositionSet<String>(new HashSet<String>());
		compositionSet.add("4");
		compositionSet.add("5");
		compositionSet.addAll(Set.of("1", "2", "3"));
		System.out.println("Composition Set Count: " + compositionSet.count);
	}
}

// Inheritance
class InstrumentedHashSet<E> extends HashSet<E>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int count = 0;
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		count += c.size();
		return super.addAll(c);
	}
	
	@Override
	public boolean add(E e) {
		count += 1;
		return super.add(e);
	}
}

//Composition-Decorator
class CompositionSet<E> extends ForwardingSet<E>{

	int count = 0;
	
	public CompositionSet(Set<E> set) {
		super(set);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		count += c.size();
		return super.addAll(c);
	}
	
	@Override
	public boolean add(E e) {
		count += 1;
		return super.add(e);
	}
	
}

//Composition-Forwarding
class ForwardingSet<E> implements Set<E>{
	
	private final Set<E> set;
	public ForwardingSet(Set<E> set) {
		this.set = set;
	}
	public void forEach(Consumer<? super E> action) {
		set.forEach(action);
	}
	public int size() {
		return set.size();
	}
	public boolean isEmpty() {
		return set.isEmpty();
	}
	public boolean contains(Object o) {
		return set.contains(o);
	}
	public Iterator<E> iterator() {
		return set.iterator();
	}
	public Object[] toArray() {
		return set.toArray();
	}
	public <T> T[] toArray(T[] a) {
		return set.toArray(a);
	}
	public boolean add(E e) {
		return set.add(e);
	}
	public boolean remove(Object o) {
		return set.remove(o);
	}
	public boolean containsAll(Collection<?> c) {
		return set.containsAll(c);
	}
	public boolean addAll(Collection<? extends E> c) {
		return set.addAll(c);
	}
	public boolean retainAll(Collection<?> c) {
		return set.retainAll(c);
	}
	public boolean removeAll(Collection<?> c) {
		return set.removeAll(c);
	}
	public void clear() {
		set.clear();
	}
	public boolean equals(Object o) {
		return set.equals(o);
	}
	public int hashCode() {
		return set.hashCode();
	}
	public Spliterator<E> spliterator() {
		return set.spliterator();
	}
	public boolean removeIf(Predicate<? super E> filter) {
		return set.removeIf(filter);
	}
	public Stream<E> stream() {
		return set.stream();
	}
	public Stream<E> parallelStream() {
		return set.parallelStream();
	}
	
	
	
}