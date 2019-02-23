package com.kwb.pattern.creational.abstractfactory;

public class Main {
    public static void main(String[] args) {
        IHeroFactory sentinelFactory = new SentinelFactory();
        IStrengthHero sentinelStrengthHero = sentinelFactory.getStrengthHero();
        IAgileHero sentinelAgileHero = sentinelFactory.getAgileHero();
        IIntellectualHero sentinelIntellectualHero = sentinelFactory.getIntellectualHero();
        sentinelStrengthHero.createHero();
        sentinelAgileHero.createHero();
        sentinelIntellectualHero.createHero();
    }
}
