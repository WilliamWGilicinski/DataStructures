package osu.cse2123;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetNonTokenSequenceTest {

	@Test
	void testSingleSpace() {
		String input = " ";
		String truth = " ";
		String test = WordAnalysis.getNextNonTokenSequence(input);
		assertEquals(truth, test,"Single Space Test");
	}
	
	@Test
	void testSinglePunctuation() {
		String input = "!";
		String truth = "!";
		String test = WordAnalysis.getNextNonTokenSequence(input);
		assertEquals(truth, test,"Single Punctuation Test");
	}

	
	@Test
	void testMultipleSpaces() {
		String input = "    ";
		String truth = "    ";
		String test = WordAnalysis.getNextNonTokenSequence(input);
		assertEquals(truth, test,"Multiple Space Test");
	}

	@Test
	void testMultipleSpacesFollowedByLetters() {
		String input = "   abc";
		String truth = "   ";
		String test = WordAnalysis.getNextNonTokenSequence(input);
		assertEquals(truth, test,"Multiple Spaces Followed by Letters Test");
	}

	@Test
	void testMultipleSpacesFollowedByNumbers() {
		String input = "   123";
		String truth = "   ";
		String test = WordAnalysis.getNextNonTokenSequence(input);
		assertEquals(truth, test,"Multiple Spaces Followed by Numbers Test");
	}

	@Test
	void testMultipleSpacesFollowedByPunctuation() {
		String input = "   !!?.";
		String truth = "   !!?.";
		String test = WordAnalysis.getNextNonTokenSequence(input);
		assertEquals(truth, test,"Multiple Spaces Followed by Punctuation Test");
	}

	@Test
	void testPunctuationFollowedBySpacesFollowedByMultipleTokens() {
		String input = "!   abc 123 ab12";
		String truth = "!   ";
		String test = WordAnalysis.getNextNonTokenSequence(input);
		assertEquals(truth, test,"Punctuation Followed By Spaces then tokens Test");
	}


}
