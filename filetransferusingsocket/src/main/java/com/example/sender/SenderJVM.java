package com.example.sender;

import com.example.sender.service.FileChunkSenderService;

public class SenderJVM {
    public static void main(String[] args) throws Exception {
        String filePath = "input.txt";
        new FileChunkSenderService().sendFileChunks(filePath);
    }
}