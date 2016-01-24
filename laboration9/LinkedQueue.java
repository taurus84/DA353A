package laboration9;

import f9.Queue;
import f9.QueueException;
import f7.LinkedList;

public class LinkedQueue<E> implements Queue<E> {
	private LinkedList<E> list = new LinkedList<E>();

	public void enqueue(E data) {
		list.add(size(), data);
	}

	public E dequeue() {
		if (empty()) {
			throw new QueueException("dequeue: Queue is empty");
		}
		return list.remove(0);
	}

	public E peek() {
		if (empty()) {
			throw new QueueException("peek: Queue is empty");
		}
		return list.get(0);
	}

	public boolean empty() {
		return list.size() == 0;
	}

	public int size() {
		return list.size();
	}
}