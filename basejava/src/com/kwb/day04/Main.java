package com.kwb.day04;

public class Main {
    public static void main(String[] args) {
        StaticParam staticParam1 = new StaticParam(5);
        System.out.println("1:"+staticParam1.getNormalMember());
        System.out.println("1:"+StaticParam.getStaticMember());
        StaticParam staticParam2 = new StaticParam(6);
        System.out.println("2:"+staticParam2.getNormalMember());
        System.out.println("2:"+StaticParam.getStaticMember());
        StaticParam staticParam3 = new StaticParam(7);
        System.out.println("3:"+staticParam3.getNormalMember());
        System.out.println("3:"+StaticParam.getStaticMember());
    }
}
