package com.kwb.pattern.creational.builder;

public class Note8Builder implements CellPhoneBuilder {
    Note8 note8 = new Note8();
    @Override
    public CellPhoneBuilder setCpu() {
        note8.setCpu("骁龙632");
        return this;
    }

    @Override
    public CellPhoneBuilder setRam() {
        note8.setRam("4GB");
        return this;
    }

    @Override
    public CellPhoneBuilder setScreen() {
        note8.setScreen("6.0英寸");
        return this;
    }

    @Override
    public CellPhoneBuilder setBattery() {
        note8.setBattery("3600mAh");
        return this;
    }

    @Override
    public CellPhoneBuilder setFacade() {
        note8.setFacade("4种");
        return this;
    }

    @Override
    public CellPhoneBuilder setOthers() {
        note8.setOthers("见魅族官网");
        return this;
    }

    @Override
    public CellPhone build() {
        return note8;
    }
}
