package com.example.sender.task;

import com.example.sender.config.SenderConfig;

import java.io.*;
import java.net.Socket;
public class ChunkSenderTask implements Runnable {
    private final String filePath;
    private final int chunkNumber;

    public ChunkSenderTask(String filePath, int chunkNumber) {
        this.filePath = filePath;
        this.chunkNumber = chunkNumber;
    }

    @Override
    public void run() {
        try (FileInputStream fis = new FileInputStream(filePath);
             BufferedInputStream bis = new BufferedInputStream(fis);
             Socket socket = new Socket(SenderConfig.HOST, SenderConfig.PORT);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            int start = chunkNumber * SenderConfig.CHUNK_SIZE;
            byte[] buffer = new byte[SenderConfig.CHUNK_SIZE];

            bis.skip(start);
            int bytesRead = bis.read(buffer);
            if (bytesRead <= 0) return;

            dos.writeInt(chunkNumber);
            dos.writeInt(bytesRead);
            dos.write(buffer, 0, bytesRead);
            dos.flush();

            System.out.println("Sent chunk " + chunkNumber + " (" + bytesRead + " bytes)");

        } catch (IOException e) {
            System.err.println("Error sending chunk " + chunkNumber + ": " + e.getMessage());
        }
    }
}
