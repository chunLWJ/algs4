package org.example.unit.one;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {

    private Node first;
    public void add(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
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
        Bag<String> bag = new Bag<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                bag.add(item);
        }

        for (String s:bag) {
            StdOut.println(s);
        }
    }
}
