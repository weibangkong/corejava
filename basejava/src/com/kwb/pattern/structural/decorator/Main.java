package com.kwb.pattern.structural.decorator;

public class Main {
    public static void main(String[] args) {
        ICar benz = new BenzE260();
        CarDecorator decorator = new ConcreteCarDecorator(benz);
        decorator.show();
    }
}
