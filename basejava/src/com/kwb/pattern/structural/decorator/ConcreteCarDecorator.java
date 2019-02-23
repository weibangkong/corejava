package com.kwb.pattern.structural.decorator;

public class ConcreteCarDecorator extends CarDecorator {
    public ConcreteCarDecorator(ICar car) {
        super(car);
    }
    public void setGrapher() {
        System.out.println("安装行车记录仪");
    }
    public void setGps() {
        System.out.println("安装定位导航系统");
    }
    public void setCushion() {
        System.out.println("安装座垫，并贴上警示语");
    }
    public void show() {
        super.show();
        this.setGrapher();
        setGps();
        setCushion();
    }
}
