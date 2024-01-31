package com.github.desn.factory.normal;

public class FactoryTest {

    public static void main(String[] args) {
        Sender sender = new SenderFactory().produce("Sms");
        sender.send();
    }
}
