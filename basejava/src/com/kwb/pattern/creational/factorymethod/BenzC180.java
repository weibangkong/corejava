package com.kwb.pattern.creational.factorymethod;

public class BenzC180 implements Benz{
    public BenzC180() {
        this.carColor();
        this.carPrice();
        this.carSpeed();
    }

    @Override
    public void carColor() {
        System.out.println("奔驰C180颜色是银白色");
    }

    @Override
    public void carSpeed() {
        System.out.println("奔驰C180速度是160公里每小时");
    }

    @Override
    public void carPrice() {
        System.out.println("奔驰C180价格是100万");
    }
}
