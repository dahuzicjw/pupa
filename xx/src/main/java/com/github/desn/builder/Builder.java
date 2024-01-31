package com.github.desn.builder;

import java.util.ArrayList;

public class Builder {

    private ArrayList<Sender> list = new ArrayList<Sender>();
    
    public void produceMailSender (int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }
    public void produceSmsSender (int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }
}
