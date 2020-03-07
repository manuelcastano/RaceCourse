package model;

import java.util.ArrayList;
import java.util.List;

public class HashTable<T> implements Hash<T>{
	
	private ArrayList<T> elements[];

	public HashTable() {
		
	}

	public ArrayList<T>[] getElements() {
		return elements;
	}

	public void setElements(ArrayList<T>[] elements) {
		this.elements = elements;
	}

	@Override
	public int hashFunction(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(T element, String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T search(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub
		
	}
}
