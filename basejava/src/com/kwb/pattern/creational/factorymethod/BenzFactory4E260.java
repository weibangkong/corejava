package com.kwb.pattern.creational.factorymethod;

public class BenzFactory4E260 implements BenzFactory{
    @Override
    public Benz createCar() {
        return new BenzE260();
    }
}
