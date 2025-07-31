package com.example.sender.service;

import com.example.sender.config.SenderConfig;
import com.example.sender.task.ChunkSenderTask;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileChunkSenderService {
    public void sendFileChunks(String filePath) throws Exception {
        File file = new File(filePath);
        long fileSize = file.length();
        int totalChunks = (int) Math.ceil((double) fileSize / SenderConfig.CHUNK_SIZE);

        System.out.println("Total Chunks to send: " + totalChunks);

        sendTotalChunkCount(totalChunks);

        ExecutorService executor = Executors.newFixedThreadPool(SenderConfig.THREAD_COUNT);
        for (int i = 0; i < totalChunks; i++) {
            executor.submit(new ChunkSenderTask(filePath, i));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }
        System.out.println("All chunks sent successfully.");
    }

    private void sendTotalChunkCount(int totalChunks) throws IOException {
        try (Socket socket = new Socket(SenderConfig.HOST, SenderConfig.PORT);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            dos.writeInt(-1);
            dos.writeInt(totalChunks);
            dos.flush();
        }
    }
}
