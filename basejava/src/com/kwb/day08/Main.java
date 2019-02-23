package com.kwb.day08;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("kwb");
        list.set(0, "kwb1");

        Integer a = 1000;
        Integer b = 1000;

//        System.out.println(a == b);
//        System.out.println(a.equals(b));

        Double c = 1000d;
        System.out.println("a: " + a );
        System.out.println("c: " + c);
        System.out.println(true ? c :a);

        changeIntegerValue(b);
        System.out.println(b);
        System.out.println(ColorEnum.RED.getChineseName());
        ColorEnum[] color = ColorEnum.values();
        System.out.println(Arrays.toString(color));
        System.out.println(ColorEnum.class.getName());
        System.err.println("----------------------------------------------");
        System.out.println(Enum.valueOf(ColorEnum.class,"RED"));
    }

    public static void changeIntegerValue(Integer integer) {
        integer = 3 * integer;
    }

}
