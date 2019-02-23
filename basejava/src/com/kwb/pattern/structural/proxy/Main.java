package com.kwb.pattern.structural.proxy;

public class Main {
    public static void main(String[] args) {
        IBuyTicket buyer = new TicketBuyer("孔维邦");
        TicketProxy proxy = new TicketProxy(buyer);
        proxy.login();
        proxy.station("天堂","地狱");
        proxy.validate();
        proxy.payMoney();
    }
}
