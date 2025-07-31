package com.example.receiver.task;

import com.example.receiver.config.ReceiverConfig;

import java.io.*;
import java.net.Socket;

public class ReceiverTask implements Runnable{
    private final Socket socket;

    public ReceiverTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
             RandomAccessFile output = new RandomAccessFile(ReceiverConfig.OUTPUT_FILE, "rw")) {

            long position = ois.readLong();      // Position to write
            int length = ois.readInt();          // Chunk length
            byte[] data = new byte[length];
            ois.readFully(data);                 // Read the actual chunk

            synchronized (output) {
                output.seek(position);
                output.write(data);
                System.out.println("Wrote chunk at position: " + position);
                System.out.println("Chunk count: "+ ReceiverConfig.count++);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
