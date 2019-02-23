package com.kwb.pattern.creational.abstractfactory;

public class StrengthHero implements IStrengthHero{
    private String name;

    public StrengthHero(String name) {
        super();
        this.name = name;
    }

    @Override
    public void createHero() {
        System.out.println("创建力量型英雄: "+this.name);
    }
}
