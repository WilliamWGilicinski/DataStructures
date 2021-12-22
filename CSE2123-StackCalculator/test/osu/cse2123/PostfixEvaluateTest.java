package osu.cse2123;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class PostfixEvaluateTest {

	@Test
	void testSingleDigit() {
		Queue<String> input = new LinkedList<>(Arrays.asList("1"));
		int truth = 1;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Single Digit Test");
	}
	
	@Test
	void testMultipleDigits() {
		Queue<String> input = new LinkedList<>(Arrays.asList("12345"));
		int truth = 12345;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Mulitple Digits Test");
	}
	
	@Test
	void testNegativeMultipleDigits() {
		Queue<String> input = new LinkedList<>(Arrays.asList("-12345"));
		int truth = -12345;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Negative Mulitple Digits Test");
	}
	
	
	@Test
	void testTwoNumbersAddition() {
		Queue<String> input = new LinkedList<>(Arrays.asList("12345","67890","+"));
		int truth = 12345+67890;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Two Numbers Addition Test - 12345 67890 +");
	}
	
	@Test
	void testTwoNumbersAdditionNegative() {
		Queue<String> input = new LinkedList<>(Arrays.asList("-12345","67890","+"));
		int truth = -12345+67890;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Two Numbers Addition Negative Test - -12345 67890 +");
	}
	
	@Test
	void testTwoNumbersSubtraction() {
		Queue<String> input = new LinkedList<>(Arrays.asList("12345","67890","-"));
		int truth = 12345-67890;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Two Numbers Subtraction Test - 12345 67890 -");
	}

	@Test
	void testTwoNumbersSubtractionNegative() {
		Queue<String> input = new LinkedList<>(Arrays.asList("-12345","67890","-"));
		int truth = -12345-67890;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Two Numbers Subtraction Negative Test - -12345 67890 -");
	}

	@Test
	void testTwoNumbersMultiplication() {
		Queue<String> input = new LinkedList<>(Arrays.asList("123","678","*"));
		int truth = 123*678;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Two Numbers Multiplication Test - 123 678 *");
	}
	
	@Test
	void testTwoNumbersMultiplicationNegative() {
		Queue<String> input = new LinkedList<>(Arrays.asList("123","-678","*"));
		int truth = 123*-678;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Two Numbers Multiplication Test - 123 -678 *");
	}

	
	@Test
	void testTwoNumbersDivision() {
		Queue<String> input = new LinkedList<>(Arrays.asList("202","20","/"));
		int truth = 202/20;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Two Numbers Division Test - 202 20 /");
	}
	
	@Test
	void testTwoNumbersDivisionNegative() {
		Queue<String> input = new LinkedList<>(Arrays.asList("-202","20","/"));
		int truth = -202/20;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Two Numbers Division Negative Test - -202 20 /");
	}
	
	@Test
	void testTwoNumbersRemainder() {
		Queue<String> input = new LinkedList<>(Arrays.asList("202","20","%"));
		int truth = 202%20;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Two Numbers Remainder Test - 202 20 %");
	}
	
	@Test
	void testTwoNumbersRemainderNegative() {
		Queue<String> input = new LinkedList<>(Arrays.asList("-202","20","%"));
		int truth = -202%20;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Two Numbers Remainder Negative Test - -202 20 %");
	}
	
	@Test
	void testThreeNumbersTwoSymbols() {
		Queue<String> input = new LinkedList<>(Arrays.asList("987","12345","67890","+","*"));
		int truth = (12345+67890)*987;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Two Numbers and a Symbol Test - 12345 67890 + *");
	}
	
	@Test
	void testThreeNumbersTwoSymbolsMinusSign() {
		int truth = (12345 - 67890) / 987;
		Queue<String> input = new LinkedList<>(Arrays.asList("12345","67890","-","987","/"));
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Three Numbers and Two Symbols One Minus Test - 12345 67890 - 987 /");
	}
	
	@Test
	void testThreeNumbersNegativeTwoSymbolsMinusSign() {
		Queue<String> input = new LinkedList<>(Arrays.asList("12345","67890","-","-987","/"));
		int truth = (12345 - 67890) / -987;
		int test = StackCalculator.postfixEvaluate(input);
		assertEquals(truth, test,"Three Numbers Negative and Two Symbols One Minus Test - 12345 67890 - -987 /");
	}

}
