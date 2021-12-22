package osu.cse2123;

/**
 * An implementation of a Queue on a manual linked list
 *
 * @author William Gilicinski
 * @version March 29th, 2021
 */
public class SimpleQueueOnLL<E> implements SimpleQueue<E> {

    private class Node {
        E data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    /**
     * Creates an empty queue
     */
    public SimpleQueueOnLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(E val) {
        Node temp = new Node();
        temp.data = val;

        //If the queue is empty, points the head and tail to the node
        if (this.size == 0) {
            this.head = temp;
            this.tail = temp;
            //points the end of the queue to the new node and points the tail node
            //to the new node
        } else {
            this.tail.next = temp;
            this.tail = temp;
        }
        this.size++;
    }

    @Override
    public E front() {
        return this.head.data;
    }

    @Override
    public E remove() {
        E temp = this.head.data;
        if (this.size == 1) {
            //Makes the head and tail node null when there's only one node left
            this.head = null;
            this.tail = null;
        } else {
            //Makes the head of the tail the one after the head of the tail
            this.head = this.head.next;
        }
        this.size--;
        return temp;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String output = "< ";
        Node temp = new Node();
        temp = this.head;
        for (int i = 0; i < this.size; i++) {
            output += temp.data + " ";
            temp = temp.next;
        }
        output += ">";
        return output;
    }

}
