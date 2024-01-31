package com.github.desn.factory.normal;

public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("Mail send");
    }

}
