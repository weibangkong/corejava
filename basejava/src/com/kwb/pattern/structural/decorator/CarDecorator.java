package com.kwb.pattern.structural.decorator;

public abstract class CarDecorator {
    private ICar car = null;

    public CarDecorator(ICar car) {
        this.car = car;
    }
    public void show() {
        car.show();
    }
}
