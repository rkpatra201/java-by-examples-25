package com.example.template.models;

import com.example.template.templatefile.FileProcessor;

public class PDFDocument extends FileProcessor {

    @Override
    protected void open() {
        System.out.println("Opening PDF file");
    }

    @Override
    protected void extract() {
        System.out.println("Extracting text from PDF");
    }

    @Override
    protected void process() {
        System.out.println("Processing PDF content");
    }

    @Override
    public void close(){
        System.out.println("closing pdf ...");
    }
}

