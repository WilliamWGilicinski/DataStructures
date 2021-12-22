package osu.cse2123;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;



class findHashTableTest {
	
	private static final int DEFAULT_SIZE = 8;
	
	private static List<List<String>> buildTable(int size) {
		List<List<String>> table = new ArrayList<>();
		for (int i=0; i<size; i++) {
			table.add(new ArrayList<>());
		}
		return table;
	}

	@Test
	void testFindApple() {
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.add(test,"eggplant");
		HashTableMethods.add(test,"fig");
		HashTableMethods.add(test,"grapes");
		assertEquals(true, HashTableMethods.find(test, "apple"));
	}
	
	@Test
	void testFindBanana() {
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.add(test,"eggplant");
		HashTableMethods.add(test,"fig");
		HashTableMethods.add(test,"grapes");
		assertEquals(true, HashTableMethods.find(test, "banana"));
	}
	
	@Test
	void testFindCarrots() {
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.add(test,"eggplant");
		HashTableMethods.add(test,"fig");
		HashTableMethods.add(test,"grapes");
		assertEquals(true, HashTableMethods.find(test, "carrots"));
	}
	
	@Test
	void testFindDaikon() {
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.add(test,"eggplant");
		HashTableMethods.add(test,"fig");
		HashTableMethods.add(test,"grapes");
		assertEquals(true, HashTableMethods.find(test, "daikon"));
	}
	
	@Test
	void testFindEggplant() {
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.add(test,"eggplant");
		HashTableMethods.add(test,"fig");
		HashTableMethods.add(test,"grapes");
		assertEquals(true, HashTableMethods.find(test, "eggplant"));
	}
	
	@Test
	void testFindFig() {
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.add(test,"eggplant");
		HashTableMethods.add(test,"fig");
		HashTableMethods.add(test,"grapes");
		assertEquals(true, HashTableMethods.find(test, "fig"));
	}

	@Test
	void testFindGrapes() {
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.add(test,"eggplant");
		HashTableMethods.add(test,"fig");
		HashTableMethods.add(test,"grapes");
		assertEquals(true, HashTableMethods.find(test, "grapes"));
	}
	
	@Test
	void testFindHoneydewFalse() {
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.add(test,"eggplant");
		HashTableMethods.add(test,"fig");
		HashTableMethods.add(test,"grapes");
		assertEquals(false, HashTableMethods.find(test, "honeydew"));
	}

}
