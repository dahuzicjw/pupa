package com.cmy.desn.factory.staticFactory;

public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("Mail send");
    }

}
