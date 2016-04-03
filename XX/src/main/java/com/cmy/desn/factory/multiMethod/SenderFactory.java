package com.cmy.desn.factory.multiMethod;

public class SenderFactory {

    public Sender produceSmsSender() {
        return new SmsSender();
    }
    public Sender produceMailSender() {
        return new MailSender();
    }
    
}
