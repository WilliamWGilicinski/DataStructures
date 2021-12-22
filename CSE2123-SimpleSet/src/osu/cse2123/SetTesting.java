
package osu.cse2123;

/**
 * A set of tests for the SimpleTreeSet class.
 *
 * @author Jeremy Morris
 * @version 10202020
 */
public class SetTesting {

    public static void main(String[] args) {
        SimpleSet mySet = new SimpleTreeSet();
        System.out.println(mySet.size()); // 0
        mySet.add("melon");
        System.out.println(mySet); // { melon }
        mySet.add("zebra");
        System.out.println(mySet); // { melon, zebra }
        mySet.add("peanut");
        System.out.println(mySet); // { melon, peanut, zebra }
        mySet.add("coconut");
        System.out.println(mySet); // { coconut, melon, peanut, zebra }
        mySet.add("nectarine");
        System.out.println(mySet); // { coconut, melon, nectarine, peanut, zebra }
        mySet.remove("melon");
        System.out.println(mySet); // { coconut, nectarine, peanut, zebra }
        System.out.println(mySet.size()); // 4
        System.out.println(mySet.contains("coconut")); // true
        System.out.println(mySet.contains("melon")); // false
        System.out.println(mySet.contains("aardvark"));// false
    }
}
