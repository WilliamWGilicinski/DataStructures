package osu.cse2123;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.jupiter.api.Test;

class GetWordCountsTest {

	private static Map<String,Integer> loadWords(String fname) {
		Map<String,Integer> map = new HashMap<>();
		try {
			Scanner input = new Scanner(new File(fname));
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] vals = line.split(":");
				map.put(vals[0],Integer.parseInt(vals[1]));
			}
			input.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Cannot find file: "+fname);
		}
		return map;
	}

	@Test
	void testMysteriousAffair() throws FileNotFoundException {
		Map<String,Integer> truth = loadWords("mysteriousAffairWordcounts.txt");
		Map<String,Integer> test = WordAnalysis.getWordCounts("mysteriousAffair.txt");
		assertEquals(truth,test,"Mysterious Affair At Styles Wordlist");
	}
	
	@Test
	void testFrankenstein() throws FileNotFoundException {
		Map<String,Integer> truth = loadWords("frankensteinWordcounts.txt");
		Map<String,Integer> test = WordAnalysis.getWordCounts("frankenstein.txt");
		assertEquals(truth,test,"Frankenstein Wordlist");
	}

}
