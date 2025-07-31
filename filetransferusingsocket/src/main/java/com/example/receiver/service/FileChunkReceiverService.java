package com.example.receiver.service;
import com.example.receiver.config.ReceiverConfig;
import com.example.receiver.util.FileWriterUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class FileChunkReceiverService {
    private volatile int totalChunks = -1;
    private final AtomicInteger receivedChunks = new AtomicInteger(0);

    public void startServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(ReceiverConfig.PORT)) {
            System.out.println("Receiver JVM started. Listening on port " + ReceiverConfig.PORT + "...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        }
    }

    private void handleClient(Socket socket) {
        try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
            int chunkNumber = dis.readInt();

            if (chunkNumber == -1) {
                totalChunks = dis.readInt();
                System.out.println("Expected total chunks: " + totalChunks);
                return;
            }

            int length = dis.readInt();
            byte[] data = new byte[length];
            dis.readFully(data);

            FileWriterUtil.writeBytesToFile(ReceiverConfig.OUTPUT_FILE, data, chunkNumber * ReceiverConfig.CHUNK_SIZE);
            System.out.println("Received chunk " + chunkNumber + " of size " + length);

            if (receivedChunks.incrementAndGet() == totalChunks) {
                System.out.println("All chunks received. File written to: " + ReceiverConfig.OUTPUT_FILE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
