package osu.cse2123;

/**
 * A selection of methods for dealing with binary search trees.
 *
 * @author William Gilicinski
 * @version April 12th, 2021
 */

public class BinarySearchTreeMethods {

    /**
     * Add an element to its correct place in a binary search tree
     *
     * @param root
     *            the root node of a correctly built binary search tree
     * @param value
     *            value to be inserted into the tree
     * @precond root is the root of a binary search tree
     * @return the root node of a binary search tree with value inserted into it
     */
    public static TreeNode<String> add(TreeNode<String> root, String value) {

        if (root == null) {
            TreeNode<String> newTree = new TreeNode<>(value);
            root = newTree;
        } else if (root.getData().compareTo(value) > 0) {
            root.setLeft(add(root.getLeft(), value));
        } else {
            root.setRight(add(root.getRight(), value));
        }

        return root;
    }

    /**
     * Indicates if a value is in a binary search tree or not
     *
     * @param root
     *            the root of a binary search tree
     * @param value
     *            the value to search for
     * @precond root is the root of a binary search tree
     * @return true if value is in the tree rooted at root, false otherwise
     */
    public static boolean find(TreeNode<String> root, String value) {

        boolean found = false;

        if (root == null) {
            found = false;
        }
        if (root.getData().equals(value)) {
            found = true;
        } else if (value.compareTo(root.getData()) <= 0 && root.hasLeft()) {
            found = find(root.getLeft(), value);
        } else if (value.compareTo(root.getData()) > 0 && root.hasRight()) {
            found = find(root.getRight(), value);
        }
        return found;
    }

    /**
     * Finds the smallest value in a binary search tree
     *
     * @param root
     * @precond root cannot be empty (i.e. root cannot be null) and root is the
     *          root of a binary search tree
     * @return the smallest value in the tree
     */
    public static String findMin(TreeNode<String> root) {
        String smallest = "";
        if (root.hasLeft()) {
            smallest = findMin(root.getLeft());
        } else {
            smallest = root.getData();
        }
        return smallest;
    }

    /**
     * Remove the smallest value from a binary tree
     *
     * @param root
     *            - the tree to remove the value from
     * @precond root cannot be empty (i.e. root cannot be null) and root is the
     *          root of a binary search tree
     * @return the root of a binary search tree with the minimum value removed
     */
    public static TreeNode<String> removeMin(TreeNode<String> root) {
        if (root.hasLeft()) {
            root.setLeft(removeMin(root.getLeft()));
        } else {
            if (root.hasRight()) {
                root = root.getRight();
            } else {
                root = null;
            }
        }

        return root;
    }

    /**
     * Returns a comma-separated in-order list of the elements of the tree.
     *
     * @param root
     *            the root of a binary search tree
     * @return a comma-separated string of the elements in the tree via an
     *         in-order visitation. If the tree is empty returns an empty String
     *         ""
     */
    public static String inorderVisit(TreeNode<String> root) {
        String order = "";

        //Only adds the string with no commas as it has no children
        if (!root.hasLeft() && !root.hasRight()) {
            order = root.getData();
        }

        else {
            //Always adds the comma after the left as there will always be a
            //parent that goes after the left
            if (root.hasLeft()) {
                order += inorderVisit(root.getLeft()) + ", ";
            }
            //Puts a comma after the middle value as there will be a right child
            //after the parent
            if (root.hasRight()) {
                order += root.getData() + ", ";
                order += inorderVisit(root.getRight());
                //Doesn't put a comma as there are no children after the parent
            } else {
                order += root.getData();
            }
        }
        return order;
    }

    /**
     * Removes an arbitrary value from a binary search tree
     *
     * @param root
     *            the root of a binary search tree
     * @param value
     *            the value to be removed
     * @precond root cannot be empty (i.e. root cannot be null) and root is the
     *          root of a binary search tree and value is in the tree rooted by
     *          root
     * @return the root of a tree with value removed from it
     */
    public static TreeNode<String> remove(TreeNode<String> root, String value) {

        if (root.getData().equals(value)) {
            // root value equals the value we're looking for
            if (root.hasRight()) {
                if (!root.hasLeft()) {
                    // no left child - right tree is our new root
                    root = root.getRight();
                } else {
                    // both left and right child - most complex case
                    // find the minimum value from the right child
                    String min = findMin(root.getRight());
                    // remove the minimum node from the right child
                    TreeNode<String> right = removeMin(root.getRight());
                    // replace the current node's value with the min value
                    root.setData(min);
                    // set the right child to our new right child with
                    // the minimum node removed
                    root.setRight(right);
                }
            } else {
                // no right child - left tree is our new root
                root = root.getLeft();
            }
        } else if (value.compareTo(root.getData()) < 0) {
            // value is less than the root value, recursively remove from the left side
            TreeNode<String> left = root.getLeft();
            left = remove(left, value);
            root.setLeft(left);
        } else {
            // value is greater than the root value, recursively remove from the right side
            TreeNode<String> right = root.getRight();
            right = remove(right, value);
            root.setRight(right);
        }
        // root has the root of our new tree, return it
        return root;
    }

}
