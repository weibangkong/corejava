package com.kwb.pattern.creational.builder;

public class Mate20Builder implements CellPhoneBuilder {

    Mate20 mate20 = new Mate20();
    @Override
    public Mate20Builder setCpu() {
        mate20.setCpu("麒麟980");
        return this;
    }

    @Override
    public Mate20Builder setRam() {
        mate20.setRam("6GB");
        return this;
    }

    @Override
    public Mate20Builder setScreen() {
        mate20.setScreen("SONY");
        return this;
    }

    @Override
    public Mate20Builder setBattery() {
        mate20.setBattery("4000mAh");
        return this;
    }

    @Override
    public Mate20Builder setFacade() {
        mate20.setFacade("五种配色");
        return this;
    }

    @Override
    public Mate20Builder setOthers() {
        mate20.setOthers("见华为官网");
        return this;
    }

    @Override
    public CellPhone build() {
        return this.mate20;
    }
}
