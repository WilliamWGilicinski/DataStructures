package osu.cse2123;

/**
 * Test cases for the Product class
 * 
 * @name Jeremy Morris
 * @version 20201007
 * 
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ProductTest {
	
	static Product test;
	
	@BeforeAll
	static void initialize() {
		test = new Product();
		test.setName("Test Product");
		test.setInventoryCode("123456");
		test.setPrice(1000);
		test.setQuantity(5);
		test.addUserRating(3);
		test.addUserRating(6);
	}

	@Test
	void testName() {
		assertEquals("Test Product", test.getName());
	}
	
	@Test
	void testInventoryCode() {
		assertEquals("123456",test.getInventoryCode());
	}
	
	@Test
	void testPrice() {
		assertEquals(1000,test.getPrice());
	}
	
	@Test
	void testQuantity() {
		assertEquals(5, test.getQuantity());
	}
	
	@Test
	void testGetUserRating0() {
		assertEquals(3, test.getUserRating(0));
	}
	
	@Test
	void testGetUserRating1() {
		assertEquals(6, test.getUserRating(1));
	}
	
	@Test
	void testGetAvgUserRating() {
		assertEquals(4,test.getAvgUserRating());
	}
	

}
