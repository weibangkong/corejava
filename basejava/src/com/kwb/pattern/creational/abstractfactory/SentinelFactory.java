package com.kwb.pattern.creational.abstractfactory;

public class SentinelFactory implements IHeroFactory {
    @Override
    public IStrengthHero getStrengthHero() {
        return new StrengthHero("流浪刺客");
    }

    @Override
    public IAgileHero getAgileHero() {
        return new AgileHero("剑圣");
    }

    @Override
    public IIntellectualHero getIntellectualHero() {
        return new IntellectualHero("仙女龙");
    }
}
