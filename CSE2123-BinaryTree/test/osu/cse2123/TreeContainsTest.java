package osu.cse2123;

/**
 * A simple program to test the contains binary tree method.
 *
 * @author Jeremy Morris
 * @version 20201001
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TreeContainsTest {
	
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
	void testContainsEmptyTree() {
		TreeNode<String> root = null;
		boolean test = BinaryTreeMethods.contains(root, "a");
		assertEquals(false, test);
	}
	
	@Test
	void testContains1NodeFalse() {
		StringBuilder tree = new StringBuilder("(a()())");
		TreeNode<String> root = build(tree);
		boolean test = BinaryTreeMethods.contains(root, "b");
		assertEquals(false, test);
	}
	
	@Test
	void testContains1NodeTrue() {
		StringBuilder tree = new StringBuilder("(a()())");
		TreeNode<String> root = build(tree);
		boolean test = BinaryTreeMethods.contains(root, "a");
		assertEquals(true, test);
	}
	
	@Test
	void testContains2NodeLeftTrue() {
		StringBuilder tree = new StringBuilder("(a(b()())())");
		TreeNode<String> root = build(tree);
		boolean test = BinaryTreeMethods.contains(root, "b");
		assertEquals(true, test);
	}

	@Test
	void testContains2NodeLeftFalse() {
		StringBuilder tree = new StringBuilder("(a(b()())())");
		TreeNode<String> root = build(tree);
		boolean test = BinaryTreeMethods.contains(root, "c");
		assertEquals(false, test);
	}
	
	@Test
	void testContains2NodeRightTrue() {
		StringBuilder tree = new StringBuilder("(a()(c()()))");
		TreeNode<String> root = build(tree);
		boolean test = BinaryTreeMethods.contains(root, "c");
		assertEquals(true, test);
	}

	@Test
	void testContains2NodeRightFalse() {
		StringBuilder tree = new StringBuilder("(a()(c()()))");
		TreeNode<String> root = build(tree);
		boolean test = BinaryTreeMethods.contains(root, "b");
		assertEquals(false, test);
	}

	@Test
	void testContains7NodeLeftLeftTrue() {
		StringBuilder tree = new StringBuilder("(a(b(d()())(e()()))(c(f()())(g()())))");
		TreeNode<String> root = build(tree);
		boolean test = BinaryTreeMethods.contains(root, "d");
		assertEquals(true, test);
	}

	@Test
	void testContains7NodeLeftRightTrue() {
		StringBuilder tree = new StringBuilder("(a(b(d()())(e()()))(c(f()())(g()())))");
		TreeNode<String> root = build(tree);
		boolean test = BinaryTreeMethods.contains(root, "e");
		assertEquals(true, test);
	}

	@Test
	void testContains7NodeRightRightTrue() {
		StringBuilder tree = new StringBuilder("(a(b(d()())(e()()))(c(f()())(g()())))");
		TreeNode<String> root = build(tree);
		boolean test = BinaryTreeMethods.contains(root, "g");
		assertEquals(true, test);
	}

	@Test
	void testContains7NodeRightLeftTrue() {
		StringBuilder tree = new StringBuilder("(a(b(d()())(e()()))(c(f()())(g()())))");
		TreeNode<String> root = build(tree);
		boolean test = BinaryTreeMethods.contains(root, "f");
		assertEquals(true, test);
	}

	@Test
	void testContains7NodeFalse() {
		StringBuilder tree = new StringBuilder("(a(b(d()())(e()()))(c(f()())(g()())))");
		TreeNode<String> root = build(tree);
		boolean test = BinaryTreeMethods.contains(root, "z");
		assertEquals(false, test);
	}



}
