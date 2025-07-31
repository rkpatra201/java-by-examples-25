package com.example.receiver.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileWriterUtil {
    public static void writeBytesToFile(String filePath, byte[] data, int offset) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            raf.seek(offset);
            raf.write(data);
        }
    }
}
