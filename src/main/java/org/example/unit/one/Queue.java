package org.example.unit.one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int N;
    public boolean isEmpty(){ return first == null; }
    public int size() { return N; }
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }
    public T dequeue(){
        T item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "first=" + first +
                ", last=" + last +
                ", N=" + N +
                '}';
    }

    private class Node {
        T item;
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {

        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                queue.enqueue(item);
            else if(!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on stack)");
        for (String s:queue) {
            StdOut.println(s);
        }
    }
}
