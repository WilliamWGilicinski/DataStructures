package osu.cse2123;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * @Author William Gilicinski
 * @Version April 6th, 2021
 */

public class ExpressionBuilder {

    /**
     * Returns a tree based on a postfix expression string
     *
     * @param expr
     *            a properly formatted postfix expression string
     * @precond expr will be properly formatted and have a space between each
     *          element
     * @return a binary tree with the expression given in expr
     */
    public static TreeNode<String> buildTreeFromString(String expr) {

        String operators[] = { "+", "-", "*", "/", "%" };
        String split[] = expr.split(" ");
        Deque<TreeNode> exprStack = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            //Checks to see if the expression is a number or operator
            boolean isOperator = false;
            for (int j = 0; j < operators.length; j++) {
                if (split[i].equals(operators[j])) {
                    isOperator = true;
                }
            }
            //If the expression is an operator, creates a new node with the last
            //two numbers as it's children
            if (isOperator) {
                TreeNode<String> operator = new TreeNode<>(split[i]);
                operator.setRight(exprStack.pop());
                operator.setLeft(exprStack.pop());
                exprStack.push(operator);
                //if the expression is a number, it is pushed on the stack as a node
            } else {
                TreeNode<String> operand = new TreeNode<>(split[i]);
                exprStack.push(operand);
            }
        }
        //Returns the final tree
        return exprStack.pop();
    }

    /**
     * Returns a string that is the inorder traversal of the expression tree,
     * including parentheses
     *
     * @param expr
     *            a binary tree that represents a expression tree
     * @precond expr is a properly formatted expression tree
     * @return a String representing the inorder visit of expr
     */
    public static String toInfixString(TreeNode<String> expr) {

        String value = "";

        if (BinaryTreeMethods.size(expr) > 0) {
            //Gets all the information from the left side
            if (expr.hasLeft()) {
                value = value + "(" + toInfixString(expr.getLeft()) + " ";
            }
            //Gets the root node info
            value += expr.getData() + " ";
            //Gets the right child information
            if (expr.hasRight()) {
                value += toInfixString(expr.getRight()) + ") ";
            }
            //Gets rid of the extra space
            value = value.substring(0, value.length() - 1);
        }

        return value;
    }

    /**
     * Evaluates the binary expression tree expr
     *
     * @param expr
     *            a binary tree that represents an expression tree
     * @precond expr is a properly formatted expression tree
     * @return the evaluation of the expression
     */
    public static int evaluate(TreeNode<String> expr) {
        String[] operators = { "+", "-", "/", "*", "%" };
        int value = 0;
        int opValue = 0;
        boolean isOperator = false;
        //Finds if the expression is an operator and which one it is
        for (int i = 0; i < operators.length; i++) {
            if (expr.getData().equals(operators[i])) {
                isOperator = true;
                opValue = i;
            }
        }

        //Recursively finds the left and right sides and evaluates them with
        //the correct operator
        if (isOperator) {
            int left = evaluate(expr.getLeft());
            int right = evaluate(expr.getRight());
            if (opValue == 0) {
                value = left + right;
            } else if (opValue == 1) {
                value = left - right;
            } else if (opValue == 2) {
                value = left / right;
            } else if (opValue == 3) {
                value = left * right;
            } else {
                value = left % right;
            }
        } else {
            value = Integer.parseInt(expr.getData());
        }

        return value;
    }

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        boolean keepGoing = true;
        //Loops until the user enters a blank line
        while (keepGoing) {
            System.out.print("Enter an expression (blank to quit): ");
            String input = reader.nextLine();
            if (input != "") {
                TreeNode<String> build = buildTreeFromString(input);
                System.out.println(
                        toInfixString(build) + " = " + evaluate(build));
                System.out.println();
            } else {
                keepGoing = false;
            }
        }

        System.out.println("Goodbye!");
        reader.close();
    }

}
