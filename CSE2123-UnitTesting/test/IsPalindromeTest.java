
/**
 * @author William Gilicinski
 * @version January 31st, 2021
 *
 * Test Plan (palindrome)
 * String        result      reason
 * ------------- ----------- --------------
 * wow           true        wow is wow backwards
 * cat           false       tac is cat backwards
 *               true            is     backwards
 *               true            is     backwards
 * 1             true        1 is 1 backwards
 * I did did I   true        I did did I is I did did I backwards
 * palindrome    false       emordnilap is palindrome backwards
 *
 * The bug thought that the same letter was different because they had different
 * capitalization. I fixed it by taking the string and making it all lower
 * case by using the toLowerCase() method.
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import osu.cse2123.UnitTesting;

class IsPalindromeTest {

    @Test
    void testWow() {
        String str = "wow";
        boolean truth = true;
        boolean test = UnitTesting.isPalindrome(str);
        assertEquals(truth, test, "wow");
    }

    @Test
    void testCat() {
        String str = "cat";
        boolean truth = false;
        boolean test = UnitTesting.isPalindrome(str);
        assertEquals(truth, test, "cat");
    }

    @Test
    void testBlank() {
        String str = "";
        boolean truth = true;
        boolean test = UnitTesting.isPalindrome(str);
        assertEquals(truth, test, "");
    }

    @Test
    void testSpace() {
        String str = " ";
        boolean truth = true;
        boolean test = UnitTesting.isPalindrome(str);
        assertEquals(truth, test, " ");
    }

    @Test
    void testOne() {
        String str = "1";
        boolean truth = true;
        boolean test = UnitTesting.isPalindrome(str);
        assertEquals(truth, test, "1");
    }

    @Test
    void testIDid() {
        String str = "I did did I";
        boolean truth = true;
        boolean test = UnitTesting.isPalindrome(str);
        assertEquals(truth, test, "I did did I");
    }

    @Test
    void testPalindrome() {
        String str = "Palindrome";
        boolean truth = false;
        boolean test = UnitTesting.isPalindrome(str);
        assertEquals(truth, test, "Palindrome");
    }

    @Test
    void testLongSentence() {
        String str = "When I went to the store I bought myself a nice pair of slippers";
        boolean truth = false;
        boolean test = UnitTesting.isPalindrome(str);
        assertEquals(truth, test,
                "When I went to the store I bought myself a nice pair of slippers");
    }

    @Test
    void testWowCapital() {//Test didn't pass, W and w weren't equal
        String str = "Wow";
        boolean truth = true;
        boolean test = UnitTesting.isPalindrome(str);
        assertEquals(truth, test, "wow");
    }

}
