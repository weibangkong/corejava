package com.kwb.pattern.creational.abstractfactory;

public class AgileHero implements IAgileHero{
    private String name;

    public AgileHero(String name) {
        super();
        this.name = name;
    }

    @Override
    public void createHero() {
        System.out.println("创建敏捷型英雄: "+this.name);
    }
}
