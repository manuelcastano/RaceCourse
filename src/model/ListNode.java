package model;

public class ListNode<T> {
	
	private ListNode<T> next;
	private T element;
	
	public ListNode(T element) {
		this.element = element;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}
}
