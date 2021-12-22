package osu.cse2123;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


class AssocUtilsTest {
	
	public static boolean containsSame(List<String> testKeys, List<Integer> testVals, List<String> keys, List<Integer> values) {
		boolean same = testKeys.size() == keys.size() && testKeys.size() == testVals.size() && keys.size() == values.size();
		int idx = 0;
		while (same && idx<testKeys.size()) {
			String key = testKeys.get(idx);
			if (!testKeys.contains(key)) {
				same = false;
			}
			else {
				int i = testKeys.indexOf(key);
				int value = testVals.get(i);
				same = value == values.get(i);
			}
			idx++;
		}
		return same;
	}
			
	@Test
	void testAddToEmpty() {
		List<String> trueKeys = Arrays.asList("a");
		List<Integer> trueVals = Arrays.asList(13);
		List<String> keys = new ArrayList<>();
		List<Integer> values = new ArrayList<>();
		String key = "a";
		int value = 13;
		AssocUtils.add(key, value, keys, values);
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys are not the same");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values are not the same");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs are not the same");
	}
	
	@Test
	void testAddToOneElement() {
		List<String> baseKeys = Arrays.asList("b");
		List<Integer> baseVals = Arrays.asList(-12);
		List<String> trueKeys = Arrays.asList("b","a");
		List<Integer> trueVals = Arrays.asList(-12,13);
		List<String> keys = new ArrayList<>(baseKeys);
		List<Integer> values = new ArrayList<>(baseVals);
		String key = "a";
		int value = 13;
		AssocUtils.add(key, value, keys, values);
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys are not the same");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values are not the same");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs are not the same");
	}
	
	@Test
	void testAddToTwoElement() {
		List<String> baseKeys = Arrays.asList("b","c");
		List<Integer> baseVals = Arrays.asList(-12,156);
		List<String> trueKeys = Arrays.asList("b","c","a");
		List<Integer> trueVals = Arrays.asList(-12,156,13);
		List<String> keys = new ArrayList<>(baseKeys);
		List<Integer> values = new ArrayList<>(baseVals);
		String key = "a";
		int value = 13;
		AssocUtils.add(key, value, keys, values);
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys are not the same");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values are not the same");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs are not the same");
	}
	
	@Test
	void testRemoveToEmpty() {
		List<String> baseKeys = Arrays.asList("b");
		List<Integer> baseVals = Arrays.asList(156);
		List<String> trueKeys = new ArrayList<>();
		List<Integer> trueVals = new ArrayList<>();
		List<String> keys = new ArrayList<>(baseKeys);
		List<Integer> values = new ArrayList<>(baseVals);
		String key = "b";
		int value = AssocUtils.remove(key, keys, values);
		assertEquals(156,value,"removed values do not match");
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys are not the same");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values are not the same");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs are not the same");
	}
	
	@Test
	void testRemoveToOneElement() {
		List<String> baseKeys = Arrays.asList("b","a");
		List<Integer> baseVals = Arrays.asList(-12,13);
		List<String> trueKeys = Arrays.asList("b");
		List<Integer> trueVals = Arrays.asList(-12);
		List<String> keys = new ArrayList<>(baseKeys);
		List<Integer> values = new ArrayList<>(baseVals);
		String key = "a";
		int value = AssocUtils.remove(key, keys, values);
		assertEquals(13,value,"removed values do not match");
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys are not the same");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values are not the same");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs are not the same");
	}

	@Test
	void testRemoveToTwoElements() {
		List<String> baseKeys = Arrays.asList("b","a","c");
		List<Integer> baseVals = Arrays.asList(-12,130,1024);
		List<String> trueKeys = Arrays.asList("b","c");
		List<Integer> trueVals = Arrays.asList(-12,1024);
		List<String> keys = new ArrayList<>(baseKeys);
		List<Integer> values = new ArrayList<>(baseVals);
		String key = "a";
		int value = AssocUtils.remove(key, keys, values);
		assertEquals(130,value,"removed values do not match");
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys are not the same");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values are not the same");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs are not the same");
	}

	@Test
	void testValueOneElement() {
		List<String> baseKeys = Arrays.asList("b");
		List<Integer> baseVals = Arrays.asList(156);
		List<String> trueKeys = new ArrayList<>(baseKeys);
		List<Integer> trueVals = new ArrayList<>(baseVals);
		List<String> keys = new ArrayList<>(baseKeys);
		List<Integer> values = new ArrayList<>(baseVals);
		String key = "b";
		int value = AssocUtils.value(key, keys, values);
		assertEquals(156,value,"values do not match");
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys have changed");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values have changed");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs have changed");
	}

	@Test
	void testValueTwoElements() {
		List<String> baseKeys = Arrays.asList("b","c");
		List<Integer> baseVals = Arrays.asList(156,223);
		List<String> trueKeys = new ArrayList<>(baseKeys);
		List<Integer> trueVals = new ArrayList<>(baseVals);
		List<String> keys = new ArrayList<>(baseKeys);
		List<Integer> values = new ArrayList<>(baseVals);
		String key = "c";
		int value = AssocUtils.value(key, keys, values);
		assertEquals(223,value,"values do not match");
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys have changed");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values have changed");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs have changed");
	}

	@Test
	void testValueThreeElements() {
		List<String> baseKeys = Arrays.asList("d","b","c");
		List<Integer> baseVals = Arrays.asList(-6,156,223);
		List<String> trueKeys = new ArrayList<>(baseKeys);
		List<Integer> trueVals = new ArrayList<>(baseVals);
		List<String> keys = new ArrayList<>(baseKeys);
		List<Integer> values = new ArrayList<>(baseVals);
		String key = "d";
		int value = AssocUtils.value(key, keys, values);
		assertEquals(-6,value,"values do not match");
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys have changed");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values have changed");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs have changed");
	}

	@Test
	void testReplaceOneElement() {
		List<String> baseKeys = Arrays.asList("b");
		List<Integer> baseVals = Arrays.asList(156);
		List<String> trueKeys = new ArrayList<>(baseKeys);
		List<Integer> trueVals = new ArrayList<>(baseVals);
		trueVals.set(0, 15);
		List<String> keys = new ArrayList<>(baseKeys);
		List<Integer> values = new ArrayList<>(baseVals);
		String key = "b";
		int value = AssocUtils.replace(key, 15, keys, values);
		assertEquals(156,value,"values do not match");
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys have changed");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values have changed");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs have changed");
	}

	@Test
	void testReplaceTwoElements() {
		List<String> baseKeys = Arrays.asList("a","b");
		List<Integer> baseVals = Arrays.asList(13, 156);
		List<String> trueKeys = new ArrayList<>(baseKeys);
		List<Integer> trueVals = new ArrayList<>(baseVals);
		trueVals.set(1, 22);
		List<String> keys = new ArrayList<>(baseKeys);
		List<Integer> values = new ArrayList<>(baseVals);
		String key = "b";
		int value = AssocUtils.replace(key, 22, keys, values);
		assertEquals(156,value,"values do not match");
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys have changed");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values have changed");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs have changed");
	}
	
	@Test
	void testReplaceThreeElements() {
		List<String> baseKeys = Arrays.asList("a","b","c");
		List<Integer> baseVals = Arrays.asList(13, -33, 156);
		List<String> trueKeys = new ArrayList<>(baseKeys);
		List<Integer> trueVals = new ArrayList<>(baseVals);
		trueVals.set(2, 1);
		List<String> keys = new ArrayList<>(baseKeys);
		List<Integer> values = new ArrayList<>(baseVals);
		String key = "c";
		int value = AssocUtils.replace(key, 1, keys, values);
		assertEquals(156,value,"values do not match");
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys have changed");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values have changed");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs have changed");
	}

}
