package com.cmy.desn.factory.normal;

public class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("Sms send");
    }

}
