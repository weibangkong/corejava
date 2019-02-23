package com.kwb.pattern.creational.singleton;

/**
 * 饿汉式单例
 */
public class HungrySingle {
    private static HungrySingle single = new HungrySingle();

    private HungrySingle() {
    }

    synchronized public static HungrySingle getInstance() {
        return single;
    }
}
