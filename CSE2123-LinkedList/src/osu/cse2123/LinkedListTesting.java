package osu.cse2123;
/**
 * A simple program to test a SimpleLinkedList implementation.
 *
 * @author Jeremy Morris
 * @version 20201001
 */

public class LinkedListTesting {

	public static void main(String[] args) {
		SimpleLinkedList<Integer> list = new SimpleLinkedListManual<>();
		list.addFront(3);
		list.addFront(5);
		list.addEnd(7);
		System.out.println(list); // should print < 5 3 7 >
		int val = list.removeFront();
		System.out.println(val); // should print 5
		System.out.println(list); // should print < 3 7 >
		val = list.removeEnd();
		System.out.println(val); // should print 7
		System.out.println(list); // should print < 3 >
		val = list.removeFront();
		System.out.println(val); // should print 3
		System.out.println(list); // should print < >
	}

}
