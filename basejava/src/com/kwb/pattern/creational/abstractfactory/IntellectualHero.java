package com.kwb.pattern.creational.abstractfactory;

public class IntellectualHero implements IIntellectualHero {
    private String name;

    public IntellectualHero(String name) {
        super();
        this.name = name;
    }

    @Override
    public void createHero() {
        System.out.println("创建智力型英雄: " + this.name);
    }
}
