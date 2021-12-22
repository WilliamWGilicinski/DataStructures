
/**
 * @author William Gilicinski
 * @version Januray 31st, 2021
 *
 * Test Plan (all even)
 * arr           result      reason
 * ------------- ----------- -------------
 * []            true        empty arrays hold true
 * [1,2]         false       1 is odd
 * [2,2]         true        both 2's are even
 * [-2,2]        true        both -1 2's are even
 * [Max, Min]    false       Max is odd
 * [Min, Min]    true        Min is even
 *
 * Bug would override when an array value was odd to true, and an empty array
 * also would never pass as true. This was fixed by changing the initialization
 * of the boolean variable to true and then turning it to false when it finds
 * an odd number
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import osu.cse2123.UnitTesting;

class AllEvenTest {

    @Test
    void testEmpty() {//Didn't pass, initialization was false
        int[] nums = {};
        boolean truth = true;
        boolean test = UnitTesting.allEven(nums);
        assertEquals(truth, test, "empty");
    }

    @Test
    void testOneTwo() { //Didn't pass, 2 overwrote the one being an odd number
        int[] nums = { 1, 2 };
        boolean truth = false;
        boolean test = UnitTesting.allEven(nums);
        assertEquals(truth, test, "One and two");
    }

    @Test
    void testTwoTwos() {
        int[] nums = { 2, 2 };
        boolean truth = true;
        boolean test = UnitTesting.allEven(nums);
        assertEquals(truth, test, "Two twos");
    }

    @Test
    void testTwoNegativeTwos() {
        int[] nums = { -2, 2 };
        boolean truth = true;
        boolean test = UnitTesting.allEven(nums);
        assertEquals(truth, test, "Negative two and two");
    }

    @Test
    void testMaxAndMin() {//Didn't pass, Min overwrote max being an odd number
        int[] nums = { Integer.MAX_VALUE, Integer.MIN_VALUE };
        boolean truth = false;
        boolean test = UnitTesting.allEven(nums);
        assertEquals(truth, test, "Max and min");
    }

    @Test
    void testTwoMins() {
        int[] nums = { Integer.MIN_VALUE, Integer.MIN_VALUE };
        boolean truth = true;
        boolean test = UnitTesting.allEven(nums);
        assertEquals(truth, test, "Min and min");
    }

}
