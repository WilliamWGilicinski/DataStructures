package osu.cse2123;
/**
 * A simple program to test a SimpleQueue implementation.
 *
 * @author Jeremy Morris
 * @version 20201001
 */

public class QueueTesting {

	public static void main(String[] args) {
		SimpleQueue<Integer> q = new SimpleQueueOnLL<>();
		q.add(3);
		q.add(5);
		q.add(7);
		System.out.println(q); // should print < 3 5 7 >
		int val = q.remove();
		System.out.println(val); // should print 3
		System.out.println(q); // should print < 5 7 >
		val = q.remove();
		System.out.println(val); // should print 5
		System.out.println(q); // should print < 7 >
		val = q.remove();
		System.out.println(val); // should print 7
		System.out.println(q); // should print < >
	}

}
