package osu.cse2123;

/**
 * An interface for a simple set class.
 *
 * @author Jeremy Morris
 * @version 10202020
 */
public interface SimpleSet {
	
	/**
     * Adds an element to the set.
     * @param element element to add
     * @precond element is not already in the set
     * @postcond element is in the set
     */
	public void add(String element);
    
    /**
     * Removes an element from the set.
     * @param element element to be removed
     * @precond element is in the set
     * @postcond element is in the set
     */
    public void remove(String element);
    
    /**
     * Gives the size of the set
     * @return count of elements in the set
     */
    public int size();
    
    /**
     * Indicates whether an element is in the set.
     * @param element element to be checked
     * @return true if element is in the set, false otherwise
     */
    public boolean contains(String element);
}
