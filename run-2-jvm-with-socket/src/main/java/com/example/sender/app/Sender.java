package com.example.sender.app;

import com.example.sender.service.SenderService;

public class Sender {

    public static void main(String[] args) throws Exception {
        new SenderService().start();
    }
}
