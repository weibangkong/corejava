package com.kwb.pattern.structural.flyweight;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IPrize prize1 = PrizeFactory.getInstance("1000元现金");
        prize1.luckDraw("中奖");
        IPrize prize2 = PrizeFactory.getInstance("500元现金");
        IPrize prize3 = PrizeFactory.getInstance("200元现金");
        Map pool = PrizeFactory.getPool();
        for (Object key : pool.keySet()) {
            PrizeFlyweight prize= (PrizeFlyweight) pool.get(key);
            System.out.println(prize.getPrizeName());
        }
    }
}
