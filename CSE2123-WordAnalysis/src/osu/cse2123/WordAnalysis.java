package osu.cse2123;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author William Gilicinski
 * @version March 4th, 2021
 *
 */

public class WordAnalysis {

    /**
     * Returns the sequence of non letter or digits from the input String str.
     *
     * @param str
     *            String that does not start with a letter or digit
     * @precond str starts with 1 or more non-letter or digit characters
     * @return the sequence of non-letter and digits that start str
     */
    public static String getNextNonTokenSequence(String str) {
        boolean valid = true;
        int count = 0;
        String sequence = "";

        //While loop parses through the string and checks if the next symbol
        //in the string is a digit or letter.
        while (valid) {
            sequence += str.substring(count, count + 1);
            if ((count + 1) >= str.length()) {
                valid = false;
            } else if (Character.isDigit(str.charAt(count + 1))
                    || Character.isLetter(str.charAt(count + 1))) {
                valid = false;
            } else {
                count++;
            }
        }
        return sequence;
    }

    /**
     * Returns the sequence of letter or digits from the input String str.
     *
     * @param str
     *            String that starts with a letter or digit
     * @precond str starts with 1 or more letter or digit characters
     * @return the sequence of letter and digits that start str
     */
    public static String getNextTokenSequence(String str) {
        boolean valid = true;
        int count = 0;
        String sequence = "";

        //While loop does the same thing as the non-sequence but has a ! in the
        //else if statement
        while (valid) {
            sequence += str.substring(count, count + 1);
            if ((count + 1) >= str.length()) {
                valid = false;
            } else if (!(Character.isDigit(str.charAt(count + 1))
                    || Character.isLetter(str.charAt(count + 1)))) {
                valid = false;
            } else {
                count++;
            }
        }
        return sequence;
    }

    /**
     * Returns a queue of words from the input String str
     *
     * @param str
     *            string to split into words
     * @return a queue of words from the string str
     */
    public static Queue<String> splitWords(String str) {
        Queue<String> wordList = new LinkedList<>();
        String temp = "";
        int idx = 0;
        int ogLength = str.length(); //will not change size

        //While loop runs until the end of the string. The string changes sizes
        //through substrings and depending on what str.charAt(0) is, it will
        //call the right method
        while (idx < ogLength) {
            if (Character.isDigit(str.charAt(0))
                    || Character.isLetter(str.charAt(0))) {
                temp = getNextTokenSequence(str);
                wordList.add(temp);
                str = str.substring(temp.length());
                idx += temp.length();
            } else {
                temp = getNextNonTokenSequence(str);
                str = str.substring(temp.length());
                idx += temp.length();
            }
        }

        return wordList;
    }

    /**
     * Returns a set of words from the input file fname.
     *
     * @param fname
     *            filename of words file to read
     * @return a set of words from the input file.
     */
    public static Set<String> getWordsInFile(String fname)
            throws FileNotFoundException {

        File wordFile = new File(fname);
        Scanner fileScan = new Scanner(wordFile);
        Set<String> set = new HashSet<>();
        Queue<String> wordList = new LinkedList<>();

        //Reads in a line of text and then empties it into the set
        while (fileScan.hasNextLine()) {
            String temp = fileScan.nextLine();
            wordList = splitWords(temp);
            while (!wordList.isEmpty()) {
                set.add(wordList.remove());
            }
        }

        fileScan.close();

        return set;
    }

    /**
     * Returns a map of word counts from the input file fname.
     *
     * @param fname
     *            filename of words file to read
     * @return a map of words and counts from the input file.
     */
    public static Map<String, Integer> getWordCounts(String fname)
            throws FileNotFoundException {

        Map<String, Integer> wordCounts = new HashMap<>();
        Queue<String> wordList = new LinkedList<>();
        File wordFile = new File(fname);
        Scanner fileScan = new Scanner(wordFile);

        //Because sets do not contain duplicates, the file must be parsed with
        //a queue but instead of putting it into a set, it's put into a map
        while (fileScan.hasNext()) {
            wordList = splitWords(fileScan.nextLine());
            while (!wordList.isEmpty()) {
                //if the word is already in the map, the value will increment
                if (wordCounts.containsKey(wordList.element())) {
                    int val = wordCounts.remove(wordList.element());
                    val++;
                    wordCounts.put(wordList.remove(), val);
                } else {
                    wordCounts.put(wordList.remove(), 1);
                }
            }
        }

        fileScan.close();
        return wordCounts;
    }

    public static void main(String[] args) throws FileNotFoundException {

        //prompts the user for a filename and last word
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        String fname = reader.nextLine();
        Map<String, Integer> map = getWordCounts(fname);
        System.out.print("Last word: ");
        String lastWord = reader.nextLine();

        //creates a set containing all the keys
        Set<String> keys = getWordsInFile(fname);

        //transfers the set of keys to a priority queue
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (String key : keys) {
            pq.add(key);
        }

        //Prints out the queue in lexographical order with the value associated
        //with it
        while (!pq.isEmpty() && pq.contains(lastWord)) {
            String word = pq.remove();
            System.out.println(word + ":" + map.get(word));
        }

        reader.close();

    }

}
