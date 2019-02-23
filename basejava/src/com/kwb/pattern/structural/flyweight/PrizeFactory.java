package com.kwb.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class PrizeFactory {
    private static Map<String, IPrize> prizePool = new HashMap<>();

    public  static IPrize getInstance(String prizeName) {
        IPrize prize = prizePool.get(prizeName);
        if (null == prize) {
            prize = new PrizeFlyweight(prizeName);
            prizePool.put(prizeName, prize);
        }
        return prize;
    }
    public static Map getPool() {
        return prizePool;
    }
}
