package osu.cse2123;


/**
 * An implementation of the SimpleSet interface on a Binary Search Tree
 *
 * @author Jeremy Morris
 * @version 10202020
 */

public class SimpleTreeSet implements SimpleSet {
	
	private TreeNode<String> root;
	private int size;
	
	public SimpleTreeSet() {
		this.root = null;
		this.size = 0;
	}

	@Override
	public void add(String element) {
		this.root = BinarySearchTreeMethods.add(root, element);
		this.size++;
	}

	@Override
	public void remove(String element) {
		this.root = BinarySearchTreeMethods.remove(root, element);
		this.size--;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean contains(String element) {
		// TODO Auto-generated method stub
		return BinarySearchTreeMethods.find(root, element);
	}
	
	@Override
	public String toString() {
		String str = "{ "+BinarySearchTreeMethods.inorderVisit(root)+" }";
		return str;
	}
	
}
