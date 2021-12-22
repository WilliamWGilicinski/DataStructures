package osu.cse2123;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetTokenSequenceTest {

	@Test
	void testSingleLetter() {
		String input = "a";
		String truth = "a";
		String test = WordAnalysis.getNextTokenSequence(input);
		assertEquals(truth, test,"Single Letter Test");
	}
	
	@Test
	void testSingleNumber() {
		String input = "9";
		String truth = "9";
		String test = WordAnalysis.getNextTokenSequence(input);
		assertEquals(truth, test,"Single Number Test");
	}

	
	@Test
	void testMultipleLetters() {
		String input = "abcdefg";
		String truth = "abcdefg";
		String test = WordAnalysis.getNextTokenSequence(input);
		assertEquals(truth, test,"Multiple Letter Test");
	}

	@Test
	void testMultipleLettersFollowedBySpaces() {
		String input = "abcdefg      ";
		String truth = "abcdefg";
		String test = WordAnalysis.getNextTokenSequence(input);
		assertEquals(truth, test,"Mulitple Letter Followed by Spaces Test");
	}

	@Test
	void testMultipleNumbersFollowedBySpaces() {
		String input = "1234567      ";
		String truth = "1234567";
		String test = WordAnalysis.getNextTokenSequence(input);
		assertEquals(truth, test,"Mulitple Numbers Followed by Spaces Test");
	}

	@Test
	void testMultipleNumbersFollowedByPunctuation() {
		String input = "1234567.?!";
		String truth = "1234567";
		String test = WordAnalysis.getNextTokenSequence(input);
		assertEquals(truth, test,"Mulitple Numbers Followed by Punctuation Test");
	}

	@Test
	void testNumbersAndLettersFollowedByMultipleTokens() {
		String input = "1b32a!   abc 123 ab12";
		String truth = "1b32a";
		String test = WordAnalysis.getNextTokenSequence(input);
		assertEquals(truth, test,"Token Followed By Punctuation and Spaces then tokens Test");
	}


}
