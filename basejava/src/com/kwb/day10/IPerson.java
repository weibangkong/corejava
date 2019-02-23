package com.kwb.day10;

public interface IPerson {
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}
