package com.kwb.pattern.creational.builder;

public class Mate20 extends CellPhone {
    public Mate20() {
        System.out.println("Mate20:\n");
    }

    @Override
    public String toString() {
        return "cpu:" + this.getCpu() + "\n" + "内存:" + this.getRam() + "\n" + "屏幕:" + this.getScreen()
                + "\n" + "电池:" + this.getBattery() + "\n" + "外观:" + this.getFacade() + "\n" + "其他:" + this.getOthers();
    }
}
