package com.kwb.pattern.creational.builder;

public class Note8 extends CellPhone{

    public Note8() {
        System.out.println("Note8:");
    }

    @Override
    public String toString() {
        return "cpu:" + this.getCpu() + "\n" + "内存:" + this.getRam() + "\n" + "屏幕:" + this.getScreen()
                + "\n" + "电池:" + this.getBattery() + "\n" + "外观:" + this.getFacade() + "\n" + "其他:" + this.getOthers();
    }
}
