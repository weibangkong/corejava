package com.kwb.day08;

public enum ColorEnum {

    YELLOW("黄色", "yellow"),
    BLACK("黑色","black"),
    RED("红色","red"),
    BLUE("蓝色","blue");

    private String chineseName;
    private String englishName;
    ColorEnum(String chineseName, String englishName) {
        this.chineseName = chineseName;
        this.englishName = englishName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

}
