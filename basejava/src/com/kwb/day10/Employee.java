package com.kwb.day10;

public class Employee extends Person implements IName{
    /**
     * 当一个类从超类和接口中继承了相同的方法，遵循"类优先"原则，只会考虑超类方法，而接口中的默认实现会被忽略
     * @return
     */
    @Override
    public String getName() {
        return null;
    }
}
