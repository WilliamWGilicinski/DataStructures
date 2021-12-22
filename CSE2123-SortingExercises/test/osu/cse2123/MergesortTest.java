package osu.cse2123;
/**
 * JUnit tests for the Quicksort implementation.
 * 
 * @author Jeremy Morris
 * @version 8/14/2020
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


class MergesortTest {

	public static List<String> buildList(String... strings) {
		List<String> list = new ArrayList<>();
		for (String s : strings) {
			list.add(new StringBuilder(s).toString());
		}
		return list;
	}
	
	public static List<String> copyList(List<String> strings) {
		List<String> list = new ArrayList<>();
		for (String s : strings) {
			list.add(new StringBuilder(s).toString());
		}
		return list;
		
	}

	@Test
	void testSort1Element() {
		List<String> test = buildList("apple");
		List<String> truth = buildList("apple");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort2ElementsAscending() {
		List<String> test = buildList("apple","zucchini");
		List<String> truth = buildList("apple","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort2ElementsDescending() {
		List<String> test = buildList("zucchini","apple");
		List<String> truth = buildList("apple","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}
	
	@Test
	void testSort3ElementsAscending() {
		List<String> test = buildList("apple","melon","zucchini");
		List<String> truth = buildList("apple","melon","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort3ElementsDescending() {
		List<String> test = buildList("zucchini","melon","apple");
		List<String> truth = buildList("apple","melon","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort3ElementsMidFirstDescending() {
		List<String> test = buildList("melon","zucchini","apple");
		List<String> truth = buildList("apple","melon","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort3ElementsMidFirstAscending() {
		List<String> test = buildList("melon","apple","zucchini");
		List<String> truth = buildList("apple","melon","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort3ElementsSmallesFirst() {
		List<String> test = buildList("apple","zucchini","melon");
		List<String> truth = buildList("apple","melon","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort3ElementsLargestFirst() {
		List<String> test = buildList("zucchini","apple","melon");
		List<String> truth = buildList("apple","melon","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}
	
	@Test
	void testSort4ElementsAscending() {
		List<String> test = buildList("apple","melon","tomato","zucchini");
		List<String> truth = buildList("apple","melon","tomato","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort4ElementsDescending() {
		List<String> test = buildList("zucchini","tomato","melon","apple");
		List<String> truth = buildList("apple","melon","tomato","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort4ElementsSmallestFirstDescending() {
		List<String> test = buildList("apple","zucchini","tomato","melon");
		List<String> truth = buildList("apple","melon","tomato","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort4ElementsSmallestFirstDescendingAscending() {
		List<String> test = buildList("apple","zucchini","melon","tomato");
		List<String> truth = buildList("apple","melon","tomato","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}
	@Test
	void testSort4ElementsSmallestFirstAscendingDescending() {
		List<String> test = buildList("apple","melon","zucchini","tomato");
		List<String> truth = buildList("apple","melon","tomato","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort4ElementsLargestFirstAscending() {
		List<String> test = buildList("zucchini","apple","melon","tomato");
		List<String> truth = buildList("apple","melon","tomato","zucchini");
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}
	
	@Test
	void testSort4ElementsLargestFirstDescendingAscending() {
		List<String> test = new ArrayList<>(Arrays.asList("zucchini","melon","apple","tomato"));
		List<String> truth = new ArrayList<>(Arrays.asList("apple","melon","tomato","zucchini"));
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}
	
	@Test
	void testSort4ElementsLargestFirstAscendingDescending() {
		List<String> test = new ArrayList<>(Arrays.asList("zucchini","apple","tomato","melon"));
		List<String> truth = new ArrayList<>(Arrays.asList("apple","melon","tomato","zucchini"));
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}
	
	@Test
	void testSort4ElementsMidFirstAscending() {
		List<String> test = new ArrayList<>(Arrays.asList("melon","apple","tomato","zucchini"));
		List<String> truth = new ArrayList<>(Arrays.asList("apple","melon","tomato","zucchini"));
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort4ElementsMidFirstDescending() {
		List<String> test = new ArrayList<>(Arrays.asList("melon","zucchini","tomato","apple"));
		List<String> truth = new ArrayList<>(Arrays.asList("apple","melon","tomato","zucchini"));
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort4ElementsMidFirstAscendingDescending() {
		List<String> test = new ArrayList<>(Arrays.asList("apple","melon","zucchini","tomato"));
		List<String> truth = new ArrayList<>(Arrays.asList("apple","melon","tomato","zucchini"));
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}

	@Test
	void testSort4ElementsMidFirstDescendingAscending() {
		List<String> test = new ArrayList<>(Arrays.asList("melon","zucchini","apple","tomato"));
		List<String> truth = new ArrayList<>(Arrays.asList("apple","melon","tomato","zucchini"));
		SortingExercises.mergesort(test);
		assertEquals(truth,test);
	}


}
