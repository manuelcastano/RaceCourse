package model;

import java.lang.reflect.Array;

public class HashTable<T> implements Hash<T>{
	
	private Chaining<T> elements[];

	public HashTable() {
		elements = (Chaining<T>[])Array.newInstance(Chaining.class, 100);
	}
	
	public int convertStringToInteger(String text) throws Exception {
		int outcome = 0;
		int cont = 0;
		for(int i = text.length()-1; i >=0; i--) {
			if((int)text.charAt(i) < 48 || (int)text.charAt(i) > 57) {
				throw new Exception("The character " + text.charAt(i) + " Isn't a number");
			} else {
				outcome += ((int) text.charAt(i))*Math.pow(128, cont);
				cont++;
			}
		}
		return outcome;
	}

	@Override
	public int hashFunction(String key) {
		int integer = 0;
		try {
			integer = convertStringToInteger(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return integer % elements.length;
	}

	@Override
	public void insert(T element, String key) {
		int index = hashFunction(key);
		Chaining<T> c = (Chaining<T>) elements[index];
		if(c == null) {
			c = new Chaining<T>();
		}
		c.insert(element, key);
	}

	@Override
	public T search(String key) {
		int index = hashFunction(key);
		Chaining<T> c = (Chaining<T>) elements[index];
		if(c == null) {
			c = new Chaining<T>();
		}
		T outcome = c.search(key);
		return outcome;
	}

	@Override
	public void delete(String key) {
		int index = hashFunction(key);
		Chaining<T> c = (Chaining<T>) elements[index];
		if(c == null) {
			c = new Chaining<T>();
		}
		c.delete(key);
	}
}
