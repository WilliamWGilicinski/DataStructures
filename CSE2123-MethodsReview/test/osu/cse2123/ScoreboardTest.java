package osu.cse2123;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ScoreboardTest {
	
	private static String runMain(String input) {
		 // Set System.in and System.out to our test values
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);

        InputStream oldInput = System.in;
        InputStream newInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(newInput);


        // Run the actual project here, output will go into baos, input will
        // come from newInput.
        // This is implemented in the child class inherited from ProjectTest
        // for flexibility.
        try {
        	Scoreboard.main(new String[0]);
        }
        catch (FileNotFoundException e) {
        	return "File Not Found";
        }

        // Put System.out and System.in back to what they were.
        // IMPORTANT - make sure to flush System.out so it all gets written
        // to the ByteArray
        System.out.flush();
        System.setOut(old);
        System.setIn(oldInput);

        // Return our output as a String instead of as a ByteArray
        return baos.toString();
	}

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
	void testLoadFromFile() throws FileNotFoundException {
		List<String> trueKeys = Arrays.asList("Joe Siegel","Ramona Fradon","Bob Kane","Marie Severin","Barbara Hall","Arnold Drake");
		List<Integer> trueVals = Arrays.asList(12000,12500,300,10000,9600,9000);
		List<String> keys = new ArrayList<>();
		List<Integer> values = new ArrayList<>();
		Scoreboard.loadFromFile("scores.txt", keys, values);
		assertTrue(trueKeys.containsAll(keys) && keys.containsAll(trueKeys),"keys are not the same");
		assertTrue(trueVals.containsAll(values) && values.containsAll(trueVals),"values are not the same");
		assertTrue(containsSame(trueKeys,trueVals, keys, values),"pairs are not the same");
	}
	
	@Test
	void testMain() throws FileNotFoundException {
       String testRun = runMain("scores.txt");
       Scanner tmp = new Scanner(new File("output.txt")).useDelimiter("\\A");
       String truth = tmp.next();
       assertEquals(truth,testRun,"scoreboard output");
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String output = runMain("scores.txt");
		PrintWriter pw = new PrintWriter("output.txt");
		pw.print(output);
		pw.close();
	}

}
