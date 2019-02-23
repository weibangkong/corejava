package com.kwb.pattern.structural.bridge;

public class Main {
    public static void main(String[] args) {
        ISeasoning pepper = new Pepper();
        Noodle ramenNoodle = new RamenNoodle(pepper);
        System.out.println("A:"+ramenNoodle.getNoodle());

        ISeasoning vinegar = new Vinegar();
        Noodle slicedNoodle = new SlicedNoodles(vinegar);
        System.out.println("B:"+slicedNoodle.getNoodle());
    }
}
