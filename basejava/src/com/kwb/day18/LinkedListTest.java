package com.kwb.day18;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("amy");
        ll.add("tom");
        ll.add("bob");
        String temp_str = null;
        ListIterator<String> iter = ll.listIterator();
        iter.next();
//        System.out.println(temp_str);
//        ll.add("kwb1");//存在并发修改问题
        iter.add("col");
        iter.add("alice");
        ll.forEach(str -> System.out.println(str));
        System.out.println();
//        Object obj = iter.previous();
        Object obj = iter.next();
        iter.set("123");
        ll.forEach(str -> System.out.println(str));
    }
}
