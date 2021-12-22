package osu.cse2123;
/**
 * A collection of tests for the linear search method.
 * 
 * @name Jeremy Morris
 * @version 09082020
 * 
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LinearSearchTest {
	
	private static List<String> BIG_LIST = Arrays.asList("apple","banana","carrot", "date","eggplant","fig","grapes","honeydew","incaberry");

	@Test
	void testEmptyList() {
		List<String> list = new ArrayList<>();
		String str = "apple";
		int test = SearchingMethods.linearSearch(str, list);
		int truth = -1;
		assertEquals(truth,test);
	}
	
	@Test
	void testLength1True() {
		List<String> list = Arrays.asList("apple");
		String str = "apple";
		int test = SearchingMethods.linearSearch(str, list);
		int truth = 0;
		assertEquals(truth,test);
	}
	
	@Test
	void testLength1False() {
		List<String> list = Arrays.asList("apple");
		String str = "zucchini";
		int test = SearchingMethods.linearSearch(str, list);
		int truth = -1;
		assertEquals(truth,test);
	}
	
	@Test
	void testLongFalse() {
		String str = "zucchini";
		int test = SearchingMethods.linearSearch(str, BIG_LIST);
		int truth = -1;
		assertEquals(truth,test);
	}
	
	@Test
	void testPos0True() {
		int truth = 0;
		String str = BIG_LIST.get(truth);
		int test = SearchingMethods.linearSearch(str, BIG_LIST);
		assertEquals(truth,test);
	}
	
	@Test
	void testPos1True() {
		int truth = 1;
		String str = BIG_LIST.get(truth);
		int test = SearchingMethods.linearSearch(str, BIG_LIST);
		assertEquals(truth,test);
	}
	
	@Test
	void testPos2True() {
		int truth = 2;
		String str = BIG_LIST.get(truth);
		int test = SearchingMethods.linearSearch(str, BIG_LIST);
		assertEquals(truth,test);
	}
	
	@Test
	void testPos3True() {
		int truth = 3;
		String str = BIG_LIST.get(truth);
		int test = SearchingMethods.linearSearch(str, BIG_LIST);
		assertEquals(truth,test);
	}

	@Test
	void testPos4True() {
		int truth = 4;
		String str = BIG_LIST.get(truth);
		int test = SearchingMethods.linearSearch(str, BIG_LIST);
		assertEquals(truth,test);
	}

	@Test
	void testPos5True() {
		int truth = 5;
		String str = BIG_LIST.get(truth);
		int test = SearchingMethods.linearSearch(str, BIG_LIST);
		assertEquals(truth,test);
	}
	
	@Test
	void testPos6True() {
		int truth = 6;
		String str = BIG_LIST.get(truth);
		int test = SearchingMethods.linearSearch(str, BIG_LIST);
		assertEquals(truth,test);
	}
	
	@Test
	void testPos7True() {
		int truth = 7;
		String str = BIG_LIST.get(truth);
		int test = SearchingMethods.linearSearch(str, BIG_LIST);
		assertEquals(truth,test);
	}

	@Test
	void testPos8True() {
		int truth = 8;
		String str = BIG_LIST.get(truth);
		int test = SearchingMethods.linearSearch(str, BIG_LIST);
		assertEquals(truth,test);
	}


}
