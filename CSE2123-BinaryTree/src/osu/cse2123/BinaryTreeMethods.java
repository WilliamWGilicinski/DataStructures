package osu.cse2123;

/**
 * A collection of Binary Tree methods
 *
 * @author William Gilicinski
 * @version April 5th, 2021
 */

public class BinaryTreeMethods {

    /**
     * Builds a tree from a StringBuilder string
     *
     * @param str
     *            StringBuilder containing a correct tree definition
     * @precond str is a correct string definition of a tree with no whitespace
     * @return a binary tree derived from str
     */
    public static TreeNode<String> build(StringBuilder str) {
        assert str.charAt(0) == '('; // fail if the first character is not a paren
        str.delete(0, 1); // remove the '('
        TreeNode<String> root = null; // empty tree is default
        if (str.charAt(0) != ')') {
            // we don't have an empty tree
            int end = 0;
            // find the value of the root node
            while (end < str.length() && str.charAt(end) != '(') {
                end++;
            }
            String val = str.substring(0, end);
            str.delete(0, end); //remove root data value
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
        str.delete(0, 1); // remove closing paren ending the node definition
        return root;
    }

    /**
     * Returns the size of the binary tree
     *
     * @param root
     *            the root node of the binary tree
     * @return the count of all of the nodes in the tree
     */
    public static int size(TreeNode<String> root) {
        int count = 0;
        if (root != null) {
            count = 1 + size(root.getLeft()) + size(root.getRight());
        }
        return count;
    }

    /**
     * Checks to see if a value is in a binary tree
     *
     * @param root
     *            root of the tree to check
     * @param value
     *            value to search for
     * @return true if value is in the tree, false otherwise
     */
    public static boolean contains(TreeNode<String> root, String value) {
        boolean contains = false;
        if (size(root) > 0) {
            //Sees if the node has the same value as value
            contains = root.getData().equals(value);
            //Checks if the contains is not already true and if the node has
            //children.
            if (root.hasLeft() && !contains) {
                contains = contains(root.getLeft(), value);
            }
            if (root.hasRight() && !contains) {
                contains = contains(root.getRight(), value);
            }
        }
        return contains;
    }

    /**
     * Counts the number of times value appears in the tree root
     *
     * @param root
     *            tree to count the elements in
     * @param value
     *            value to search the tree for
     * @return the count of the number of times value appears in the tree
     */
    public static int count(TreeNode<String> root, String value) {
        int count = 0;
        if (root != null) {
            if (root.getData().equals(value)) {
                count++;
            }
            if (root.hasLeft()) {
                count += count(root.getLeft(), value);
            }
            if (root.hasRight()) {
                count += count(root.getRight(), value);
            }
        }
        return count;

    }

    /**
     * inOrderTraversal in-order traversal logic is: 1. Process the left child
     * first 2. Then process the current node 3. Then process the right child So
     * if the tree looks like this: 5 / \ 2 9 The method would return the String
     * "2 5 9"
     *
     * @param root
     *            the root node of the tree you want to traverse
     * @return a String containing the inOrderTraversal representation of this
     *         tree
     *
     */
    public static String inOrderTraversal(TreeNode<String> root) {
        String value = "";
        if (size(root) > 0) {
            //Gets all the information from the left side
            if (root.hasLeft()) {
                value = value + inOrderTraversal(root.getLeft()) + " ";
            }
            //Gets the root node info
            value += root.getData() + " ";
            //Gets the right child information
            if (root.hasRight()) {
                value += inOrderTraversal(root.getRight()) + " ";
            }
            //Gets rid of the extra space
            value = value.substring(0, value.length() - 1);
        }
        return value;
    }

    /**
     * preOrderTraversal pre-order traversal logic is: 1. Process the current
     * node first 2. Then process the left child 3. Then process the right child
     * So if the tree looks like this: 5 / \ 2 9 The method would return the
     * String "5 2 9"
     *
     * @param root
     *            the root node of the tree you want to traverse
     * @return a String containing the preOrderTraversal representation of this
     *         tree
     */
    public static String preOrderTraversal(TreeNode<String> root) {
        //Same code as the inOrderTraversal but the ifs are in different places
        String value = "";
        if (size(root) > 0) {
            value += root.getData() + " ";
            if (root.hasLeft()) {
                value += preOrderTraversal(root.getLeft()) + " ";
            }
            if (root.hasRight()) {
                value += preOrderTraversal(root.getRight()) + " ";
            }
            value = value.substring(0, value.length() - 1);
        }
        return value;
    }

    /**
     * postOrderTraversal post-order traversal logic is: 1. Process the left
     * child first 2. Then process the right child 3. Then process the current
     * node So if the tree looks like this: 5 / \ 2 9 The method would return
     * the String "2 9 5"
     *
     * @param root
     *            the root node of the tree you want to traverse
     * @return a String containing the postOrderTraversal representation of this
     *         tree
     */
    public static String postOrderTraversal(TreeNode<String> root) {
        //Same code as the inOrderTraversal but the ifs are in different places
        String value = "";
        if (size(root) > 0) {
            if (root.hasLeft()) {
                value += postOrderTraversal(root.getLeft()) + " ";
            }
            if (root.hasRight()) {
                value += postOrderTraversal(root.getRight()) + " ";
            }
            value += root.getData() + " ";
            value = value.substring(0, value.length() - 1);
        }
        return value;
    }

    public static void main(String[] args) {
        TreeNode<String> root = build(new StringBuilder("()"));
        System.out.println(root);
        root = build(new StringBuilder("(a()())"));
        System.out.println(root);
        root = build(new StringBuilder("(a(b()())(c()()))"));
        System.out.println(root);
        root = build(
                new StringBuilder("(a(b(d()())(e()()))(c(f()())(g()())))"));
        System.out.println(root);
        System.out.println(size(root));
        System.out.println(inOrderTraversal(root));
        System.out.println(preOrderTraversal(root));
        System.out.println(postOrderTraversal(root));
        System.out.println(count(root, "e"));

    }

}
