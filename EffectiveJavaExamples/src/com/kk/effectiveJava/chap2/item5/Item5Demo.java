package com.kk.effectiveJava.chap2.item5;

/**
 * 
 * Resourcelari birbirine baglarken Dependency Injection kullanmamizi onermektedir.<br>
 * 1. Direkt class icinde instantiate etmek yerine Inject etmek (constructor, builder veya factory ile) daha saglikli olacaktir. <br>
 * 2. Static utility ve Singleton classlar underlying objelere gore behaviorun degismesine uygun degillerdir, gelistirme buna gore yapilmalidir <br>
 * 3. Dependency Injection ile farklı tiplerde obje gecebilecegimiz icin flexibility, reusability ve testability artacaktir.
 * @author korayk
 *
 */
public class Item5Demo {
	public static void main(String[] args) {
		Dictionary dictionaryTurkish = new TurkishDictionary();
		Dictionary dictionaryEnglish = new EnglishDictionary();
		// test yaziyor olsak test Dictionary ile SpellChecker'i initialize edebilirdik
		SpellChecker spellCheckerForTurkish = new SpellChecker(dictionaryTurkish);
		SpellChecker spellCheckerForEnglish = new SpellChecker(dictionaryEnglish);
		System.out.println(spellCheckerForTurkish);
		System.out.println(spellCheckerForEnglish);
	}
}

class SpellChecker{
	private Dictionary dictionary;
	
	public SpellChecker(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	
	public Dictionary getDictionary() {
		return this.dictionary;
	}
	@Override
	public String toString() {
		return "Dictionary in " + dictionary.getName() + " language";
	}
}

interface Dictionary{
	public String getName();
} 

class TurkishDictionary implements Dictionary{
	
	@Override
	public String getName() {
		return "Turkish";
	}
}

class EnglishDictionary implements Dictionary{
	
	@Override
	public String getName() {
		return "English";
	}
}
