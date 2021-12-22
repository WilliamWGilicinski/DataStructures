package osu.cse2123;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class inOrderVisitBSTTest {
	
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
	void testInOrderOneNode() {
		String trueInput = "(banana()())";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		String truth = "banana";
		String test = BinarySearchTreeMethods.inorderVisit(testTree);
		assertEquals(truth, test);
	}
	
	@Test
	void testInOrderTwoNode() {
		String trueInput = "(banana(apple()())())";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		String truth = "apple, banana";
		String test = BinarySearchTreeMethods.inorderVisit(testTree);
		assertEquals(truth, test);
	}
	
	@Test
	void testInOrderTwoNodesRight() {
		String trueInput = "(banana()(carrot()()))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		String truth = "banana, carrot";
		String test = BinarySearchTreeMethods.inorderVisit(testTree);
		assertEquals(truth, test);
	}
	
	@Test
	void testInOrderThreeNodes() {
		String trueInput = "(banana(apple()())(carrot()()))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		String truth = "apple, banana, carrot";
		String test = BinarySearchTreeMethods.inorderVisit(testTree);
		assertEquals(truth, test);
	}
	
	@Test
	void testInOrderFiveNodes() {
		String trueInput = "(banana(apple()(avocado()()))(carrot(bling()())()))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		String truth = "apple, avocado, banana, bling, carrot";
		String test = BinarySearchTreeMethods.inorderVisit(testTree);
		assertEquals(truth, test);
	}
	
	@Test
	void testInOrderSevenNodes() {
		String trueInput = "(banana(apple(aardvark()())(aqueduct()()))(carrot(carbon()())(dill()())))";
		StringBuilder tree = new StringBuilder(trueInput);
		TreeNode<String> testTree = build(tree);
		String truth = "aardvark, apple, aqueduct, banana, carbon, carrot, dill";
		String test = BinarySearchTreeMethods.inorderVisit(testTree);
		assertEquals(truth, test);
	}
	


}
