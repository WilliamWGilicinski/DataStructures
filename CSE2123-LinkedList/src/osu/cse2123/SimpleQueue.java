package osu.cse2123;

/**
 * An interface for a simple queue implementation
 *
 * @author Jeremy Morris
 * @version 20201001
 */
public interface SimpleQueue<E> {
	
	/**
	 * Adds an element to the end of the queue
	 * @param val element to be added to the end of the queue
	 * @postcond the queue has val as its last element
	 */
	public void add(E val);
	
	/**
	 * Retrieves the front of the queue without removing it
	 * 
	 * @precond the queue is not empty
	 * @return the first element of the queue
	 */
	public E front();
	
	/**
	 * Removes an element from the front of the queue
	 * 
	 * @precond the queue is not empty
	 * @postcond the queue has the first element removed
	 * @return the element removed from the front of the queue
	 */
	public E remove();
	
	/**
	 * Returns the number of elements in the queue
	 * 
	 * @return the number of elements in the queue
	 */
	public int size();

}
