package com.kwb.pattern.creational.factorymethod;

public class BenzE260 implements Benz {
    public BenzE260() {
        this.carColor();
        this.carPrice();
        this.carSpeed();
    }

    @Override
    public void carColor() {
        System.out.println("the color of Benz is red");
    }

    @Override
    public void carSpeed() {
        System.out.println("the speed of Benz is 180 km/h");
    }

    @Override
    public void carPrice() {
        System.out.println("the price of Benz is 120万");
    }
}
