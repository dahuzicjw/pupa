package com.c.j.w.desn.factory.multiMethod;

public class FactoryTest {

    public static void main(String[] args) {
        Sender sender = new SenderFactory().produceMailSender();
        sender.send();
    }
}
