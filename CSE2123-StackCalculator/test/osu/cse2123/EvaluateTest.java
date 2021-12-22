package osu.cse2123;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EvaluateTest {

	@Test
	void testSimpleAddition() {
		int num1 = 60, num2 = 55;
		int truth = num1 + num2;
		int test = StackCalculator.evaluate("+", num1, num2);
		assertEquals(truth, test,"Simple Addition Test");
	}
	
	@Test
	void testSimpleSubtraction() {
		int num1 = 60, num2 = 55;
		int truth = num1 - num2;
		int test = StackCalculator.evaluate("-", num1, num2);
		assertEquals(truth, test,"Simple Subtraction Test");
	}
	
	@Test
	void testSimpleMultiplication() {
		int num1 = 60, num2 = 55;
		int truth = num1 * num2;
		int test = StackCalculator.evaluate("*", num1, num2);
		assertEquals(truth, test,"Simple Multiplication Test");
	}

	@Test
	void testSimpleDivision() {
		int num1 = 61, num2 = 5;
		int truth = num1 / num2;
		int test = StackCalculator.evaluate("/", num1, num2);
		assertEquals(truth, test,"Simple Division Test");
	}

	@Test
	void testSimpleRemainder() {
		int num1 = 61, num2 = 5;
		int truth = num1 % num2;
		int test = StackCalculator.evaluate("%", num1, num2);
		assertEquals(truth, test,"Simple Remainder Test");
	}

}
