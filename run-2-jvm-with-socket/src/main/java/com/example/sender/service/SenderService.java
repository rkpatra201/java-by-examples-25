package com.example.sender.service;

import com.example.sender.config.SenderConfig;
import com.example.sender.task.SenderTask;
import com.example.sender.util.FileChunkReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.example.sender.config.SenderConfig.CHUNK_SIZE;

public class SenderService {
    public void start() throws Exception{
        long startTime = System.currentTimeMillis();

        FileChunkReader reader = new FileChunkReader(SenderConfig.FILE_PATH, CHUNK_SIZE);
        long fileSize = reader.getFileSize();
        int numChunks = (int) Math.ceil((double) fileSize / CHUNK_SIZE);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i<numChunks; i++){
            long position = i * CHUNK_SIZE;
            executorService.submit(new SenderTask(position, reader));
        }

        executorService.shutdown();
        while (!executorService.isTerminated()){
            Thread.sleep(5);
        }
        long endTime = System.currentTimeMillis();
        long durationMillis = endTime - startTime;
        System.out.println("Total thread execution time: " + durationMillis + " ms");
        reader.close();
    }



}
