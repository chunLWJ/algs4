package org.example.unit.one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    private Node first;
    private int N;

    @Override
    public String toString() {
        return "Stack{" +
                "first=" + first +
                ", N=" + N +
                '}';
    }

    public boolean isEmpty(){
        return first == null;
    }
    public int size(){ return N; };
    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public T pop(){
        T item = first.item;
        first = first.next;
        N--;
        return item;
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
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if(!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");

        for (String s:stack) {
            StdOut.println(s);
        }
    }
}
