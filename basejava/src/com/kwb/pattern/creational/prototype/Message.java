package com.kwb.pattern.creational.prototype;

import java.util.Date;

public class Message implements Cloneable {
    private String receiver;
    private String message;
    private Date sendDate;

    public Message(String receiver, String message, Date sendDate) {
        this.receiver = receiver;
        this.message = message;
        this.sendDate = sendDate;
    }

    public Message() {
    }

    public Message(String message, Date sendDate) {
        this.message = message;
        this.sendDate = sendDate;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Message clone() {
        Message msg = new Message();
            try {
                msg = (Message) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        return msg;
    }
}
