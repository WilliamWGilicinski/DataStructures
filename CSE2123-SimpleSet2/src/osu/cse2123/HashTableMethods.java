package osu.cse2123;

import java.util.List;

/**
 * A simple program that implements a variety of hashtable methods.
 *
 * @author William Gilicinski
 * @version April 19th, 2021
 */

public class HashTableMethods {

    /**
     * Add an element to its correct place in a hashtable
     *
     * @param table
     *            the hash table to add the element to
     * @param value
     *            value to be added
     * @postcond element will be in the correct place in the hashtable
     */
    public static void add(List<List<String>> table, String element) {
        int code = element.hashCode();
        int index = Math.floorMod(code, table.size());
        table.get(index).add(element);
    }

    /**
     * Indicates if a value is in a hashtable or not
     *
     * @param table
     *            the hash table to find the element in
     * @param value
     *            value to be found
     * @return true if value is in the hashtable, false otherwise
     */
    public static boolean find(List<List<String>> table, String element) {
        int code = element.hashCode();
        int index = Math.floorMod(code, table.size());
        return table.get(index).contains(element);
    }

    /**
     * Removes an arbitrary value from a hash table
     *
     * @param table
     *            the hash table to remove the element from
     * @param value
     *            value to be removed
     * @precond value is in the hashtable
     * @postcond value is not in the hashtable
     */
    public static void remove(List<List<String>> table, String element) {
        int code = element.hashCode();
        int bucket = Math.floorMod(code, table.size());
        List<String> list = table.get(bucket);
        int idx = 0;
        while (idx < list.size() && !list.get(idx).equals(element)) {
            idx++;
        }
        table.get(bucket).remove(idx);
    }

    /**
     * Returns a comma-separated list of the elements in the hashtable
     *
     * @param table
     *            the hash table to get a list of elements from
     * @return a comma-separated string of the elements in the hashtable
     */
    public static String values(List<List<String>> table) {
        // Start with an empty String
        String result = "";
        // For each list in the table, concatentate together a string of comma
        // separated values
        for (List<String> list : table) {
            if (result.length() > 0 && list.size() > 0) {
                // only append a comma if the list is not the first list
                // and also has elements in it.
                result = result + ", ";
            }
            result = result + String.join(", ", list);
        }
        return result;
    }

}
