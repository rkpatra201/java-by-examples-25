package com.example.sender.task;

import com.example.sender.config.SenderConfig;
import com.example.sender.util.FileChunkReader;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SenderTask implements Runnable{
    private final long position;
    private final FileChunkReader reader;

    public SenderTask(long position, FileChunkReader reader) {
        this.position = position;
        this.reader = reader;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket(SenderConfig.HOST, SenderConfig.PORT);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())){

            byte[] chunk = reader.readChunk(position);
            if (chunk != null){
                objectOutputStream.writeLong(position);
                objectOutputStream.writeInt(chunk.length);
                objectOutputStream.write(chunk);
                objectOutputStream.flush();
                System.out.println("Sent chunk at position: "+ position);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
