package com.kwb.day04;

public class StaticParam {
    private static int staticMember = 0;
    private int  normalMember = 5;
    public static int getStaticMember() {
        return staticMember;
    }
    public int getNormalMember() {
        return normalMember;
    }
    public void setNormalMember(int normalMember) {
        this.normalMember = normalMember;
    }
    public StaticParam() {
        staticMember++;
    }
    public StaticParam(int normalMember) {
        this.normalMember = normalMember;
        staticMember++;
    }
}
