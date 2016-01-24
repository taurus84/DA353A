package f7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>, Iterable<E> {
    private ListNode<E> list = null;
    
    private ListNode<E> locate(int index) {
        ListNode<E> node = list;
        for( int i = 0; i < index; i++)
            node = node.getNext();
        return node;
    }
    
    public int size() {
        int n = 0;
        ListNode<E> node = list;
        while( node != null ) {
            node = node.getNext();
            n++;
        }
        return n;
    }
    
    public E get( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        ListNode<E> node = locate( index );
        return node.getData();
    }
    
    public E set( int index, E data ) { 
    	return null;
    }
    
	public void add(E data) {
	}

    public void addFirst( E data ) {
    }
    
    public void addLast( E data ) {
    }
    
    public void add( int index, E data ) {
    }
    
    public E removeFirst() {
    	return null;
    }
    
    public E removeLast() {
    	return null;
    }
    
    public E remove( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        E res;
        if( index == 0 ) {
            res = list.getData();
            list = list.getNext();
        } else {
            ListNode<E> node = locate( index - 1 );
            res = node.getNext().getData();
            node.setNext( node.getNext().getNext() );
        }
        return res;
    }

	public void clear() {
	}
	
	public int indexOf(E data) {
		return -1;
	}

	public int indexOf(int startIndex, E data) {
		return -1;
	}

	public Iterator<E> iterator() {
		return new Iter();
	}    
    
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }
    
    private class Iter implements Iterator<E> {
    	
    	public boolean hasNext() {
    		return false;
    	}
    	
    	public E next() {
    		return null;
    	}
    	
		public void remove() {
			throw new UnsupportedOperationException();
		}
    }
}
