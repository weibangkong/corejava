package com.kwb.day16;

import java.util.function.Supplier;

public class Pair<T> {
    private T first;
    private T second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public Pair() {
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public static <T extends Comparable> T min(T[] a) {
        if(a == null || a.length == 0) return null;
        T min = a[0];
        for (int i = 0; i < a.length; i++) {
            if(min.compareTo(a[i])>0) min = a[i];
        }
        return min;
    }

    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if(a == null || a.length==0) return null;
        T max = a[0];
        T min = a[0];
        for (int i = 0; i < a.length; i++) {
            if(max.compareTo(a[i])<0) max = a[i];
            if(min.compareTo(a[i])>0) min = a[i];
        }
        return new Pair<>(max, min);
    }


    //让调用者提供给一个构造器表达式，Supplier是一个函数式接口，表示一个五阐述而且返回类型为T的函数
    public static <T> Pair<T> makePair(Supplier<T> constr) {
        return new Pair<>(constr.get(), constr.get());
    }

    //通过反射  Class.newInstance()
    public static <T> Pair<T> makePair(Class<T> cl) {
        try {
            return new Pair<T>(cl.newInstance(), cl.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //该方法错误
//    public static <T> Pair<Integer> minmax(Integer[] a) {
//        if(a == null ||a.length == 0) return null;
//        Integer max = a[0];
//        Integer min = a[0];
//        for (int i = 0; i < a.length; i++) {
//            if(max.compareTo(a[i])<0) max = a[i];
//            if(min.compareTo(a[i])>0) min = a[i];
//        }
//        return new Pair<Integer>(max, min);
//    }

    public static void swap(Pair<?> p) {
        swapHelper(p);
    }

    //通配符捕获，下面的方法定义只有个在T指出类型时才有明确的含义
    public static <T> void swapHelper(Pair<T> pair) {
        T t = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(t);
    }


    public static void minmaxBonus(Manager[] a, Pair<? super Manager> pair) {
        if(a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 0; i < a.length; i++) {
            if(min.getBonus()>a[i].getBonus()) min = a[i];
            if(max.getBonus()<a[i].getBonus()) max = a[i];
        }
        pair.setFirst(max);
        pair.setSecond(min);
    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> pair) {
        //计算
        minmaxBonus(a, pair);
        //交换
        swap(pair);
    }
}
