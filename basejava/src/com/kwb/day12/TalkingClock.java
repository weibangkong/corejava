package com.kwb.day12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class TalkingClock {
    private int interval;
    private boolean beep;

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isBeep() {
        return beep;
    }

    public void setBeep(boolean beep) {
        this.beep = beep;
    }

    public TalkingClock() {
    }

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * 普通内部类
     */
    class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the zone ,the time is  " + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();//if(beep) 等价于if(TalkingClock.this.beep) ，后者为正规引用

        }
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    /**
     * 下面为局部内部类示例
     * 局部内部类不能被public 或 private修饰，作用于被限定在声明该局部内部类的块中
     * 局部内部类可以对外部完全吟唱，即使其外部类也不能访问他，只有所在块知道它的存在
     */
    public void start1() {

        class TimePrinter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("at now, the time is " + new Date());
                if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
            }
        }

        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(TalkingClock.this.interval, listener);
        timer.start();
    }


    public void start(int interval, boolean beep) {
        class TimePrinter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("the time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }

        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    /**
     * 下面为匿名内部类示例，相比与局部内部类更加简洁，直接创建一个ActionListener对象
     *
     * @param interval
     * @param beep
     */
    public void start1(int interval, boolean beep) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("the time: " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    /**
     * 下面为使用lambda表达式实现，直接将要执行的代码传入
     *
     * @param interval
     * @param beep
     */
    public void start3(int interval, boolean beep) {
        Timer timer = new Timer(interval, e -> {
            System.out.println("lambda--time is:" + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        });
        timer.start();
    }


    public void goodTest(){
        /**
         * 下面的技巧为“双括号初始化”，其中外面的括号建立ArrayList的一个匿名子类，内层括号则是对象构造块
         */
        ArrayList<String> list =  new ArrayList<String>() {
            {
                add("happy");
                add("sad");
            }
        };
        System.out.println(list.toString());
    }


}
