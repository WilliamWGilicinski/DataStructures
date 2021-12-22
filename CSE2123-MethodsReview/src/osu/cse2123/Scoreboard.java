/**
 * A program that displays the contents of a pre-formatted list of players and
 * their associated scores
 *
 * @author William Gilicinski
 * @version January 21st, 2021
 */

package osu.cse2123;

/**
 * A file that loads a text file of scores and displays a scoreboard report.
 *
 * @author YOUR NAME HERE
 * @version DATE HERE
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scoreboard {

    /**
     * Loads the two lists from a well-formatted file (as defined in the
     * assignment requirements)
     *
     * @param fname
     * @param keys
     * @param values
     * @precond keys.size() == 0 && values.size() == 0 && fname is the name of a
     *          well-formatted file
     * @postcond keys contains the keys from the file referenced by fname &&
     *           values contains the values from the file referenced by fname
     */
    public static void loadFromFile(String fname, List<String> keys,
            List<Integer> values) throws FileNotFoundException {

        File file = new File(fname);
        Scanner reader = new Scanner(file);
        String temp;
        String key;
        int value;
        int idx;
        while (reader.hasNext()) { //Parses through to find all keys and values
            temp = reader.nextLine();
            idx = temp.indexOf(":");
            key = temp.substring(0, idx);
            value = Integer.parseInt(temp.substring(idx + 1));
            AssocUtils.add(key, value, keys, values);
        }
        reader.close();
    }

    /**
     * Displays the top of the scoreboard and gets the filename from the user
     *
     * @param reader
     * @precond Scanner object must be created in main
     * @precond File name must have a matching file in SRC or loadFromFile will
     *          throw the argument
     * @return the file name the user wants to read from
     */
    public static String header(Scanner reader) {
        System.out.print("Enter a scores file to display: ");
        String fileName = reader.nextLine();
        System.out.println("Player Name              Score");
        System.out.println("------------------------ --------");
        return fileName;
    }

    /**
     * Creates the main part of the scoreboard with the player names and scores
     *
     * @param key
     * @param keys
     * @param values
     * @precond a valid key, keys.size () != 0 && values.size() != 0
     * @postcond The body of the scoreboard will be printed
     */
    public static void body(List<String> keys, List<Integer> values) {
        for (int i = 0; i < keys.size(); i++) {
            //Must be formated this way or it wont pass test cases
            System.out.printf("%-25s%-8s%n", keys.get(i), values.get(i));
        }
    }

    /**
     * Find who scored the most and who scored the least out of every player in
     * the file.
     *
     *
     * @param keys
     * @param values
     * @precond keys != 0 && values != 0
     * @postcond Prints out the player with the max and min score.
     */
    public static void maxMin(List<String> keys, List<Integer> values) {
        int max = values.get(0);
        int min = values.get(0);
        int maxIdx = 0;
        int minIdx = 0;

        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) > max) { //Finds max value
                max = values.get(i);
                maxIdx = i;
            }
            if (values.get(i) < min) { //Finds min value
                min = values.get(i);
                minIdx = i;
            }
        }

        System.out.println("Max scorer is " + keys.get(maxIdx) + " with "
                + AssocUtils.value(keys.get(maxIdx), keys, values));
        System.out.println("Min scorer is " + keys.get(minIdx) + " with "
                + AssocUtils.value(keys.get(minIdx), keys, values));

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);
        List<String> keys = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        String fileName = header(reader);
        loadFromFile(fileName, keys, values);
        body(keys, values);
        System.out.println();
        maxMin(keys, values);
    }

}
