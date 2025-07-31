package com.example.receiver.service;

import com.example.receiver.config.ReceiverConfig;
import com.example.receiver.task.ReceiverTask;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReceiverService {
    public void start() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();

        try (ServerSocket serverSocket = new ServerSocket(ReceiverConfig.PORT)) {
            System.out.println("Receiver listening on port " + ReceiverConfig.PORT);

            while (true) {
                Socket client = serverSocket.accept();
                executor.submit(new ReceiverTask(client));
//                ReceiverConfig.count++;
            }
        }
    }

}
