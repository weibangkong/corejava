package com.kwb.day10;

public class Student implements IName, IPerson {
    /**
     * 因为继承的两个接口都有getName()方法的默认实现，在Student实现两个接口时，会存在二义性问题，需要成需要来解决
     * 如果两个接口都没有默认实现，则不会存在二义性问题，存在一个实现就会产生二义性问题
     * @return
     */
    @Override
    public String getName() {
        return IPerson.super.getName();
    }
}
