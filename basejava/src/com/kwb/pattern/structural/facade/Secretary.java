package com.kwb.pattern.structural.facade;


public class Secretary {
    private Chauffeur chauffeur = new Chauffeur();
    private Airport airport = new Airport();
    private Hotel hotel = new Hotel();

    public void makeplan(String start,String end,int days) {
        chauffeur.driver("机场");
        airport.bookTicket(start,end);
        hotel.bookRoom(days);
    }
}
