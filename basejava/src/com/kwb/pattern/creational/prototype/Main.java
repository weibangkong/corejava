package com.kwb.pattern.creational.prototype;

import java.util.Date;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Message msg = new Message();
        msg.setMessage("请将收割到的灵魂存放在灵魂加工装置");
        msg.setSendDate(new Date());
        Map students = new Reciver().getStudents();
        for (Object name : students.keySet()) {
            Message cloneMsg = msg.clone();
            cloneMsg.setReceiver(students.get(name.toString()).toString());
            send(cloneMsg);
        }
    }

    public static void send(Message msg) {
        System.out.println(msg.getReceiver()+msg.getMessage()+msg.getSendDate());
    }
}
