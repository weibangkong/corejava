package com.kwb.pattern.creational.factorymethod;

public class Main {
    public static void main(String[] args) {
        BenzFactory c180Factory = new BenzFactory4C180();
        c180Factory.createCar();
    }
}
