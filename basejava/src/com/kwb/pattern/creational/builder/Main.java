package com.kwb.pattern.creational.builder;

public class Main {
    public static void main(String[] args) {
        CellPhoneBuilder note8builder = new Note8Builder();
        note8builder.setBattery().setScreen().setRam().setOthers().setFacade().setCpu();
        CellPhone note8 = note8builder.build();
        System.out.println(note8);
    }
}
