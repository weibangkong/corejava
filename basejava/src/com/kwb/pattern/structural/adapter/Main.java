package com.kwb.pattern.structural.adapter;

public class Main {
    public static void main(String[] args) {
        IEnglish english = new TranslateAdapter();
        english.speakEnglish();
    }
}
