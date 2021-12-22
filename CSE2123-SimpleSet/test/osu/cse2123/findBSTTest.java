package osu.cse2123;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class findBSTTest {
	
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
	void testFindRootNodeTrue() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		boolean truth = true;
		boolean test = BinarySearchTreeMethods.find(testTree,"banana");
		assertEquals(truth, test);
	}
	
	@Test
	void testFindRootNodeFalse() {
		String trueInput = "(banana()())";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		boolean truth = false;
		boolean test = BinarySearchTreeMethods.find(testTree,"apple");
		assertEquals(truth, test);
	}
	
	@Test
	void testFindRightTrue() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		boolean truth = true;
		boolean test = BinarySearchTreeMethods.find(testTree,"carrot");
		assertEquals(truth, test);
	}
	
	@Test
	void testFindRightLeftTrue() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		boolean truth = true;
		boolean test = BinarySearchTreeMethods.find(testTree,"carbon");
		assertEquals(truth, test);
	}
	
	@Test
	void testFindRightRightTrue() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		boolean truth = true;
		boolean test = BinarySearchTreeMethods.find(testTree,"dill");
		assertEquals(truth, test);
	}


	@Test
	void testFindRightRightFalse() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		boolean truth = false;
		boolean test = BinarySearchTreeMethods.find(testTree,"zzzz");
		assertEquals(truth, test);
	}
	
	@Test
	void testFindRightLeftFalse() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		boolean truth = false;
		boolean test = BinarySearchTreeMethods.find(testTree,"dddddd");
		assertEquals(truth, test);
	}

	@Test
	void testFindLeftTrue() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		boolean truth = true;
		boolean test = BinarySearchTreeMethods.find(testTree,"apple");
		assertEquals(truth, test);
	}
	
	@Test
	void testFindLeftLeftTrue() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		boolean truth = true;
		boolean test = BinarySearchTreeMethods.find(testTree,"aardvark");
		assertEquals(truth, test);
	}
	
	@Test
	void testFindLeftRightTrue() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		boolean truth = true;
		boolean test = BinarySearchTreeMethods.find(testTree,"aqueduct");
		assertEquals(truth, test);
	}


	@Test
	void testFindLeftLeftFalse() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		boolean truth = false;
		boolean test = BinarySearchTreeMethods.find(testTree,"aaaaa");
		assertEquals(truth, test);
	}
	
	@Test
	void testFindLeftRightFalse() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		boolean truth = false;
		boolean test = BinarySearchTreeMethods.find(testTree,"arduino");
		assertEquals(truth, test);
	}


}
