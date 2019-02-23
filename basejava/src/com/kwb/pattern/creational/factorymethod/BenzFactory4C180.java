package com.kwb.pattern.creational.factorymethod;

public class BenzFactory4C180 implements BenzFactory {
    @Override
    public Benz createCar() {
        return new BenzC180();
    }
}
