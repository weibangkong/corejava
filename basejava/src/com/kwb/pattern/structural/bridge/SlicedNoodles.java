package com.kwb.pattern.structural.bridge;

public class SlicedNoodles extends Noodle {
    public SlicedNoodles(ISeasoning seasoning) {
        super(seasoning);
    }

    @Override
    public String getNoodle() {
        return seasoning.addSeasoning() + "的刀削面";
    }
}
