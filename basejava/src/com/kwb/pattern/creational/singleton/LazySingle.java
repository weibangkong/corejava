package com.kwb.pattern.creational.singleton;

public class LazySingle {
    private static LazySingle single;

    private LazySingle() {
    }

    /**
     * 添加synchronized关键字防止多个线程导致的违反单例
     * @return
     */
    synchronized public static LazySingle getInstance() {
        if(null==single){
            single = new LazySingle();
        }
        return single;
    }
}
