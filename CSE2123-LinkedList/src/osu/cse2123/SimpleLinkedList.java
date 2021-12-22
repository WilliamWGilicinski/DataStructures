package osu.cse2123;

/**
 * An interface for a simple linked list implementation
 *
 * @author Jeremy Morris
 * @version 20201001
 */

public interface SimpleLinkedList<E> {

	/**
	 * Adds an element to the front of a linked list
	 * @param element element to add to the front of the linked list
	 * @postcond linked list will have element as its first element
	 */
	public void addFront(E element);
	
	/**
	 * Removes the front element of a linked list
	 * @precond the linked list is not empty
	 * @postcond the linked list has the first element removed
	 * @return the old front element from the linked list
	 */
	public E removeFront();
	
	/**
	 * Adds an element to the end of a linked list
	 * @postcond the linked list has the element added to its end
	 * @param element element to be added to the end of the list
	 */
	public void addEnd(E element);
	
	/**
	 * Removes an element from the end of a linked list
	 * @precond the linked list has at least one element in it
	 * @postcond the linked list has the last element removed from it
	 * @return the old last element from the linked list
	 */
	public E removeEnd();
	
	/**
	 * Returns the front element of the queue without removing it.
	 * @precond the queue is not empty
	 * @return the front element of the queue
	 */
	public E front();
	
	/**
	 * Returns the end element of the queue without removing it.
	 * @precond the queue is not empty
	 * @return the end element of the queue
	 */
	public E end();
	
	/**
	 * Returns the number of elements in the linked list
	 * @return the number of elements in the linked list
	 */
	public int size();
}
