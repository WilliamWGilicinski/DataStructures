/*
 * @author: William Gilicinski
 * @version: February 11th, 2019
 *
 * Linear Search:
 * abundance - 8 comparisons at index 7
 * important - 1500 comparisons at index 1499
 * key       - 1593 comparisons at index 1592
 * thin      - 2975 comparisons at index 2974
 * zoos      - 3399 comparisons at index -1
 *
 * The best case for linear search is the String "a" as it would find it on the first run through.
 * The worst case for linear search is the String "zoos" as it would run 3399 to find nothing.
 *
 * Binary Search:
 * abundance - 12 comparisons at index 7
 * important - 8 comparisons at index 1499
 * key       - 5 comparisons at index 1592
 * thin      - 3 comparisons at 2974
 * zoos      - 12 comparisons at index -1
 *
 * The best case for binary search is limitation as that is the middle index and would find it on the first run through.
 *
 */

package osu.cse2123;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchingMethods {

    /**
     * Performs linear search to find the index of an element, or -1 if the
     * element is not in the list.
     *
     * @param str
     *            String to look for
     * @param list
     *            List to search
     * @postcond prints the count of the number of steps taken to the screen
     * @return -1 if str is not in list, or the index of the first occurrence of
     *         str if it is in the list.
     */
    public static int linearSearch(String str, List<String> list) {
        int result = -1;
        for (int i = 0; i < list.size() && result < 0; i++) {
            if (list.get(i).equals(str)) {
                result = i;
            }
            System.out.println("Comparing " + list.get(i) + " and " + str + " "
                    + (i + 1) + " comparisons");
        }

        return result;
    }

    /**
     * Performs binary search to find the index of an element, or -1 if the
     * element is not in the list.
     *
     * @param str
     *            String to look for
     * @param list
     *            List to search
     * @precond list is in ascending sorted order (smallest to largest)
     * @postcond prints the count of the number of steps taken to the screen
     * @return -1 if str is not in list, or the index of any occurrence of str
     *         if it is in the list.
     */
    public static int binarySearch(String str, List<String> list) {
        int result = -1;
        int first = 0, last = list.size() - 1;
        for (int i = 0; result < 0 && first <= last; i++) {
            int midpoint = (first + last) / 2;
            System.out.println("Comparing " + list.get(midpoint) + " and " + str
                    + " " + (i + 1) + " comparisons");
            if (list.get(midpoint).equals(str)) {//returns back if str and the current list string are equal
                result = midpoint;
            } else {
                int count = 0;
                //while loop goes through the list word and sees where which letter differs
                while (str.charAt(count) == list.get(midpoint).charAt(count)
                        && count < str.length()
                        && count < list.get(midpoint).length() - 1) {
                    count++;
                }
                //if finds the relation between the different letters
                if (str.charAt(count) > list.get(midpoint).charAt(count)) {
                    first = midpoint + 1;
                } else if (count == str.length()) {//else ifs determine what happens if the letters never differ.
                    last = midpoint - 1;
                } else if (count == list.get(midpoint).length()) {
                    first = midpoint + 1;
                } else {
                    last = midpoint - 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        try {
            File words = new File("wordlist.txt");
            Scanner reader = new Scanner(words);
            while (reader.hasNext()) {
                list.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Binary");

        String[] words = { "abundance", "important", "key", "thin", "zoos" };
        for (int i = 0; i < words.length; i++) {
            System.out.println("Looking for " + words[i]);
            int idx = binarySearch(words[i], list);
            System.out.println(words[i] + " found at index " + idx);
            System.out.println();
        }

        System.out.println("Linear");

        for (int i = 0; i < words.length; i++) {
            System.out.println("Looking for " + words[i]);
            int idx = linearSearch(words[i], list);
            System.out.println(words[i] + " found at index " + idx);
            System.out.println();
        }

    }

}
