package osu.cse2123;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetDigitSequenceTest {

	@Test
	void testSingleDigit() {
		String input = "1";
		String truth = "1";
		String test = StackCalculator.getNextDigitSequence(input);
		assertEquals(truth, test,"Single Digit Test");
	}
	
	@Test
	void testZeroDigit() {
		String input = "0";
		String truth = "0";
		String test = StackCalculator.getNextDigitSequence(input);
		assertEquals(truth, test,"Zero Digit Test");
	}
	
	@Test
	void testTwoDigits() {
		String input = "12";
		String truth = "12";
		String test = StackCalculator.getNextDigitSequence(input);
		assertEquals(truth, test,"Two Digit Test");
	}

	@Test
	void testThreeDigits() {
		String input = "123";
		String truth = "123";
		String test = StackCalculator.getNextDigitSequence(input);
		assertEquals(truth, test,"Three Digit Test");
	}
	
	@Test
	void testLowerFiveDigits() {
		String input = "12345";
		String truth = "12345";
		String test = StackCalculator.getNextDigitSequence(input);
		assertEquals(truth, test,"Lower Five Digit Test");
	}

	@Test
	void testUpperFiveDigits() {
		String input = "67890";
		String truth = "67890";
		String test = StackCalculator.getNextDigitSequence(input);
		assertEquals(truth, test,"Upper Five Digit Test");
	}
	
	@Test
	void testDigitsFollowedBySpaces() {
		String input = "67890   ";
		String truth = "67890";
		String test = StackCalculator.getNextDigitSequence(input);
		assertEquals(truth, test,"Digits Followed By Space Test");
	}
	
	@Test
	void testDigitsFollowedByTabs() {
		String input = "67890		";
		String truth = "67890";
		String test = StackCalculator.getNextDigitSequence(input);
		assertEquals(truth, test,"Digits Followed By Space Test");
	}

	
	@Test
	void testDigitsFollowedByOperators() {
		String input = "67890+-*/%";
		String truth = "67890";
		String test = StackCalculator.getNextDigitSequence(input);
		assertEquals(truth, test,"Digits Followed By Whitespace Test");
	}

	@Test
	void testDigitsFollowedByJunk() {
		String input = "67890abcdABC";
		String truth = "67890";
		String test = StackCalculator.getNextDigitSequence(input);
		assertEquals(truth, test,"Digits Followed By Junk Test");
	}


}
