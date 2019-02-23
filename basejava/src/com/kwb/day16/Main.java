package com.kwb.day16;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.function.IntFunction;

public class Main {
    public static void main(String[] args) {
        Integer[] a = {10, 2, 50, 60, 12, 3};
        Pair<Integer> result = Pair.minmax(a);
        System.out.printf("max:%d  min:%d", result.getFirst(), result.getSecond());
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println();
        String mid_str = getMiddle("Hello", "World", " KWB");
//        double mid_double = getMiddle(4.00, 5, 10.0);//错误的推断可以有两个匹配类型，可以将参数全部改写为double类型
        double mid_double = getMiddle(4.00, 5.0, 10.0);

//        JButton button = getMiddle("Hello", 0, null);//错误理由同上
//        Integer[] a2 = minmax(a);

        /**
         * 下面的报错GG
         */
//        String[] a2 = minmax(Integer[2]::new,"kwb","kwb2");
//        System.out.println(Arrays.toString(a2));

        DateInterval date = new DateInterval(LocalDate.of(2018,12-1,05), LocalDate.of(2018,12-1,06));
        Method[] methods = DateInterval.class.getMethods();
        for (Method method : methods) {
            System.out.print(Modifier.toString(method.getModifiers())+" ");
            System.out.print(method.getReturnType().getName()+" ");
            System.out.print(method.getName()+"(");
            for (Class<?> parameterType : method.getParameterTypes()) {
                System.out.print(parameterType.getName());
            }
            System.out.println(")");
        }
        //运行出结果可以看到多了一个setSecond方法，且该方法的参数类型是Object，泛型方法的类型擦除和多态发生冲突，需要在类中添加一个桥方法

        Pair<String> pair = Pair.makePair(String::new);
    }



    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    //当将Object[]引用赋给Comparable[]时，下面的方法会发生类型转换异常，
    //最好的解决方式是让用户提供一个数组构造器表达式,例: String[] ss = minmax（String[]::new,"kwb1","kwb2","kwb3"）
    public static <T extends Comparable> T[] minmax(T[] a) {
        Object[] mm = new Object[2];
        T max = a[0];
        T min = a[0];
        for (int i = 0; i < a.length; i++) {
            if(max.compareTo(a[i])<0) max = a[i];
            if(min.compareTo(a[i])>0) min = a[i];
        }
        mm[0] = max;
        mm[1] = min;
        return (T[]) mm;
    }

    public static <T extends Comparable> T[] minmax(IntFunction<T[]> constr, T... a) {
        T[] tt = constr.apply(a.length);
        for (int i = 0; i < a.length; i++) {
            tt[i] = a[i];
        }
        return tt;
    }

    //java 核心技术第十版第八章泛型程序设计8.8.4通配符捕获说ArrayList<Pair<T>>中的T永远不能捕获ArrayList<Pair<?>>中的通配符类型
    //原因时编译器必须能够确信通配符表达的是单个、确定的类型(不能理解，单个为什么还要用通配符)
//    public static void arrayListTestOuter(ArrayList<Pair<?>> pairs) {
//        arrayListTestInner(pairs);
//    }
//
//    public static <T> void arrayListTestInner(ArrayList<Pair<T>> pair) {
//
//    }
}
