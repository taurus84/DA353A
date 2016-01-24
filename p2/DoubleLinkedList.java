package p2;

/**
 * The class creates and manipulates a queue containing ObjectNode<E> which contains any sorts of data. 
 * The class can add/remove nodes and get info for every node in queue
 * 
 * @author David Tran
 * Date: March 4th 2015
 *
 * @param <E>
 */
public class DoubleLinkedList<E> {

	private ObjectNode<E> list = null;

	/**
	 * Method return the size of the linked list
	 * 
	 * @return the size of the list
	 */
	public int size() {
		int n = 0;
		ObjectNode<E> node = list;
		while (node != null) {
			node = node.getNext();
			n++;
		}
		return n;
	}

	/**
	 * Method to get a node from a specific index in the list
	 * 
	 * @param index the index which node to be returned
	 * @return the node on the specified index
	 */
	public ObjectNode<E> locate(int index) {
		ObjectNode<E> node = list;
		for (int i = 0; i < index; i++)
			node = node.getNext();
		return node;
	}

	/**
	 * The method to add a node to the list
	 * 
	 * @param index the place for the new node
	 * @param data the data in the new node
	 */
	public void add(int index, Object data) {
		// index cannot be negative or bigger than size. If equal to size it
		// will be put last in list.
		if ((index < 0) || (index > size()))
			throw new IndexOutOfBoundsException("size=" + size() + ", index=" + index);

		// if putting in first position the new node will point forward to the
		// old list, then list will point to the new list.
		if (index == 0)
			list = new ObjectNode<E>(data, null, list);
		// creating two temp nodes.
		else {
			// nodePrev is the node on the index before the index of the new node
			ObjectNode<E> nodePrev = locate(index - 1);
			// nodeNext is the node who had the index for the new node
			ObjectNode<E> nodeNext = nodePrev.getNext();
			// the new node will point back on nodePrev and forward on nodeNext
			ObjectNode<E> newNode = new ObjectNode<E>(data, nodePrev, nodeNext);
			// nodePrev must now point forward on the new node
			nodePrev.setNext(newNode);
			// if index was to be the position after the rest of nodes (last in
			// queue) nodeNext would be null and no repointing would be necessary.
			// If NOT the case, nodeNext must the point back on th new node
			if (nodeNext != null)
				nodeNext.setPrev(newNode);
		}
	}

	/**
	 * The method adds a new node on first position/index
	 * 
	 * @param data the data in the new node
	 */
	public void addFirst(Object data) {
		add(0, data);
	}

	/**
	 * The method adds a node on the last place/index
	 * 
	 * @param data the data in the new node
	 */
	public void addLast(Object data) {
		add(size(), data);
	}

	/**
	 * The method removes a node from the list and returns the node
	 * 
	 * @param index the index of the node to be removed
	 * @return the removed node
	 */
	public Object remove(int index) {
		if ((index < 0) || (index >= size()))
			throw new IndexOutOfBoundsException("size=" + size() + ", index=" + index);

		Object res;
		// If want to remove first position, let list point on next node in list. After saving the data from the the node to be removed
		// Andra pos måste då peka på null på previous. What the new first node points back on is irrelevant.
		if (index == 0) {
			res = list.getData();
			list = list.getNext();
//			list.setPrev(null);
		} else {
			// Locate the node before index
			ObjectNode<E> indexMinus1 = locate(index - 1);
			// indexPlus1 is the node after the node to be removed
			ObjectNode<E> indexPlus1 = indexMinus1.getNext().getNext();
			// res is the data in the node to be removed
			res = indexMinus1.getNext().getData();
			// indexMinus1 must now point forward on the one the removed on was pointing forward to
			indexMinus1.setNext(indexPlus1);
			// if indexPlus1 is a node it must point backwards on indexMinus1, which the node on index was pointing backward on
			if (indexPlus1 != null) {
				indexPlus1.setPrev(indexMinus1);
			}
		}
		return res;
	}

	/**
	 * The method removes the node in the last position and returns the data in the node
	 * 
	 * @return Object the data in the removed node
	 */
	public Object removeLast() {
		return remove(size() - 1);
	}

	/**
	 * The method removes the node in the first position and returns the data in the node
	 * 
	 * @return Object the data in the removed node
	 */
	public Object removeFirst() {
		return remove(0);
	}

	/**
	 * The method gets the data from a node in a specific index
	 * 
	 * @param index the index for which data in node to be received
	 * @return Object the data in the node
	 */
	public Object get(int index) {
		return locate(index).getData();
	}

	/**
	 * The method gets the data from the node in first position
	 * 
	 * @return Object the data in the node
	 */
	public Object getFirst() {
		return locate(0).getData();
	}

	/**
	 * The method gets the data from the node in the last position
	 * 
	 * @return Object the data in the node
	 */
	public Object getLast() {
		return locate(size() - 1).getData();
	}

	/**
	 * The method clears the list by pointing the list to null
	 */
	public void clear() {
		list = null;
	}

	public String toString() {
		if (list != null)
			return list.toString();
		else
			return "[]";
	}
}
