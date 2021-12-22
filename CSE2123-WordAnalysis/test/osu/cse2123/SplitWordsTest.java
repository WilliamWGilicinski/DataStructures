package osu.cse2123;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class SplitWordsTest {

	@Test
	void testEmptyString() {
		String input = "";
		Queue<String> truth = new LinkedList<>();
		Queue<String> test = WordAnalysis.splitWords(input);
		assertEquals(truth,test,"Empty String Test");
	}

	@Test
	void testOneWord() {
		String input = "abc123";
		Queue<String> truth = new LinkedList<>(Arrays.asList("abc123"));
		Queue<String> test = WordAnalysis.splitWords(input);
		assertEquals(truth,test,"One Word Test");
	}

	@Test
	void testTwoWords() {
		String input = "abc123 987zyx";
		Queue<String> truth = new LinkedList<>(Arrays.asList("abc123","987zyx"));
		Queue<String> test = WordAnalysis.splitWords(input);
		assertEquals(truth,test,"Two Words Test");
	}
	
	@Test
	void testTwoWordsPuncutation() {
		String input = "abc123 .? 987zyx";
		Queue<String> truth = new LinkedList<>(Arrays.asList("abc123","987zyx"));
		Queue<String> test = WordAnalysis.splitWords(input);
		assertEquals(truth,test,"Two Words Punctuation Test");
	}

	@Test
	void testThreeWordsPuncutation() {
		String input = "abc123 .? 987zyx !?' 456mno";
		Queue<String> truth = new LinkedList<>(Arrays.asList("abc123","987zyx","456mno"));
		Queue<String> test = WordAnalysis.splitWords(input);
		assertEquals(truth,test,"Three Words Punctuation Test");
	}

	@Test
	void testSentenceWithPunctuation() {
		String input = "Over the river, and through the woods.  To grandmother's house we go!";
		Queue<String> truth = new LinkedList<>(Arrays.asList("Over","the","river","and","through","the","woods","To","grandmother","s","house","we","go"));
		Queue<String> test = WordAnalysis.splitWords(input);
		assertEquals(truth,test,"Sentence With Punctuation Test");
	}

}
