package com.kwb.pattern.structural.bridge;

public abstract class Noodle {
    ISeasoning seasoning;

    public Noodle(ISeasoning seasoning) {
        this.seasoning = seasoning;
    }

    public abstract String getNoodle();
}
