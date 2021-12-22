package osu.cse2123;

/**
 * A set of tests for the BinarySearchTree methods.
 *
 * @author Jeremy Morris
 * @version 10202020
 */

public class BSTTesting {

	public static void main(String[] args) {
		TreeNode<String> root2 = BinarySearchTreeMethods.add(null, "d");
		root2 = BinarySearchTreeMethods.add(root2,"c");
		root2 = BinarySearchTreeMethods.add(root2,"e");
		root2 = BinarySearchTreeMethods.add(root2,"b");
		root2 = BinarySearchTreeMethods.add(root2,"f");
		root2 = BinarySearchTreeMethods.add(root2,"a");
		root2 = BinarySearchTreeMethods.add(root2,"g");
		System.out.println(root2); // (d (c (b (a () ()) ()) ()) (e () (f () (g () ()))))
		root2 = BinarySearchTreeMethods.remove(root2,"d");
		System.out.println(root2); // (e (c (b (a () ()) ()) ()) (f () (g () ())))
		root2 = BinarySearchTreeMethods.remove(root2, "c");
		System.out.println(root2); // (e (b (a () ()) ()) (f () (g () ())))
		System.out.println(BinarySearchTreeMethods.find(root2,"g")); // true
		System.out.println(BinarySearchTreeMethods.find(root2,"z")); // false
		System.out.println(BinarySearchTreeMethods.inorderVisit(root2)); // a, b, e, f, g
	}
}
