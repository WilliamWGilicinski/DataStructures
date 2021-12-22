package osu.cse2123;
/**
 * Test cases for the gcd method in RecursionExercises
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GCDTest {

	@Test
	void testGCDsame() {
		int num1 = 6;
		int num2 = 6;
		int truth = 6;
		int test = RecursionExercises.gcd(num1, num2);
		assertEquals(truth,test);
	}
	
	@Test
	void testGCDtwo() {
		int num1 = 18;
		int num2 = 14;
		int truth = 2;
		int test = RecursionExercises.gcd(num1, num2);
		assertEquals(truth,test);
	}

	@Test
	void testGCDthree() {
		int num1 = 21;
		int num2 = 18;
		int truth = 3;
		int test = RecursionExercises.gcd(num1, num2);
		assertEquals(truth,test);
	}
	
	@Test
	void testGCDfour() {
		int num1 = 32;
		int num2 = 28;
		int truth = 4;
		int test = RecursionExercises.gcd(num1, num2);
		assertEquals(truth,test);
	}
	
	@Test
	void testGCDfive() {
		int num1 = 55;
		int num2 = 45;
		int truth = 5;
		int test = RecursionExercises.gcd(num1, num2);
		assertEquals(truth,test);
	}
	
	@Test
	void testGCDseven() {
		int num1 = 49;
		int num2 = 28;
		int truth = 7;
		int test = RecursionExercises.gcd(num1, num2);
		assertEquals(truth,test);
	}

	@Test
	void testGCD2k() {
		int num1 = 70000;
		int num2 = 6000;
		int truth = 2000;
		int test = RecursionExercises.gcd(num1, num2);
		assertEquals(truth,test);
	}



}
