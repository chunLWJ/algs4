package org.example.unit.one;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 定容栈，数组定义的大小便不能再更改了
 * @param <T>
 */
public class FixedCapacityStack<T> {
    private T[] items;
    private int N;

    /**
     * 数组初始化的数量
     * @param cap
     */
    public FixedCapacityStack(int cap) {
        items = (T[])new Object[cap];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void push(T item) {
        if (N == items.length) {
            // throw new ArrayIndexOutOfBoundsException("长度不允许");

            // 或者直接将最后一位排除并重新插入
            this.pop();
        }
        items[N++] = item;
    }
    public T pop() {
        return items[--N];
    }

    @Override
    public String toString() {
        return "FixedCapacityStack{" +
                "items=" + Arrays.toString(items) +
                ", N=" + N +
                '}';
    }

    public static void main(String[] args) {
        FixedCapacityStack<Integer> capacityStack = new FixedCapacityStack<>(2);
        capacityStack.push(1);
        capacityStack.push(2);
        capacityStack.push(3); // 长度划分是2，因此不能 push 多次必须要额外的去处理
        capacityStack.pop();
        capacityStack.size();
        capacityStack.isEmpty();
    }
}
