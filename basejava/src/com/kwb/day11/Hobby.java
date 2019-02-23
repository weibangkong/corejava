package com.kwb.day11;

public class Hobby {
    private boolean eat;
    private boolean say;
    private boolean sing;
    private boolean sleep;
    private String other;

    public Hobby(boolean eat, boolean say, boolean sing, boolean sleep, String other) {
        this.eat = eat;
        this.say = say;
        this.sing = sing;
        this.sleep = sleep;
        this.other = other;
    }

    public boolean isEat() {
        return eat;
    }

    public void setEat(boolean eat) {
        this.eat = eat;
    }

    public boolean isSay() {
        return say;
    }

    public void setSay(boolean say) {
        this.say = say;
    }

    public boolean isSing() {
        return sing;
    }

    public void setSing(boolean sing) {
        this.sing = sing;
    }

    public boolean isSleep() {
        return sleep;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "eat=" + eat +
                ", say=" + say +
                ", sing=" + sing +
                ", sleep=" + sleep +
                ", other='" + other + '\'' +
                '}';
    }
}
