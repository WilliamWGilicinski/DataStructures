package osu.cse2123;

/**
 * Tests the inorder traversal method of the binary tree
 *
 * @author Jeremy Morris
 * @version 20201001
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreeInOrderTest {
	
	/**
	 * Builds a tree from a StringBuilder string
	 * @param str StringBuilder containing a correct tree definition
	 * @precond str is a correct string definition of a tree with no whitespace
	 * @return a binary tree derived from str
	 */
	public static TreeNode<String> build(StringBuilder str) {
		assert str.charAt(0) == '('; // fail if the first character is not a paren
		str.delete(0,1); // remove the '('
		TreeNode<String> root = null; // empty tree is default
		if (str.charAt(0)!=')') {
			// we don't have an empty tree
			int end = 0;
			// find the value of the root node
			while (end < str.length() && str.charAt(end) != '(') {
				end++;
			}
			String val = str.substring(0,end);
			str.delete(0,end); //remove root data value
			// build the left tree
			TreeNode<String> left = build(str);
			// after building the left tree, fail if the next character is not a paren
			assert str.charAt(0) == '(';
			// build the right tree
			TreeNode<String> right = build(str);
			// fail if the next character is not a close paren 
			// this indicates the end of the node
			assert str.charAt(0) == ')';
			root = new TreeNode<>(val);
			root.setLeft(left);
			root.setRight(right);
		}
		str.delete(0,1); // remove closing paren ending the node definition
		return root;
	}
	
	@Test
	void testInOrderEmptyTree() {
		TreeNode<String> root = null;
		String test = BinaryTreeMethods.inOrderTraversal(root);
		assertEquals("", test);
	}
	
	@Test
	void testInOrder1Node() {
		StringBuilder tree = new StringBuilder("(a()())");
		TreeNode<String> root = build(tree);
		String test = BinaryTreeMethods.inOrderTraversal(root);
		assertEquals("a", test);
	}
	
	
	@Test
	void testInOrder2NodesLeft() {
		StringBuilder tree = new StringBuilder("(a(b()())())");
		TreeNode<String> root = build(tree);
		String test = BinaryTreeMethods.inOrderTraversal(root);
		assertEquals("b a", test);
	}

	@Test
	void testInOrder2NodesRight() {
		StringBuilder tree = new StringBuilder("(a()(c()()))");
		TreeNode<String> root = build(tree);
		String test = BinaryTreeMethods.inOrderTraversal(root);
		assertEquals("a c", test);
	}


	@Test
	void testInOrder7Nodes() {
		StringBuilder tree = new StringBuilder("(a(b(d()())(e()()))(c(f()())(g()())))");
		TreeNode<String> root = build(tree);
		String test = BinaryTreeMethods.inOrderTraversal(root);
		assertEquals("d b e a f c g", test);
	}
}
