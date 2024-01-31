package com.github.desn.factory.staticFactory;

public class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("Sms send");
    }

}
