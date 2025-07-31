package com.example.receiver;

import com.example.receiver.service.FileChunkReceiverService;

public class ReceiverJVM {
    public static void main(String[] args) throws Exception {
        new FileChunkReceiverService().startServer();
    }
}