package com.kwb.day09;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTableTest {
    public static void main(String[] args) {
        try {
            Method square = MethodTableTest.class.getMethod("square", double.class);
            Method sqrt = Math.class.getMethod("sqrt", double.class);

            printTable(1,10,10,square);
            printTable(1,10,10,sqrt);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static double square(double x) {
        return x * x;
    }

    public static void printTable(double from, double to, int n, Method f) {
        System.out.println(f);
        double dx = (to - from) / (n - 1);
        for (double x = from; x <= to; x += dx) {
            try {
                double y = (double) f.invoke(null, x);
                System.out.printf("%10.4f  |  %10.4f%n",x,y);//约定精度%x.xf
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
