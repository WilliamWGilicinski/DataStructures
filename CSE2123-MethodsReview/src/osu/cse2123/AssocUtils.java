
package osu.cse2123;

/**
 * A utility class for dealing with parallel arrays
 *
 * @author William Gilicinski
 * @version January 19th, 2021
 */
import java.util.ArrayList;
import java.util.List;

public class AssocUtils {

    /**
     * Returns the value associated with a key from a pair of associated lists.
     *
     * @param key
     *            the key to look up in the pair of lists
     * @param keys
     *            the list of keys
     * @param values
     *            the associated list of values
     *
     * @precond key is in the list keys && keys.size() == values.size()
     * @return the value in values associated with key
     */
    public static int value(String key, List<String> keys,
            List<Integer> values) {
        int ind = keys.indexOf(key);
        return values.get(ind);
    }

    /**
     * Adds a key/value pair to a pair of associated lists. The key must NOT be
     * in the keys list when this method is called.
     *
     * @param key
     *            the key to add to the keys list
     * @param value
     *            the value to add to the associated values list associated with
     *            key
     * @param keys
     *            the list of keys
     * @param values
     *            the associated list of values
     *
     * @precond key is not in keys && keys.size() == values.size()
     * @postcond key is in keys and value is in values and key and value have
     *           the same index
     */
    public static void add(String key, int value, List<String> keys,
            List<Integer> values) {
        keys.add(key);
        values.add(value);

    }

    /**
     * Removes a key/value pair from a pair of associated lists. The key must be
     * in the keys list when this method is called.
     *
     * @param key
     *            the key to remove from the keys list
     * @param keys
     *            the list of keys
     * @param values
     *            the associated list of values
     *
     * @precond key is in keys && keys.size() == values.size()
     * @postcond key is not in keys and the value associated with key is not in
     *           values
     * @return the value that was associated with key
     */
    public static int remove(String key, List<String> keys,
            List<Integer> values) {
        int idx = keys.indexOf(key);
        int num = values.get(idx);//Must get the number to return before deleting it
        keys.remove(key);
        values.remove(idx);

        return num;
    }

    /**
     * Replaces the value of an existing key/value pair from a pair of
     * associated lists and returns the old value associated with the key.
     *
     * @param key
     *            the key to replace the associated value
     * @param value
     *            the value to substitute in
     * @param keys
     *            the list of keys
     * @param values
     *            the associated list of values
     *
     * @precond keys.size() == values.size() && key is in keys
     * @postcond the entry in values associated with key is now value
     * @return the old entry associated with key
     */
    public static int replace(String key, int value, List<String> keys,
            List<Integer> values) {
        int idx = keys.indexOf(key);
        int oldValue = values.get(idx);
        values.set(idx, value);

        return oldValue;
    }

    public static void main(String[] args) {
        // TODO:  Use this method as scratch space to test your AssocUtils methods
        // Note that this method does not need to do anything in particular for this lab
        // it is purely for your own testing.
        List<String> keys = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        AssocUtils.add("first", 100, keys, values);
        System.out.println(keys); // should print [first] if you've implemented add correctly.
        System.out.println(values); // should print [100] if you've implemented add correctly.
    }

}
