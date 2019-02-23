package com.kwb.pattern.creational.abstractfactory;

public class ScourgeFactory implements IHeroFactory {
    @Override
    public IStrengthHero getStrengthHero() {
        return new StrengthHero("斧王");
    }

    @Override
    public IAgileHero getAgileHero() {
        return new AgileHero("影魔");
    }

    @Override
    public IIntellectualHero getIntellectualHero() {
        return new IntellectualHero("召唤师");
    }
}
