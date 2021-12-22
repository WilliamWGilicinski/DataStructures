/*                  wordlist.txt | wordlist_shuffled.txt | wordlist_reversed.txt
 *Selection Sort    5778300      |  5778300              |  5778300
 *                               |                       |
 *Insertion Sort    3398         |  2858869              |  5774901
 *                               |                       |
 *Quick Sort        5774901      |  44994                |  5774901
 *
 *
 *4. Selection sort had all three files as the best and worst case
 *
 *   Insertion sory had the best case with the standard file and the worst with
 *   the reversed file.
 *
 *   Quick sort had the best case with the shuffled file but the worst with both
 *   the standard and reversed file.
 *
 *5. I would expect the quick sort to have the best because usually lists are
 *   unordered to begin with, so although the ordered and reversed list
 *   performed poorly, in the average setting it will do well.
 */

package osu.cse2123;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A series of methods to implement the selection sort and insertion sort
 * algorithsm, as well as recursive mergesort and quicksort algorithms.
 *
 * @author William Gilicinski
 * @version February 15 2021
 */

public class SortingExercises {

    private static int counter = 0;

    /**
     * Swaps two elements in a List
     *
     * @param list
     *            list to be searched
     * @param i
     *            first index to swap
     * @param j
     *            second index to swap
     * @precond 0 <= i < list.size() && 0 <= j < list.size()
     * @postcond list elements at i and j swapped from their original positions
     */
    public static void swap(List<String> list, int i, int j) {
        String tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    /**
     * Sorts a list in place using the Selection Sort algorithm.
     *
     * @param list
     *            list to be sorted
     *
     * @postcond list changed to be in ascending order
     */
    public static void selectionSort(List<String> list) {
        int idx = 0;
        while (idx < list.size()) {
            int smallest = idx;
            for (int i = idx; i < list.size(); i++) {
                //   System.out.println("Comparing " + list.get(smallest) + " vs. "
                //        + list.get(i));
                SortingExercises.counter++;
                if (list.get(i).charAt(0) < list.get(smallest).charAt(0)) {
                    smallest = i;
                }
            }
            // System.out.println("Swapping " + list.get(smallest) + " with "
            //         + list.get(idx));
            swap(list, idx, smallest);
            idx++;
        }
    }

    /**
     * Sorts a list in place using the Insertion Sort algorithm.
     *
     * @param list
     *            list to be sorted
     *
     * @postcond list changed to be in ascending order
     */
    public static void insertionSort(List<String> list) {
        for (int idx = 1; idx < list.size(); idx++) {
            String insert = list.get(idx);
            int scan = idx;
            // System.out.println(
            //        "Comparing " + insert + " vs. " + list.get(scan - 1));
            SortingExercises.counter++;
            while (scan > 0 && list.get(scan - 1).compareTo(insert) > 0) {
                list.set(scan, list.get(scan - 1));
                scan--;
                if (scan >= 1) {
                    // System.out.println("Comparing " + insert + " vs. "
                    //         + list.get(scan - 1));
                    SortingExercises.counter++;
                }
            }
            list.set(scan, insert);
            //  System.out
            //          .println("Inserting " + insert + " into position " + scan);
        }
    }

    /**
     * Determines a "pivot" value and separates a list into a left list with
     * elements <= the pivot (but not the pivot element itself) and a right list
     * with elements > the pivot. The list is cleared by this method, and left
     * and right are not guaranteed to be sorted.
     *
     * @param list
     *            - the original list to be divided
     * @param left
     *            - the elements less than the pivot element
     * @param right
     *            - the elements greater than the pivot element
     * @precond left.size() == 0 && right.size() == 0 && list.size() >= 1
     * @postcond left contains all elements of list <= the pivot element &&
     *           right contains all elements of list > the pivot element &&
     *           list.size() == 0
     * @return the pivot element (the first element of the original list)
     */
    public static String partition(List<String> list, List<String> left,
            List<String> right) {

        String pivot = list.get(0);
        list.remove(0);

        while (list.size() > 0) {
            for (int i = 0; i < list.size() && list.size() > 0; i++) {
                String temp = list.get(0);
                list.remove(0);
                // System.out.println("Comparing " + temp + " to " + pivot);
                SortingExercises.counter++;
                if (temp.compareTo(pivot) > 0) {
                    right.add(temp);
                } else {
                    left.add(temp);
                }
            }
        }
        return pivot;
    }

    /**
     * Sorts a list with the quicksort algorithm
     *
     * @param list
     *            list to be sorted
     * @postcond list is in ascending order
     */
    public static void quicksort(List<String> list) {
        // An empty list does not need to be sorted.
        if (list.size() > 1) {
            // Create two lists
            List<String> left = new ArrayList<>();
            List<String> right = new ArrayList<>();
            // Partition around a pivot element
            String pivot = partition(list, left, right);
            // Recursively call quicksort
            quicksort(left);
            quicksort(right);
            // merge the lists together, including the pivot element
            list.addAll(left);
            list.add(pivot);
            list.addAll(right);
        }
    }

    /**
     * Breaks the input parameter list into half, with the front half put into
     * the list front and the back half into the list back. The original list is
     * cleared by this method.
     *
     * @param list
     *            list to be split
     * @param front
     *            first half of the original list
     * @param back
     *            back half of the original list
     * @precond front.size() == 0 && back.size() == 0 && list.size() >= 1
     * @postcond list.size() == 0 && front.size() = list.size()/2 && back.size()
     *           == list.size()/2
     */
    public static void splitList(List<String> list, List<String> front,
            List<String> back) {
        // TODO Your code here
    }

    /**
     * Merges two sorted lists into a single sorted list
     *
     * @param result
     *            list to merge the two lists into
     * @param list1
     *            first list to merge
     * @param list2
     *            second list to merge
     * @precond list1 is in sorted order && list2 is in sorted order && result
     *          is empty
     * @postcond result is in sorted order && list1 is empty && list2 is empty
     */
    public static void merge(List<String> result, List<String> list1,
            List<String> list2) {
        // TODO Your code here
    }

    /**
     * Sorts a list with the mergesort algorithm
     *
     * @param list
     *            list to be sorted
     * @postcond list is in ascending order
     */
    public static void mergesort(List<String> list) {
        // An empty list does not need to be sorted
        if (list.size() > 1) {
            List<String> front = new ArrayList<>();
            List<String> back = new ArrayList<>();
            splitList(list, front, back);
            mergesort(front);
            mergesort(back);
            merge(list, front, back);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a file name");
        String name = in.nextLine();

        try {
            File wordlist = new File(name);
            Scanner fileScan = new Scanner(wordlist);
            List<String> list = new ArrayList<>();
            while (fileScan.hasNext()) {
                list.add(fileScan.next());
            }
            System.out.println(list);
            SortingExercises.counter = 0;
            quicksort(list);
            System.out.println(list);
            System.out.println("Insertion sort made: "
                    + SortingExercises.counter + " comparisons");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
