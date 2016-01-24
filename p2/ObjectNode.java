package p2;

/**
 * The class is for creating nodes to be implemented into a list. Each node contains data, and every node can point 
 * forward and backwards to other nodes
 * 
 * @author David Tran
 * Date: March 4th 2015
 */

public class ObjectNode<E> {

	//instance variables. Each node contains data, a forward and backwards pointing to other nodes
	private Object data;
	private ObjectNode<E> next;
	private ObjectNode<E> prev;

	/**
	 * Constructor for a node
	 * @param data the data in the node
	 * @param prev the node to point backwards on
	 * @param next the node to point forward on
	 */
	public ObjectNode(Object data, ObjectNode<E> prev, ObjectNode<E> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	/**
	 * The method returns the node that this node is pointing forward to.
	 * @return ObjectNode<E> the post node
	 */
	public ObjectNode<E> getNext() {
		return next;
	}

	/**
	 * The method redirects the post node
	 * @param next the node to point forward on
	 */
	public void setNext(ObjectNode<E> next) {
		this.next = next;
	}

	/**
	 * The method returns the node that this node is pointing backward on
	 * @return ObjectNode<E> the previous node
	 */
	public ObjectNode<E> getPrev() {
		return prev;
	}

	/**
	 * The method redirects the pre node
	 * @param prev the node to point backward on
	 */
	public void setPrev(ObjectNode<E> prev) {
		this.prev = prev;
	}

	/**
	 * The mehod returns the data in the node
	 * @return Object the data in the node
	 */
	public Object getData() {
		return data;
	}
	
	public String toString() {
    	StringBuilder str = new StringBuilder("[ ");
    	str.append(data.toString());
    	ObjectNode node = next;
        while( node!=null ) {
        	str.append( ", ");
            str.append( node.getData().toString() );
            node = node.getNext();
        }
        str.append( " ]");
        return str.toString();
    }
	
	

}
