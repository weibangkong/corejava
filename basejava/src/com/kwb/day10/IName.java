package com.kwb.day10;

public interface IName {
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}
