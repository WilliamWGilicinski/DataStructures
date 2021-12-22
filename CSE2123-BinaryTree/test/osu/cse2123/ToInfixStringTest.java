package osu.cse2123;

/**
 * A simple program to test infix string production method.
 *
 * @author Jeremy Morris
 * @version 20201001
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ToInfixStringTest {
	
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
	void testBuild2Operands() {
		StringBuilder tree = new StringBuilder("(-(3()())(-3()()))");
		TreeNode<String> root = build(tree);
		String truth = "(3 - -3)";
		String test = ExpressionBuilder.toInfixString(root);
		assertEquals(truth, test);
	}

	@Test
	void testBuild3Operands() {
		StringBuilder tree = new StringBuilder("(+(-(3()())(-3()()))(2()()))");
		TreeNode<String> root = build(tree);
		String truth = "((3 - -3) + 2)";
		String test = ExpressionBuilder.toInfixString(root);
		assertEquals(truth, test);
	}

	@Test
	void testBuild4Operands() {
		StringBuilder tree = new StringBuilder("(+(/(-(3()())(-3()()))(2()()))(9()()))");
		TreeNode<String> root = build(tree);
		String truth = "(((3 - -3) / 2) + 9)";
		String test = ExpressionBuilder.toInfixString(root);
		assertEquals(truth, test);
	}
	
	@Test
	void testBuild5Operands() {
		StringBuilder tree = new StringBuilder("(+(/(-(3()())(+(-3()())(7()())))(2()()))(9()()))");
		TreeNode<String> root = build(tree);
		String truth = "(((3 - (-3 + 7)) / 2) + 9)";
		String test = ExpressionBuilder.toInfixString(root);
		assertEquals(truth, test);
	}

}
