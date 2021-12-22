package osu.cse2123;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetWhitespaceSequenceTest {

	@Test
	void testSingleSpace() {
		String input = " ";
		String truth = " ";
		String test = StackCalculator.getNextWhitespaceSequence(input);
		assertEquals(truth, test,"Single Space Test");
	}
	
	@Test
	void testSingleTab() {
		String input = "\t";
		String truth = "\t";
		String test = StackCalculator.getNextWhitespaceSequence(input);
		assertEquals(truth, test,"Zero Space Test");
	}
	
	@Test
	void testTwoSpaces() {
		String input = "  ";
		String truth = "  ";
		String test = StackCalculator.getNextWhitespaceSequence(input);
		assertEquals(truth, test,"Two Spaces Test");
	}

	@Test
	void testThreeSpaces() {
		String input = "   ";
		String truth = "   ";
		String test = StackCalculator.getNextWhitespaceSequence(input);
		assertEquals(truth, test,"Three Spaces Test");
	}
	
	@Test
	void testFiveSpaces() {
		String input = "     ";
		String truth = "     ";
		String test = StackCalculator.getNextWhitespaceSequence(input);
		assertEquals(truth, test,"Five Spaces Test");
	}

	@Test
	void testMixedSpacesTabs() {
		String input = "  \t\t  ";
		String truth = "  \t\t  ";
		String test = StackCalculator.getNextWhitespaceSequence(input);
		assertEquals(truth, test,"Mixed spaces and tabs Test");
	}
	
	@Test
	void testSpacesFollowedByDigits() {
		String input = "   67890";
		String truth = "   ";
		String test = StackCalculator.getNextWhitespaceSequence(input);
		assertEquals(truth, test,"Digits Followed By Space Test");
	}
	
	@Test
	void testSpacesFollowedOperators() {
		String input = "   +-/*%";
		String truth = "   ";
		String test = StackCalculator.getNextWhitespaceSequence(input);
		assertEquals(truth, test,"Digits Followed By Space Test");
	}

	
	@Test
	void testSpacesFollowedByJunk() {
		String input = "     abcABC?:";
		String truth = "     ";
		String test = StackCalculator.getNextWhitespaceSequence(input);
		assertEquals(truth, test,"Digits Followed By Whitespace Test");
	}

	@Test
	void testMixedSpacesTabsFollowedByJunk() {
		String input = "  \t\t  abcdABC";
		String truth = "  \t\t  ";
		String test = StackCalculator.getNextWhitespaceSequence(input);
		assertEquals(truth, test,"Digits Followed By Junk Test");
	}


}
