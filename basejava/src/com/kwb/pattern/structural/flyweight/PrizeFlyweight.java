package com.kwb.pattern.structural.flyweight;

/**
 * 具体享元对象
 */
public class PrizeFlyweight implements IPrize {
    private String prizeName;

    public PrizeFlyweight(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    @Override
    public void luckDraw(String result) {
        if ("中奖".equals(result)) {
            System.out.println("恭喜中奖，奖品是："+prizeName);
        }else{
            System.out.println("很遗憾，您未中奖，欢迎再次抽奖");
        }
    }
}
