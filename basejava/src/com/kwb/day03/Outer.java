package com.kwb.day03;

class Outer {

    class Inner {}//普通静态类,在实例化的时候需要依赖外部类

    public static void foo() {
       new Outer().new Inner();
    }

    public void bar() { new Inner(); }

    public static void main(String[] args) {
        new Outer().new Inner();
    }
}