package osu.cse2123;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;



class removeHashTableTest {
	
	private static final int DEFAULT_SIZE = 8;
	
	private static List<List<String>> buildTable(int size) {
		List<List<String>> table = new ArrayList<>();
		for (int i=0; i<size; i++) {
			table.add(new ArrayList<>());
		}
		return table;
	}
	
	@Test
	void testRemoveTwoElements() {
		List<List<String>> truth = buildTable(8);
		truth.get(2).add("apple");
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.remove(test, "banana");
		assertEquals(truth, test);
	}
	
	@Test
	void testRemoveThreeElements() {
		List<List<String>> truth = buildTable(8);
		truth.get(2).add("apple");
		truth.get(5).add("banana");
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.remove(test,"carrots");
		assertEquals(truth, test);
	}
	
	@Test
	void testRemoveFourElements() {
		List<List<String>> truth = buildTable(8);
		truth.get(2).add("apple");
		truth.get(5).add("banana");
		truth.get(0).add("carrots");
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.remove(test,"daikon");
		assertEquals(truth, test);
	}

	@Test
	void testRemoveFiveElements() {
		List<List<String>> truth = buildTable(8);
		truth.get(2).add("apple");
		truth.get(5).add("banana");
		truth.get(0).add("carrots");
		truth.get(6).add("daikon");
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.add(test,"eggplant");
		HashTableMethods.remove(test,"eggplant");
		assertEquals(truth, test);
	}
	
	@Test
	void testRemoveSixElements() {
		List<List<String>> truth = buildTable(8);
		truth.get(2).add("apple");
		truth.get(5).add("banana");
		truth.get(0).add("carrots");
		truth.get(6).add("daikon");
		truth.get(6).add("eggplant");
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.add(test,"eggplant");
		HashTableMethods.add(test,"fig");
		HashTableMethods.remove(test,"fig");
		assertEquals(truth, test);
	}

	@Test
	void testRemoveSevenElements() {
		List<List<String>> truth = buildTable(8);
		truth.get(2).add("apple");
		truth.get(5).add("banana");
		truth.get(0).add("carrots");
		truth.get(6).add("daikon");
		truth.get(6).add("eggplant");
		truth.get(4).add("fig");
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.add(test,"eggplant");
		HashTableMethods.add(test,"fig");
		HashTableMethods.add(test,"grapes");
		HashTableMethods.remove(test,"grapes");
		assertEquals(truth, test);
	}
	
	@Test
	void testRemoveEightElements() {
		List<List<String>> truth = buildTable(8);
		truth.get(2).add("apple");
		truth.get(5).add("banana");
		truth.get(0).add("carrots");
		truth.get(6).add("daikon");
		truth.get(6).add("eggplant");
		truth.get(4).add("fig");
		truth.get(0).add("grapes");
		List<List<String>> test = buildTable(8);
		HashTableMethods.add(test,"apple");
		HashTableMethods.add(test,"banana");
		HashTableMethods.add(test,"carrots");
		HashTableMethods.add(test,"daikon");
		HashTableMethods.add(test,"eggplant");
		HashTableMethods.add(test,"fig");
		HashTableMethods.add(test,"grapes");
		HashTableMethods.add(test,"honeydew");
		HashTableMethods.remove(test,"honeydew");
		assertEquals(truth, test);
	}

}
