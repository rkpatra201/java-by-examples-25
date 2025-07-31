package com.example.receiver.app;

import com.example.receiver.config.ReceiverConfig;
import com.example.receiver.service.ReceiverService;
import com.example.sender.config.SenderConfig;


public class Receiver {
    public static void main(String[] args) throws Exception {
        new ReceiverService().start();
        System.out.println("Count: "+ ReceiverConfig.count);
    }
}
