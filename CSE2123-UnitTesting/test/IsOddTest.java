
/**
 * @author William Gilicinski
 * @version January 31st, 2021
 *
 * Test Plan
 * num1      result   reason
 * --------- -------- --------------------
 * 0         false    0 is even
 * Max       true     Max is odd
 * Min       false    Min is even
 * 1         true     1 is odd
 * -1        true     -1 is odd
 *
 * The bug was that it improperly calculated the negative values and there
 * must be an Math.abs around the num as the remainder of -1 / 2 = -1
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import osu.cse2123.UnitTesting;

class IsOddTest {

    @Test
    void testZero() {
        int num = 0;
        boolean truth = false;
        boolean test = UnitTesting.isOdd(num);
        assertEquals(truth, test, "zero");
    }

    @Test
    void testMax() {
        int num = Integer.MAX_VALUE;
        boolean truth = true;
        boolean test = UnitTesting.isOdd(num);
        assertEquals(truth, test, "Max");
    }

    @Test
    void testMin() {
        int num = Integer.MIN_VALUE;
        boolean truth = false;
        boolean test = UnitTesting.isOdd(num);
        assertEquals(truth, test, "Min");
    }

    @Test
    void testOne() {
        int num = 1;
        boolean truth = true;
        boolean test = UnitTesting.isOdd(num);
        assertEquals(truth, test, "One");
    }

    @Test
    void testNegativeOne() {//Didn't pass, didn't evaluate negatives correctly
        int num = -1;
        boolean truth = true;
        boolean test = UnitTesting.isOdd(num);
        assertEquals(truth, test, "Negative One");
    }

}
