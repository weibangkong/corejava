package com.kwb.pattern.creational.abstractfactory;

public interface IHeroFactory {
    //获得力量型英雄
    public IStrengthHero getStrengthHero();
    //获得敏捷型英雄
    public IAgileHero getAgileHero();
    //获得智力型英雄
    public IIntellectualHero getIntellectualHero();
}
