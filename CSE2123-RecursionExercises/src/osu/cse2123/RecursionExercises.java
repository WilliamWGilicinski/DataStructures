package osu.cse2123;

/**
 * A series of methods to practice recursion.
 *
 * @author William Gilicinski
 * @version February 1st, 2021
 *
 *          Base case of string length one is true. If a string is length two
 *          and the first and second are the same then its true. if a string is
 *          longer than two but the first two are different then its false. if a
 *          string is longer than two and the first and last are the same, then
 *          the substring without the first and last will be looked at. return
 *          boolean value.
 *
 */

public class RecursionExercises {

    /**
     * Determines if a string is a palindrome
     *
     * @param str
     *            the string to be tested
     * @return true if str is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        boolean bln = true;

        if (str.length() == 2 && (str.charAt(0) != str.charAt(1))) {
            bln = false;
        }

        if (str.length() > 2) {
            if (str.charAt(0) != str.charAt(str.length() - 1)) {
                bln = false;
            } else {
                String sub = str.substring(1, str.length() - 1);
                bln = isPalindrome(sub);
            }
        }

        return bln;
    }

    /**
     * Determines the greatest common divisor of two numbers
     *
     * @param num1
     *            first number
     * @param num2
     *            second number
     * @precond both num1 > 0 && num2 > 0 && num1 >= num2
     * @return gcd(num1, num2)
     */
    public static int gcd(int num1, int num2) {
        int gcd = 1;

        if (num1 % num2 == 0) {
            gcd = num2;
        } else {
            gcd = gcd(num2, num1 % num2);
        }

        return gcd;
    }

    /**
     * Draws a triangle to the screen recursively, with the point at the bottom.
     *
     * @param num
     *            height of the triangle
     */
    public static void drawTriangle(int num) {
        if (num > 0) {
            for (int i = 0; i < num; i++) {
                System.out.print("*");
            }
            System.out.println();
            drawTriangle(num - 1);
        }

    }

    /**
     * Draws a triangle to the screen recursively, with the point at the top.
     *
     * @param num
     *            height of the triangle
     */
    public static void drawTriangleReversed(int num) {

        if (num > 0) {
            drawTriangleReversed(num - 1);
            for (int i = 0; i < num; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*
         * Testing
         * 
         * drawTriangleReversed(4); drawTriangle(18); System.out.println(gcd(32,
         * 28));
         */
    }

}
