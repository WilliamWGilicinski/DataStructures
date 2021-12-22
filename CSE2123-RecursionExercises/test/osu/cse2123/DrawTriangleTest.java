package osu.cse2123;
/**
 * Test cases for the drawTriangle method in RecursionExercises
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class DrawTriangleTest {
	
	private String sep = System.lineSeparator();
	
	private static String runMain(int size) {
		 // Set System.in and System.out to our test values
       // Create a stream to hold the output
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
       PrintStream ps = new PrintStream(baos);
       // IMPORTANT: Save the old System.out!
       PrintStream old = System.out;
       // Tell Java to use your special stream
       System.setOut(ps);

       // Run the actual project here, output will go into baos, input will
       // come from newInput.
       // This is implemented in the child class inherited from ProjectTest
       // for flexibility.
       	RecursionExercises.drawTriangle(size);

       // Put System.out and System.in back to what they were.
       // IMPORTANT - make sure to flush System.out so it all gets written
       // to the ByteArray
       System.out.flush();
       System.setOut(old);

       // Return our output as a String instead of as a ByteArray
       return baos.toString();
	}

	@Test
	void testDrawTriangle0() {
		String truth = "";
		int size = 0;
		String test = runMain(size);
		assertEquals(truth,test);
	}

	@Test
	void testDrawTriangle1() {
		String truth = "*"+sep;
		int size = 1;
		String test = runMain(size);
		assertEquals(truth,test);
	}
	
	@Test
	void testDrawTriangle2() {
		String truth = "**"+sep+"*"+sep;
		int size = 2;
		String test = runMain(size);
		assertEquals(truth,test);
	}

	@Test
	void testDrawTriangle3() {
		String truth = "***"+sep+"**"+sep+"*"+sep;
		int size = 3;
		String test = runMain(size);
		assertEquals(truth,test);
	}

	@Test
	void testDrawTriangle4() {
		String truth = "****"+sep+"***"+sep+"**"+sep+"*"+sep;
		int size = 4;
		String test = runMain(size);
		assertEquals(truth,test);
	}
}
