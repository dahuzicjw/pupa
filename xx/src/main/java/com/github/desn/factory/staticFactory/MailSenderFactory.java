package com.github.desn.factory.staticFactory;

public class MailSenderFactory implements Provider {

    public Sender produce() {
        return new MailSender();
    }
    
}
