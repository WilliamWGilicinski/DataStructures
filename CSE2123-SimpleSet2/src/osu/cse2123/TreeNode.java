package osu.cse2123;

/**
 * A TreeNode class
 *
 * @author Jeremy Morris
 * @version 10012020
 */


public class TreeNode<E> {
		
	private E data;
	private TreeNode<E> left;
	private TreeNode<E> right;

	public TreeNode(E element) {
		this.data = element;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Returns the data element stored in this node
	 * @return the data element stored in this node
	 */
	public E getData() {
		return this.data;
	}
	
	/**
	 * Returns the left child of this node. 
	 *  
	 * @precond tree has a left child
	 * @return left child of this tree
	 */
	public TreeNode<E> getLeft() {
		return this.left;
	}

	/**
	 * Returns the right child of this node. 
	 * 
	 * @precond tree has a right child
	 * @return right child of this tree
	 */
	public TreeNode<E> getRight() {
		return this.right;
	}
	
	/**
	 * Sets the data in this node.
	 * @param data value to set the node to.
	 * @postcond data in this == data
	 */
	public void setData(E data) {
		this.data = data;
	}
	
		
	/**
	 * Sets the left child of this tree.
	 * @param node node to make the left child
	 * @postcond left child of this == node
	 * 	  
	 */
	public void setLeft(TreeNode<E> node) {
		this.left = node;
	}
	
	/**
	 * Sets the right child of this tree.
	 * @param node node to make the right child
	 * @postcond right child of this == node
	 * 	  
	 */
	public void setRight(TreeNode<E> node) {
		this.right = node;
	}
	
	/**
	 * Deletes the left child of this node.
	 * @precond this tree has a left child
	 * @postcond this tree has no left child
	 * @return the old left child tree
	 */
	public TreeNode<E> removeLeft() {
		TreeNode<E> left = this.left;
		this.left = null;
		return left;
	}
	
	/**
	 * Delete the right child of this node.
	 * @postcond this tree has no right child
	 */
	public TreeNode<E> removeRight() {
		TreeNode<E> right = this.right;
		this.right = null;
		return right;
	}

	/**
	 * Indicates if the tree has a left child or not.
	 * @return true if the tree has a left child, false otherwise.
	 */
	public boolean hasLeft() {
		return this.left != null;
	}
	
	/**
	 * Indicates if the tree has a right child or not.
	 * @return true if the tree has a right child, false otherwise.
	 */
	public boolean hasRight() {
		return this.right != null;
	}
	
	
	@Override
	public String toString() {
		// This implementation provides an in-order traversal.
		String str = "("+this.data.toString();
		if (this.left != null) {
			str = str+" "+this.left.toString();
		}
		else {
			str = str+" ()";
		}
		if (this.right != null) {
			str = str+" "+this.right.toString();
		}
		else {
			str = str+" ()";
		}
		return str+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean areEqual = false;
		if (this == obj) {
			areEqual = true;
		}
		else if (obj instanceof TreeNode<?>) {
			TreeNode<?> localObj = (TreeNode<?>) obj;
			areEqual = this.data.equals(localObj.data);
			if (areEqual  && this.left != null) {
				areEqual = this.left.equals(localObj.left);
			}
			if (areEqual && this.right != null) {
				areEqual = this.right.equals(localObj.right);
			}
		}
		return areEqual;
	}
	
	@Override
	public int hashCode() {
		int leftHash = 0;
		int rightHash = 0;
		if (this.left != null) {
			leftHash = this.left.hashCode();
		}
		if (this.right != null) {
			rightHash = this.right.hashCode();
		}
		return this.data.hashCode()+leftHash+rightHash; 
	}
	
}
