package model;

public class Chaining<T> {
	
	private ListNode<T> first;

	public ListNode<T> getFirst() {
		return first;
	}

	public void setFirst(ListNode<T> first) {
		this.first = first;
	}
	
	public void insert(T element, String key) {
		ListNode<T> ln= new ListNode<T>(element);
		ln.setKey(key);
		ln.setNext(first);
		first = ln;
	}
	
	public T search(String key) {
		T outcome = null;
		ListNode<T> actual = first;
		while(actual != null) {
			if(actual.getKey().equals(key)) {
				outcome = actual.getElement();
				actual = null;
			} else {
				actual = actual.getNext();
			}
		}
		return outcome ;
	}
	
	public void delete(String key) {
		if(first.getKey().equals(key)) {
			first = first.getNext();
		} else {
			ListNode<T> actual = first;
			boolean finded = false;
			while(actual.getNext() != null && !finded) {
				if(actual.getNext().getKey().equals(key)) {
					actual.setNext(actual.getNext().getNext());
					finded = true;
				}
				actual = actual.getNext();
			}
		}
	}
}
