package osu.cse2123;
/**
 * An interface for a simple stack
 *
 * @author Jeremy Morris
 * @version 20201001
 */

public interface SimpleStack<E> {



    /**
     * Adds an element to the top of the stack
     * @param element element to be added to the stack
     * @postcond  element is now at the top of the stack
     */
    public void push(E element);

    /**
     * Removes an element from the top of the stack
     * @precond stack is not empty
     * @postcond  head element has been removed
     * @return old head element from the stack
     */
    public E pop();
    
	/**
	 * Returns the top of the stack without removing it.
	 * @precond the stack is not empty
	 * @return top element of stack
	 */
    public E top();

    /**
     * Returns the number of items in the stack
     * @return the number of elements in the stack
     */
    public int size();
    


}
