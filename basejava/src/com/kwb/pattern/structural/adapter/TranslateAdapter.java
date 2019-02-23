package com.kwb.pattern.structural.adapter;

public class TranslateAdapter extends Chinese implements IEnglish {
    @Override
    public void speakEnglish() {
        String speak = super.speakChinese();
        System.out.println("正在翻译");
        System.out.println("Im Chinese ,can`t speak English");
    }
}
