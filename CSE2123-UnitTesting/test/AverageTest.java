/*
 * @Author: William Gilicinski
 * @Version: January 25th, 2021
 *
 * Test Plan
 * num1      num2        result       reason
 * --------- ----------- ------------ -----------------------------
 * 2         1           1             Even and Odd combination
 * 2         2           2             Same value
 * -2        2           0             Same value, different signs
 * -3        1           -1            Different value, different signs
 * Max       Min         0           Even and Odd combo, different signs
 * 0         0           0             Zero as both numbers
 * 0         Max         1073741823    Half the max
 * 0         Min        -1073741824    Half the min
 * -12901292 -643521    -6772406       Random very low average
 * 897234798 798123      449016460     Random very high average
 * Max       Max         Max           Same both high numbers
 * Min       Min         Min           Same both low numbers
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import osu.cse2123.UnitTesting;

class AverageTest {

    @Test
    void testAverageBothZero() {
        int num1 = 0;
        int num2 = 0;
        int truth = 0;
        int test = UnitTesting.average(num1, num2);
        assertEquals(truth, test, "Both Zero");
    }

    @Test
    void testAverageEvenodd() {
        int num1 = 2;
        int num2 = 1;
        int truth = 1;
        int test = UnitTesting.average(num1, num2);
        assertEquals(truth, test, "Even Odd");
    }

    @Test
    void testAverageSameValueDifferentSigns() {
        int num1 = -2;
        int num2 = 2;
        int truth = 0;
        int test = UnitTesting.average(num1, num2);
        assertEquals(truth, test, "Same value different signs");
    }

    @Test
    void testAverageDifferentValueDifferentSign() {
        int num1 = -3;
        int num2 = 1;
        int truth = -1;
        int test = UnitTesting.average(num1, num2);
        assertEquals(truth, test, "Different Values different signs");
    }

    @Test
    void testAverageMaxMin() {
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MIN_VALUE;
        int truth = 0;
        int test = UnitTesting.average(num1, num2);
        assertEquals(truth, test, "Max and min Values");
    }

    @Test
    void testAverageBothZeros() {
        int num1 = 0;
        int num2 = 0;
        int truth = 0;
        int test = UnitTesting.average(num1, num2);
        assertEquals(truth, test, "Both zeros");
    }

    @Test
    void testAverageMaxCase() {
        int num1 = Integer.MAX_VALUE;
        int num2 = 0;
        int truth = 1073741823;
        int test = UnitTesting.average(num1, num2);
        assertEquals(truth, test, "Max and zero");
    }

    @Test
    void testAverageMinCase() {
        int num1 = Integer.MIN_VALUE;
        int num2 = 0;
        int truth = -1073741824;
        int test = UnitTesting.average(num1, num2);
        assertEquals(truth, test, "Min and zero");
    }

    @Test
    void testAverageRandomLow() {
        int num1 = -12901292;
        int num2 = -643521;
        int truth = -6772406;
        int test = UnitTesting.average(num1, num2);
        assertEquals(truth, test, "Two low numbers");
    }

    @Test
    void testAverageRandomHigh() {
        int num1 = 897234798;
        int num2 = 798123;
        int truth = 449016460;
        int test = UnitTesting.average(num1, num2);
        assertEquals(truth, test, "Two high random numbers");
    }

    @Test
    void testAverageBothMax() {
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        int truth = Integer.MAX_VALUE;
        int test = UnitTesting.average(num1, num2);
        assertEquals(truth, test, "Both Max");
        /*
         * When the max's are added together, it creates an overflow and wraps
         * back around. when two max's are added, they create -2. Then its
         * divided and becomes -1.
         */
    }

    @Test
    void testAverageBothMin() {
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;
        int truth = Integer.MIN_VALUE;
        int test = UnitTesting.average(num1, num2);
        assertEquals(truth, test, "Both min");
        /*
         * Similar situation as the max values, except it overflows the other
         * way and becomes 0.
         */
    }

}
