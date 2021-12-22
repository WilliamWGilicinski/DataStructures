package osu.cse2123;

import java.util.ArrayList;
import java.util.List;

/**
 * A set of tests for the BinarySearchTree methods.
 *
 * @author Jeremy Morris
 * @version 10202020
 */

public class HashTableTesting {
	
	private static final int DEFAULT_SIZE = 4;

	public static void main(String[] args) {
		List<List<String>> table = new ArrayList<>();
		for (int i=0; i<DEFAULT_SIZE; i++) {
			table.add(new ArrayList<>());
		}
		HashTableMethods.add(table, "d");
		HashTableMethods.add(table,"c");
		HashTableMethods.add(table,"e");
		HashTableMethods.add(table,"b");
		HashTableMethods.add(table,"f");
		HashTableMethods.add(table,"a");
		HashTableMethods.add(table,"g");
		System.out.println(table); // [[d], [e, a], [b, f], [c, g]]
		HashTableMethods.remove(table,"d");
		System.out.println(table); // [[], [e, a], [b, f], [c, g]]
		HashTableMethods.remove(table, "c");
		System.out.println(table); // [[], [e, a], [b, f], [g]]
		System.out.println(HashTableMethods.find(table,"g")); // true
		System.out.println(HashTableMethods.find(table,"z")); // false
		System.out.println(HashTableMethods.values(table)); // e, a, b, f, g
	}
}
