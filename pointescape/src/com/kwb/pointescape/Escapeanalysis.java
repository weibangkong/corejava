package com.kwb.pointescape;

import java.security.PublicKey;

/**
 * java 逃逸分析
 */
public class Escapeanalysis {
    public static B b;

    /**
     * 全局变量赋值发生指针逃逸
     */
    public void globalVariablePointerEscape() {
        b = new B();
    }

    /**
     * 方法返回引用，发生指针逃逸
     * @return
     */
    public B methodEscape() {
        return new B();
    }

    /**
     * 实例引用发生指针逃逸
     */
    public void instancePassPointerEscape() {
        methodEscape().printClassName(this);
    }


    class B {
        public void printClassName(Escapeanalysis clazz){
            System.out.println(clazz.getClass().getName());
        }

    }
}
