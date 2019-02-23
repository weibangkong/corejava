package com.kwb.pattern.structural.proxy;

public interface IBuyTicket {
    public void login();

    public void station(String start, String end);

    public void validate();

    public void payMoney();
}
