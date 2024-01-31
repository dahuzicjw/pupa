package com.github.desn.factory.normal;

public class SenderFactory {

    public Sender produce(String type) {
        if ("Main".equals(type)) {
            return new MailSender();
        } else if ("Sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("wrong type");
            return null;
        }

    }
}
