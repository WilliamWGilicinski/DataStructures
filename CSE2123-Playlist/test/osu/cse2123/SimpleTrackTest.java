package osu.cse2123;

/**
 * Test cases for the Simple Music Track object.
 * 
 * @name Jeremy Morris
 * @version 20201007
 * 
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SimpleTrackTest {
	
	static Track[] test;
	
	@BeforeAll
	static void initialize() {
		test = new Track[5];
		test[0] = new SimpleTrack();
		test[0].setName("A Musical Track");
		test[0].setAlbum("An Album Name");
		test[0].setArtist("Anonymous Artist");
		test[1] = new SimpleTrack();
		test[1].setName("A Musical Track");
		test[1].setAlbum("An Album Name");
		test[1].setArtist("Anonymous Artist");
		test[2] = new SimpleTrack();
		test[2].setName("A Different Track");
		test[2].setAlbum("An Album Name");
		test[2].setArtist("Anonymous Artist");
		test[3] = new SimpleTrack();
		test[3].setName("A Musical Track");
		test[3].setAlbum("A Different Album");
		test[3].setArtist("Anonymous Artist");
		test[4] = new SimpleTrack();
		test[4].setName("A Musical Track");
		test[4].setAlbum("An Album Name");
		test[4].setArtist("A Different Artist");
		
	}
	
	@Test
	void testToString() {
		assertEquals("'Anonymous Artist / A Musical Track / An Album Name'",test[0].toString());
	}
	
	@Test
	void testToStringDifferentTrack() {
		assertEquals("'Anonymous Artist / A Different Track / An Album Name'",test[2].toString());
	}
	
	@Test
	void testToStringDifferentAlbum() {
		assertEquals("'Anonymous Artist / A Musical Track / A Different Album'",test[3].toString());
	}
	
	@Test
	void testToStringDifferentArtist() {
		assertEquals("'A Different Artist / A Musical Track / An Album Name'",test[4].toString());
	}



	@Test
	void testName() {
		assertEquals("A Musical Track", test[0].getName());
	}
	
	@Test
	void testAlbum() {
		assertEquals("An Album Name",test[0].getAlbum());
	}
	
	@Test
	void testArtist() {
		assertEquals("Anonymous Artist",test[0].getArtist());
	}
	
	@Test
	void testEqualsSame() {
		assertEquals(test[0],test[1]);
	}

	@Test
	void testNotEqualsName() {
		assertNotEquals(test[0],test[2]);
	}
	
	@Test
	void testNotEqualsAlbum() {
		assertNotEquals(test[0],test[3]);
	}
	
	@Test
	void testNotEqualsArtist() {
		assertNotEquals(test[0],test[4]);
	}

	@Test
	void testNotEqualsVsString() {
		assertNotEquals(test[0],"Anonymous Artist");
	}

	
	@Test
	void testHashCodeSameValue() {
		assertEquals(test[0].hashCode(),test[1].hashCode());
	}
	
	@Test
	void testHashCodeAtLeastOneDifferent() {
		int i = 2;
		boolean same = true;
		while (i < test.length && same) {
			same = test[0].hashCode() == test[i].hashCode();
		}
		assertTrue(!same);
	}

}
