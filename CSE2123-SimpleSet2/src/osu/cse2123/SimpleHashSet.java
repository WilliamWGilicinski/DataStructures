package osu.cse2123;


import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the SimpleSet interface on a Binary Search Tree
 *
 * @author Jeremy Morris
 * @version 10202020
 */

public class SimpleHashSet implements SimpleSet {
	
	private final static int DEFAULT_SIZE = 16;
	
	private List<List<String>> table;
	private int size;
	
	public SimpleHashSet() {
		this.table = new ArrayList<>();
		for (int i=0; i<DEFAULT_SIZE; i++) {
			this.table.add(new ArrayList<>());
		}
		this.size = 0;
	}

	@Override
	public void add(String element) {
		HashTableMethods.add(this.table, element);
		this.size++;
	}

	@Override
	public void remove(String element) {
		HashTableMethods.remove(this.table, element);
		this.size--;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean contains(String element) {
		return HashTableMethods.find(this.table, element);
	}
	
	@Override
	public String toString() {
		String str = "{ "+HashTableMethods.values(this.table)+" }";
		return str;
	}
	
}
