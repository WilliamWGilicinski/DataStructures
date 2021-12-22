package osu.cse2123;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class ParseSymbolsTest {

	@Test
	void testSingleDigit() {
		String input = "1";
		Queue<String> truth = new LinkedList<>(Arrays.asList("1"));
		Queue<String> test = StackCalculator.parseSymbols(input);
		assertEquals(truth, test,"Single Digit Test");
	}
	
	@Test
	void testMultipleDigits() {
		String input = "12345";
		Queue<String> truth = new LinkedList<>(Arrays.asList("12345"));
		Queue<String> test = StackCalculator.parseSymbols(input);
		assertEquals(truth, test,"Multiple Digit Test");
	}
	
	@Test
	void testNegativeMultipleDigits() {
		String input = "-12345";
		Queue<String> truth = new LinkedList<>(Arrays.asList("-12345"));
		Queue<String> test = StackCalculator.parseSymbols(input);
		assertEquals(truth, test,"Negative Multiple Digit Test");
	}
	
	@Test
	void testTwoNumbers() {
		String input = "12345 67890";
		Queue<String> truth = new LinkedList<>(Arrays.asList("12345","67890"));
		Queue<String> test = StackCalculator.parseSymbols(input);
		assertEquals(truth, test,"Two Numbers Test");
	}
	
	@Test
	void testTwoNumbersOneNegative() {
		String input = "12345 -67890";
		Queue<String> truth = new LinkedList<>(Arrays.asList("12345","-67890"));
		Queue<String> test = StackCalculator.parseSymbols(input);
		assertEquals(truth, test,"Two Numbers One Negative Test");
	}
	
	@Test
	void testTwoNumbersSymbol() {
		String input = "12345 67890 +";
		Queue<String> truth = new LinkedList<>(Arrays.asList("12345","67890","+"));
		Queue<String> test = StackCalculator.parseSymbols(input);
		assertEquals(truth, test,"Two Numbers and a Symbol Test - 12345 67890 +");
	}

	@Test
	void testTwoNumbersSymbolNoWhitespace() {
		String input = "12345 67890+";
		Queue<String> truth = new LinkedList<>(Arrays.asList("12345","67890","+"));
		Queue<String> test = StackCalculator.parseSymbols(input);
		assertEquals(truth, test,"Two Numbers and a Symbol Test - 12345 67890+");
	}
	
	@Test
	void testThreeNumbersTwoSymbols() {
		String input = "987 12345 67890 + *";
		Queue<String> truth = new LinkedList<>(Arrays.asList("987","12345","67890","+","*"));
		Queue<String> test = StackCalculator.parseSymbols(input);
		assertEquals(truth, test,"Two Numbers and a Symbol Test - 12345 67890 + *");
	}
	
	@Test
	void testThreeNumbersTwoSymbolsNoWhitespace() {
		String input = "987 12345 67890+*";
		Queue<String> truth = new LinkedList<>(Arrays.asList("987","12345","67890","+","*"));
		Queue<String> test = StackCalculator.parseSymbols(input);
		assertEquals(truth, test,"Three Numbers and Two Symbols Test - 12345 67890+*");
	}
	
	@Test
	void testThreeNumbersTwoSymbolsMinusSign() {
		String input = "12345 67890 - 987 +";
		Queue<String> truth = new LinkedList<>(Arrays.asList("12345","67890","-","987","+"));
		Queue<String> test = StackCalculator.parseSymbols(input);
		assertEquals(truth, test,"Three Numbers and Two Symbols One Minus Test - 12345 67890 - 987 +");
	}
	
	@Test
	void testThreeNumbersNegativeTwoSymbolsMinusSign() {
		String input = "12345 67890 - -987 +";
		Queue<String> truth = new LinkedList<>(Arrays.asList("12345","67890","-","-987","+"));
		Queue<String> test = StackCalculator.parseSymbols(input);
		assertEquals(truth, test,"Three Numbers Negative and Two Symbols One Minus Test - 12345 67890 - -987 +");
	}

}
