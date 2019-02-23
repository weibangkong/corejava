package com.kwb.pattern.structural.facade;

public class Airport {
    public void bookTicket(String start, String end) {
        System.out.println("订购 "+start +" - "+end +" 的机票");
    }

}
