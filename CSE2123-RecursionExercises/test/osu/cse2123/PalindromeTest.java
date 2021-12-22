package osu.cse2123;
/**
 * Test cases for the isPalindrome method in RecursionExercises
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromeTest {

	@Test
	void testPalindromeLen0() {
		String input = "";
		boolean truth = true;
		boolean test = RecursionExercises.isPalindrome(input);
		assertEquals(truth,test);
	}

	@Test
	void testPalindromeLen1() {
		String input = "a";
		boolean truth = true;
		boolean test = RecursionExercises.isPalindrome(input);
		assertEquals(truth,test);
	}
	
	@Test
	void testPalindromeLen2True() {
		String input = "aa";
		boolean truth = true;
		boolean test = RecursionExercises.isPalindrome(input);
		assertEquals(truth,test);
	}

	@Test
	void testPalindromeLen2False() {
		String input = "ab";
		boolean truth = false;
		boolean test = RecursionExercises.isPalindrome(input);
		assertEquals(truth,test);
	}
	
	@Test
	void testPalindromeLen3True() {
		String input = "aba";
		boolean truth = true;
		boolean test = RecursionExercises.isPalindrome(input);
		assertEquals(truth,test);
	}
	
	@Test
	void testPalindromeLen3False() {
		String input = "abc";
		boolean truth = false;
		boolean test = RecursionExercises.isPalindrome(input);
		assertEquals(truth,test);
	}

	@Test
	void testPalindromeLen4True() {
		String input = "abba";
		boolean truth = true;
		boolean test = RecursionExercises.isPalindrome(input);
		assertEquals(truth,test);
	}

	@Test
	void testPalindromeLen4FalseMiddle() {
		String input = "abca";
		boolean truth = false;
		boolean test = RecursionExercises.isPalindrome(input);
		assertEquals(truth,test);
	}

	@Test
	void testPalindromeLen4FalseEnds() {
		String input = "abbd";
		boolean truth = false;
		boolean test = RecursionExercises.isPalindrome(input);
		assertEquals(truth,test);
	}


}
