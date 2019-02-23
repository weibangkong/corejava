package com.kwb.pattern.structural.proxy;

public class TicketBuyer implements IBuyTicket{
    private String name;

    public TicketBuyer() {
    }

    public TicketBuyer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void login() {
        System.out.println("登陆购票网站");
    }

    @Override
    public void station(String start, String end) {
        System.out.println("起始站: "+start+" - 终点站: "+end);
    }

    @Override
    public void validate() {
        System.out.println("验证通过");
    }

    @Override
    public void payMoney() {
        System.out.println("支付");
    }
}
