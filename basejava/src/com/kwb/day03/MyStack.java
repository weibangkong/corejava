package com.kwb.day03;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] elements;
    private int size = 0;

    private static final int INIT_CAPACITY = 16;

    public MyStack() {
        elements = (T[]) new Object[INIT_CAPACITY];
    }

    public void push(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            return elements[--size];
        }
    }
    //数组扩容并转移元素
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        MyStack<String> memorytest = new MyStack<String>();
        memorytest.push("现在其实也不知道");
        memorytest.push("刚开始我就不知道你为什么和我在一起");
        memorytest.push("我不怪你");
        memorytest.push("承认吧");
        memorytest.push("XXX");
        memorytest.push("你其实就是不爱我了");
        System.out.println(memorytest.pop());
        System.out.println(memorytest.pop());
        System.out.println(memorytest.pop());
        System.out.println(memorytest.pop());
        System.out.println(memorytest.pop());
        System.out.println(memorytest.pop());
    }
}
