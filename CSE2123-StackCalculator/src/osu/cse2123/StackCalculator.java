package osu.cse2123;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * A caclulator with used with postfix notation
 *
 * @author William Gilicinski
 * @version February 28th, 2021
 *
 */

public class StackCalculator {

    /**
     * Returns the sequence of digit characters from the front of a String that
     * make up an integer value.
     *
     * @param str
     *            String that starts with an integer value
     * @precond str starts with 1 or more digit characters
     * @return the sequence of digits that start the String str
     */
    public static String getNextDigitSequence(String str) {
        String digits = "";
        //For loops finds each digit and adds it to the
        for (int i = 0; i < str.length()
                && Character.isDigit(str.charAt(i)); i++) {
            digits += str.charAt(i);
        }
        return digits;

    }

    /**
     * Returns the sequence of whitespace characters from the front of a String.
     *
     * @param str
     *            String that starts with whitespace
     * @precond str starts with 1 or more whitespace characters
     * @return the
     */
    public static String getNextWhitespaceSequence(String str) {
        String whiteSpace = "";
        int count = 0;
        //Adds a whitespace until there are none left
        while (count < str.length()
                && (str.charAt(count) == ' ' || str.charAt(count) == '\t')) {
            if (str.charAt(count) == ' ') {
                whiteSpace += " ";
            } else {
                whiteSpace += "\t";
            }
            count++;
        }
        return whiteSpace;
    }

    /**
     * Converts a string of mathematical operations into a Queue of Strings. See
     * the assignment write-up for details.
     *
     * @param str
     *            String to convert
     * @precond str contains only digits, whitespace and operators + - / * % ( )
     * @return a queue with each digit and operator as a separate entry in the
     *         same order they appeared in the string str
     */
    public static Queue<String> parseSymbols(String str) {
        Queue<String> symbols = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (getNextDigitSequence(str.substring(i)).length() > 0) {
                symbols.add(getNextDigitSequence(str.substring(i)));
                i += getNextDigitSequence(str.substring(i)).length() - 1;
            } else if (getNextWhitespaceSequence(str.substring(i))
                    .length() > 0) {
                i += getNextWhitespaceSequence(str.substring(i)).length() - 1;
            } else if (str.charAt(i) == '-' && str.charAt(i + 1) != ' ') {
                i++;
                symbols.add("-" + getNextDigitSequence(str.substring(i)));
                i += getNextDigitSequence(str.substring(i)).length() - 1;
            } else {
                symbols.add(str.substring(i, i + 1));
            }
        }

        return symbols;
    }

    /**
     * Combines operands num1 and num2 with the operator op and returns the
     * result of (num1 op num2)
     *
     * @param op
     *            - operator + - * % or /
     * @param num1
     *            first operand to combine
     * @param num2
     *            second operand to combine
     * @precond op is restricted to be one of "+" "-" "*" "%" "/"
     * @return num1 op num2
     */
    public static int evaluate(String op, int num1, int num2) {
        int result = 0;
        //The symbol is parsed through the else if statements to see what
        //function is does.
        if (op.equals("+")) {
            result = num1 + num2;
        } else if (op.equals("-")) {
            result = num1 - num2;
        } else if (op.equals("*")) {
            result = num1 * num2;
        } else if (op.equals("%")) {
            result = num1 % num2;
        } else {
            result = num1 / num2;
        }

        return result;
    }

    /**
     * Evaluates postfix algebraic expressions
     *
     * @param input
     *            queue to be evaluated
     * @precond input is formatted as a correct postfix algebraic expression
     * @return the evaluation of input as an postfix algebraic expression
     */
    public static int postfixEvaluate(Queue<String> input) {
        Deque<Integer> operands = new LinkedList<Integer>();
        String temp = "";
        int tempInt, pop2, pop1, evaluate;
        while (!input.isEmpty()) { //Goes through the entire list
            temp = input.remove();
            //Finds if the value is a number and puts it into the stack
            if ((temp.length() > 1 && Character.isDigit(temp.charAt(1)))
                    || Character.isDigit(temp.charAt(0))) {
                tempInt = Integer.parseInt(temp);
                operands.push(tempInt);
            } else {
                //Takes the top two numbers on the stack and evaluates it with
                //the operator
                pop2 = operands.pop();
                pop1 = operands.pop();
                evaluate = evaluate(temp, pop1, pop2);
                operands.push(evaluate);
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String input;
        Queue<String> queue = new LinkedList<>();
        int result = 0;
        boolean valid = true;

        while (valid) {
            System.out.print("Enter a postfix expression: ");
            input = reader.nextLine();
            if (!input.equals("")) {
                queue = parseSymbols(input);
                result = postfixEvaluate(queue);
                System.out.println("The answer is: " + result + "\n");
            } else {
                valid = false;
            }
        }
        System.out.println("Goodbye!");
        reader.close();
    }

}
