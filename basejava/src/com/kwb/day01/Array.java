package com.kwb.day01;

import java.util.Arrays;

public class Array {

    //    public static void main(String[] args) {
//        int[] arr1 = new int[]{1, 2, 3, 4, 5};
//        int[] arr2 = arr1;
//        int[] arr3 = Arrays.copyOf(arr1, arr1.length);
//        System.out.println("arr1:"+arr1.hashCode()+" , "+Arrays.toString(arr1));
//        System.out.println("arr2:"+arr2.hashCode()+" , "+Arrays.toString(arr2));
//        System.out.println("arr3:"+arr3.hashCode()+" , "+Arrays.toString(arr3));
//        arr2[3] = 30;
//        System.out.println("arr1:"+arr1.hashCode()+" , "+Arrays.toString(arr1));
//        System.out.println("arr2:"+arr2.hashCode()+" , "+Arrays.toString(arr2));
//        System.out.println("arr3:"+arr3.hashCode()+" , "+Arrays.toString(arr3));
//    }

    public static void main(String[] args) {
//        Array arrtest = new Array();
//        int a = 99;
//        arrtest.test1(a);
//        System.out.println("a1:"+a);
//        MyObj myObj = new MyObj();
//        arrtest.test2(myObj);
//        System.out.println("b:"+myObj.b);
//        ClassLoader classLoader = myObj.getClass().getClassLoader();
//        System.out.println(classLoader.getClass());
//        ClassLoader classloader2 = classLoader.getParent();
//        System.out.println(classloader2.getClass());
//        ClassLoader classLoader3 = classLoader.getSystemClassLoader();
//        System.out.println(classLoader3.getClass());
        Integer[] int_arr = new Integer[6];
        int_arr[0] = 1;
        int_arr[1] = -5;
        int_arr[2] = 9500;
        int_arr[3] = 400;
        int_arr[4] = 50;
        int_arr[5] = 1024;
//        System.out.println(Arrays.toString(int_arr));
//        Arrays.sort(int_arr);
//        System.out.println(Arrays.toString(int_arr));
//        String[] str_arr = new String[6];
//        str_arr[0] = "can i help you";
//        str_arr[1] = "no,thanks";
//        str_arr[2] = "breakup";
//        str_arr[3] = "hangout";
//        str_arr[4] = "to be die";
//        str_arr[5] = "shit";
        System.out.println(Arrays.binarySearch(int_arr,0,int_arr.length-1,400));
        System.out.println(Arrays.binarySearch(int_arr,1024));
    }

    static class MyObj {
        public int b = 99;
    }

    public void test1(int a) {
        ++a;
        System.out.println("the value of a in the method:"+a);
    }

    public void test2(MyObj myObj) {
        myObj.b++;
        System.out.println("the value of b in the method:"+myObj.b);
    }
}
