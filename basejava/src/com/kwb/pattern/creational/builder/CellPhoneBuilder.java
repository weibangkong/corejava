package com.kwb.pattern.creational.builder;

public interface CellPhoneBuilder {
    public CellPhoneBuilder setCpu();

    public CellPhoneBuilder setRam();

    public CellPhoneBuilder setScreen();

    public CellPhoneBuilder setBattery();

    public CellPhoneBuilder setFacade();

    public CellPhoneBuilder setOthers();

    public CellPhone build();
}
