package osu.cse2123;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class addBSTTest {
	
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
	void testAddToEmpty() {
		StringBuilder tree = new StringBuilder("(apple()())");
		TreeNode<String> truth = build(tree);
		TreeNode<String> test = null;
		test = BinarySearchTreeMethods.add(test,"apple");
		assertEquals(truth, test);
	}
	
	@Test
	void testAddToLeft() {
		String trueInput = "(banana(apple()())())";
		StringBuilder tree = new StringBuilder(trueInput);
		String initial = "(banana()())";
		StringBuilder initialTree = new StringBuilder(initial);
		TreeNode<String> truth = build(tree);
		TreeNode<String> test = build(initialTree);
		test = BinarySearchTreeMethods.add(test,"apple");
		assertEquals(truth, test);
	}
	
	@Test
	void testAddToRight() {
		String trueInput = "(banana()(carrot()()))";
		StringBuilder tree = new StringBuilder(trueInput);
		String initial = "(banana()())";
		StringBuilder initialTree = new StringBuilder(initial);
		TreeNode<String> truth = build(tree);
		TreeNode<String> test = build(initialTree);
		test = BinarySearchTreeMethods.add(test,"carrot");
		assertEquals(truth, test);
	}
	
	@Test
	void testAddToLeftLeft() {
		String trueInput = "(banana(apple(aardvark()())())())";
		StringBuilder tree = new StringBuilder(trueInput);
		String initial = "(banana(apple()())())";
		StringBuilder initialTree = new StringBuilder(initial);
		TreeNode<String> truth = build(tree);
		TreeNode<String> test = build(initialTree);
		test = BinarySearchTreeMethods.add(test,"aardvark");
		assertEquals(truth, test);
	}
	
	@Test
	void testAddToLeftRight() {
		String trueInput = "(banana(apple()(aqueduct()()))())";
		StringBuilder tree = new StringBuilder(trueInput);
		String initial = "(banana(apple()())())";
		StringBuilder initialTree = new StringBuilder(initial);
		TreeNode<String> truth = build(tree);
		TreeNode<String> test = build(initialTree);
		test = BinarySearchTreeMethods.add(test,"aqueduct");
		assertEquals(truth, test);
	}
	
	@Test
	void testAddToRightRight() {
		String trueInput = "(banana()(carrot()(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		String initial = "(banana()(carrot()()))";
		StringBuilder initialTree = new StringBuilder(initial);
		TreeNode<String> truth = build(tree);
		TreeNode<String> test = build(initialTree);
		test = BinarySearchTreeMethods.add(test,"dill");
		assertEquals(truth, test);
	}
	
	@Test
	void testAddToRightLeft() {
		String trueInput = "(banana()(carrot(carbon()())()))";
		StringBuilder tree = new StringBuilder(trueInput);
		String initial = "(banana()(carrot()()))";
		StringBuilder initialTree = new StringBuilder(initial);
		TreeNode<String> truth = build(tree);
		TreeNode<String> test = build(initialTree);
		test = BinarySearchTreeMethods.add(test,"carbon");
		assertEquals(truth, test);
	}
	
	@Test
	void testAddToFullTree() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> truth = build(tree);
		TreeNode<String> test = null;
		test = BinarySearchTreeMethods.add(test, "banana");
		test = BinarySearchTreeMethods.add(test, "apple");
		test = BinarySearchTreeMethods.add(test, "aardvark");
		test = BinarySearchTreeMethods.add(test, "aqueduct");
		test = BinarySearchTreeMethods.add(test, "carrot");
		test = BinarySearchTreeMethods.add(test,"carbon");
		test = BinarySearchTreeMethods.add(test, "dill");
		assertEquals(truth, test);
	}
	
	@Test
	void testAddToFullTreeDifferentOrder() {
		String trueInput = "(carrot(aqueduct(apple(aardvark()())())(banana()(carbon()())))(dill()()))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> truth = build(tree);
		TreeNode<String> test = null;
		test = BinarySearchTreeMethods.add(test, "carrot");
		test = BinarySearchTreeMethods.add(test, "aqueduct");
		test = BinarySearchTreeMethods.add(test, "banana");
		test = BinarySearchTreeMethods.add(test,"carbon");
		test = BinarySearchTreeMethods.add(test, "apple");
		test = BinarySearchTreeMethods.add(test, "dill");
		test = BinarySearchTreeMethods.add(test, "aardvark");
		assertEquals(truth, test);
	}


}
