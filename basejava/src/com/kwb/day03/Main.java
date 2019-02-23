package com.kwb.day03;


public class Main {
    public static void main(String[] args) {
        //内部类的实例化
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        System.out.println(outerClass.getSay());
        System.out.println(innerClass.getSay());
        //静态嵌套类的实例化
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        System.out.println(staticInnerClass.getSay());
    }
}
