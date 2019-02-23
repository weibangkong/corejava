package com.kwb.pattern.structural.facade;

public class Main {
    public static void main(String[] args) {
        Secretary secretary = new Secretary();
        System.out.println("给我定好从北京去伦敦的机票，我要去10天");
        secretary.makeplan("北京","伦敦",10);
    }
}
