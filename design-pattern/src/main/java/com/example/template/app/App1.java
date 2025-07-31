package com.example.template.app;

import com.example.template.models.PDFDocument;
import com.example.template.models.WordDocument;
import com.example.template.templatefile.FileProcessor;

public class App1 {
    public static void main(String[] args) {
        FileProcessor pdf = new PDFDocument();
        pdf.processFile();

        System.out.println("------------");

        FileProcessor word = new WordDocument();
        word.processFile();
    }
}
