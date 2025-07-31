package com.example.sender.util;

import java.io.RandomAccessFile;

public class FileChunkReader {
    private final RandomAccessFile file;
    private final int chunkSize;

    public FileChunkReader(String filePath, int chunkSize) throws Exception {
        this.file = new RandomAccessFile(filePath, "r");
        this.chunkSize = chunkSize;
    }

    public synchronized byte[] readChunk(long position) throws Exception{
        byte[] buffer;
        file.seek(position);
        long remaining = file.length() - position;
        int size = (int) Math.min(chunkSize,remaining);
        if (size <= 0) {
            return null;
        }
        buffer = new byte[size];
        file.readFully(buffer);
        return buffer;
    }
    public long getFileSize() throws Exception{
        return file.length();
    }
    public void close() throws Exception{
        file.close();
    }
}
