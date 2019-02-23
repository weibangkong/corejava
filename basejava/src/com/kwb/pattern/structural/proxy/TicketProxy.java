package com.kwb.pattern.structural.proxy;

public class TicketProxy implements IBuyTicket {
    private IBuyTicket buyer;

    public TicketProxy(IBuyTicket buyer) {
        this.buyer = buyer;
    }

    @Override
    public void login() {
        buyer.login();
    }

    @Override
    public void station(String start, String end) {
        buyer.station(start,end);
    }

    @Override
    public void validate() {
        buyer.validate();
    }

    @Override
    public void payMoney() {
        buyer.payMoney();
    }
}
