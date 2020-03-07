package model;

public interface Hash<T> {
	
	public int hashFunction(String key);
	public void insert(T element, String key);
	public T search(String key);
	public void delete(String key);
}
