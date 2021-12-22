package osu.cse2123;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.jupiter.api.Test;

class GetWordsInFileTest {

	private static Set<String> loadWords(String fname) {
		Set<String> set = new HashSet<>();
		try {
			Scanner input = new Scanner(new File(fname));
			while (input.hasNext()) {
				set.add(input.nextLine());
			}
			input.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Cannot find file: "+fname);
		}
		return set;
	}

	@Test
	void testMysteriousAffair() throws FileNotFoundException {
		Set<String> truth = loadWords("mysteriousAffairWordlist.txt");
		Set<String> test = WordAnalysis.getWordsInFile("mysteriousAffair.txt");
		assertEquals(truth,test,"Mysterious Affair At Styles Wordlist");
	}
	
	@Test
	void testFrankenstein() throws FileNotFoundException {
		Set<String> truth = loadWords("frankensteinWordlist.txt");
		Set<String> test = WordAnalysis.getWordsInFile("frankenstein.txt");
		assertEquals(truth,test,"Frankenstein Wordlist");
	}

}
