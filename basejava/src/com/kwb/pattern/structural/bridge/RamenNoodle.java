package com.kwb.pattern.structural.bridge;

public class RamenNoodle extends Noodle {
    public RamenNoodle(ISeasoning seasoning) {
        super(seasoning);
    }

    @Override
    public String getNoodle() {
        return seasoning.addSeasoning() + "的拉面";
    }
}
