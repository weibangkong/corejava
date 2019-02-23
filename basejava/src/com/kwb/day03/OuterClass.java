package com.kwb.day03;

public class OuterClass {
    private String say = "fun?";
    public String getSay() {
        return say;
    }

    class InnerClass {
        private String say = "Im not fun!";
        public String getSay() {
            return say;
        }
    }

    static class StaticInnerClass {
        private String say = "what`s wrong?";

        public String getSay() {
            return say;
        }
    }

}
