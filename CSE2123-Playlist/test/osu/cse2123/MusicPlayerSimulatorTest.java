package osu.cse2123;

/**
 * Test cases for the Music Palyer Simulator
 * 
 * @name Jeremy Morris
 * @version 20201007
 * 
 */
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class MusicPlayerSimulatorTest {

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
			MusicPlayerSimulator.main(new String[0]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public static String loadFromFile(String fname) {
		String result ="";
		try {
			Scanner input = new Scanner(new File(fname));
			while (input.hasNextLine()) {
				result = result+input.nextLine();
				result += System.lineSeparator();
			}
			input.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR - cannot find file "+fname);
		}
		return result;
	}


	@Test
	void testMainTranscript() throws FileNotFoundException {
      String testRun = runMain("input.txt\np\nP\na\nRequiem For A Dying Song\nFlogging Molly\nFloat\ny\nA\nLook What You Made Me Do\nTaylor Swift\nReputation\nY\nq\n");
      String truth = loadFromFile("output_transcript.txt");
      assertEquals(truth,testRun,"transcript output");
	}
	
	@Test
	void testMainSecondTranscript() throws FileNotFoundException {
      String testRun = runMain("input.txt\np\nA\nLook What You Made Me Do\nTaylor Swift\nReputation\nY\np\nP\nP\nq\n");
      String truth = loadFromFile("output_transcript2.txt");
      assertEquals(truth,testRun,"transcript output - second transcript");
	}


}
