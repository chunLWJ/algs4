package org.example.unit.one;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 可调整数组容器
 * 长度满 -> [] 长度扩充一倍
 * 长度缩小到 四分之一，长度减半
 * @param <T>
 */
public class ResizingArrayStack<T> implements Iterable {
    private T[] items = (T[]) new Object[1];
    private int N = 0;
    public boolean isEmpty(){ return N == 0; }
    public int size(){ return N; }

    /**
     * 重置数组大小
     * @param max
     */
    private void resize(int max) {
        T[] items = (T[]) new Object[max];
        for (int i=0; i<N; i++) 
            items[i] = this.items[i];
        this.items = items;
    }
    
    public void push(T item) {
        if (N == items.length) resize(2 * items.length);
        items[N++] = item;
    }
    public T pop(){
        T item = items[N--];
        items[N] = null;
        if (N > 0 && N == items.length / 4) 
            resize(items.length / 2);
        return item;
    }

    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }
    
    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return items[--i];
        }

        @Override
        public void remove() {
            
        }
    }

    @Override
    public String toString() {
        return "ResizingArrayStack{" +
                "items=" + Arrays.toString(items) +
                ", N=" + N +
                '}';
    }

    public static void main(String[] args) {

        ResizingArrayStack<Integer> resizingArrayStack = new ResizingArrayStack<>();
        resizingArrayStack.push(1);
        resizingArrayStack.push(2);
        resizingArrayStack.push(3); // 长度划分是2，因此不能 push 多次必须要额外的去处理
        resizingArrayStack.pop();
        resizingArrayStack.size();
        resizingArrayStack.isEmpty();
        for (Object o : resizingArrayStack) {
            System.out.println(((Integer)o).toString());
        }


    }
}
