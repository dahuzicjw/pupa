package com.github.desn.factory.staticFactory;

public class SmsSenderFactory implements Provider {

    public Sender produce() {
        return new SmsSender();
    }
    
}
