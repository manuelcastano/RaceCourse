package model;

public class Pqueue<T> implements Iqueue<T> {

	private ListNode<T> first;
	private ListNode<T> last;
	private int size;

	public Pqueue() {
		size = 0;	
	}

	public ListNode<T> getFirst() {
		return first;
	}

	public void setFirst(ListNode<T> first) {
		this.first = first;
	}

	public ListNode<T> getLast() {
		return last;
	}

	public void setLast(ListNode<T> last) {
		this.last = last;
	}

	public int size() {
		return size;
	}

	@Override
	public void enqueue(T element) {
		ListNode<T> toAdd = new ListNode<T>(element);
		if (first == null) {
			first = toAdd;
			last = toAdd;
		} else {
			last.setNext(toAdd);
			last = toAdd;
		}
		size++;
	}

	@Override
	public T dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("The queue is empty");
		}
		size--;
		T element = first.getElement();
		first = first.getNext();
		return element;
	}

	@Override
	public T front() throws Exception {
		if (isEmpty()) {
			throw new Exception("The queue is empty");
		}
		return first.getElement();
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

}
