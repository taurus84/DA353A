package f7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	private E[] elements;
	private int size;
	
	private void grow() {
		int tempSize = elements.length * 2;
		E[] temp = (E[])new Object[tempSize];
		for(int i = 0; i < elements.length; i++) {
			temp[i] = elements[i];
		}
		elements = temp;
		
	}
	
	public ArrayList() {
		this(20);
	}
	
	public ArrayList(int initialCapacity) {
		initialCapacity = Math.max(1, initialCapacity);
		elements = (E[])new Object[initialCapacity];
	}

	/**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
	public void add(int index, E element) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		if(size==elements.length)
			grow();
		for(int i=size; i>index; i--) {
			elements[i]=elements[i-1];
		}
		elements[index] = element;
		size++;
	}

	/**
     * Appends the specified element to the end of this list 
     * @param element element to be appended to this list
     */	
	public void add(E element) {
		add(size,element);
	}
	
	/**
     * Inserts the specified element at the beginning of this list 
     * @param element element to be inserted at the beginning of this list
     */	
	public void addFirst(E element) {
		add(0, element);
	}

	/**
     * Appends the specified element at the end of this list 
     * @param element element to be appended at the end of this list
     */	
	public void addLast(E element) {
		add(size, element);
	}

	/**
     * Removes the element at the specified position in this list. Shifts
     * any subsequent elements to the left (subtracts one from their 
     * indices).  Returns the element that was removed from the list.
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
	public E remove(int index) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		E element = elements[index];
		size--;
		while(index < elements.length - 1) {
			elements[index] = elements[index + 1];
			index++;
		}
		return element;
	}
	
	/**
     * Removes and returns the first element from this list.
     * @return the first element from this list
     */
	public E removeFirst() {
		E element = elements[0];
//		size = elements.length - 1;
		size--;
		int index = 0;
		while(index < elements.length - 1) {
			elements[index] = elements[index + 1];
			index++;
		}
		return element;
	}

	 /**
     * Removes and returns the last element from this list.
     * @return the last element from this list
     */
	public E removeLast() {
		E element = elements[size -1];
		size--;
		
		return element;
	}

	/**
     * Removes all of the elements from this list. The list will be
     * empty after this call returns.
     */
	public void clear() {
		while(size < 0) {
			elements[size-1] = null;
			size--;
		}
	}

	 /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
	public E get(int index) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		return elements[index];
	}

	 /**
     * Replaces the element at the specified position in this list with the
     * specified element
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
	public E set(int index, E element) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		E prevElement = elements[index];
		remove(index);
		add(index, element);
		return prevElement;
	}

	 /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * @param element element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
	public int indexOf(E element) {
		
		int pos = -1;
		for(int i = 0; i < size; i++) {
			if(elements[i].equals(element)) {
				pos = i;
			}
		}
		return pos;
	}

	  /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element. The
     * search begins at startIndex in the list.
     * @param startIndex the search starts at position startIndex in the list
     * @param element element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
	public int indexOf(int startIndex, E element) {
	
		int pos = -1;
		if(startIndex < 0 || startIndex > size) {
			throw new IndexOutOfBoundsException();
		}
		for(int i = startIndex; i < size; i++) {
			if(elements[i].equals(element)) {
				pos = i; 
			}
		}
		return pos;
	}

	/**
     * Returns the number of elements in this list.  
     * @return the number of elements in this list
     */
	public int size() {
		return this.size;
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder("[ ");
		for(int i=0; i<size; i++) {
			res.append(elements[i]);
			if(i<size-1)
				res.append("; ");
		}
		res.append(" ]");
		return res.toString();
	}

	public Iterator<E> iterator() {
		return new Iter();
//		return new Iterator<E>() {
//			private int index=0;
//			
//			public boolean hasNext() {
//				return index<size;
//			}
//			
//			public E next() {
//				if(index==size)
//					throw new NoSuchElementException();
//				return elements[index++];
//			}
//			
//			public void remove() {
//				throw new UnsupportedOperationException();
//			}
//		};
	}
	
	private class Iter implements Iterator<E> {
		private int index=0;
		
		public boolean hasNext() {
			return index<size;
		}
		
		public E next() {
			if(index==size)
				throw new NoSuchElementException();
			return elements[index++];
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(10);
		for(int i=0; i<20; i++) {
			list.add(i);
		}
		System.out.println(list);
//		int elem = list.removeFirst();
//		int elem2 = list.removeFirst();
//		int elem3 = list.removeFirst();
		for(int i = 0; i < 10; i++) {
			list.removeLast();
		}
//		list.removeLast();
//		list.removeLast();
		int temp = list.set(4, 10);
		Iterator<Integer> numbers = list.iterator();
		while(numbers.hasNext()) {
			System.out.print(numbers.next()+ " ");
		}
		
		System.out.println();
		System.out.println(list.get(4));
		System.out.println(temp);
		System.out.println("Before clear");
		System.out.println(list.indexOf(0,10));
		System.out.println(list.indexOf(20,10));
//		list.clear();
		
		while(numbers.hasNext()) {
			System.out.print(numbers.next()+ " ");
		}
		System.out.println("After clear");
			
	}
}
