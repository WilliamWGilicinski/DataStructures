/*
 * @author William Gilicinski
 * @version January 31st, 2021
 */

package osu.cse2123;

public class UnitTesting {

    /**
     * Returns the integer average of two integers.
     *
     * @param num1
     * @param num2
     * @return the integer average of num1 and num2
     */
    public static int average(int num1, int num2) {
        return (num1 + num2) / 2;

    }

    /**
     * Determines if a number is odd
     *
     * @param num
     *            number to check for parity
     * @return true if num is odd, false if even
     */
    public static boolean isOdd(int num) {
        return Math.abs(num) % 2 == 1;
    }

    /**
     * Determines if an array holds all even values
     *
     * @param value
     * @param array
     * @return true if all values in the array are even, false otherwise.
     */
    public static boolean allEven(int[] array) {
        boolean result = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                result = false;
                ;
            }
        }
        return result;
    }

    /**
     * Determines if a string is a palindrome
     *
     * @param str
     *            string to test
     * @return true if str is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        boolean pal = true;
        int stop = (str.length() - 1) / 2;
        for (int i = 0; i < stop; i++) {
            int end = str.length() - 1 - i;
            if (str.charAt(i) != str.charAt(end)) {
                pal = false;
            }
        }
        return pal;
    }
}
