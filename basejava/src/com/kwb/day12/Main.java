package com.kwb.day12;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        //下面的一行代码与程序无关
        //普通内部类，需要先实例化外部对象，在由外部对象实例化内部对象,见day03
        TalkingClock.TimePrinter timePrinter = new TalkingClock().new TimePrinter();

        clock.goodTest();
//        clock.start();
        clock.start(clock.getInterval(),clock.isBeep());
        JOptionPane.showMessageDialog(null,"退出程序");
        System.exit(0);

}
}
