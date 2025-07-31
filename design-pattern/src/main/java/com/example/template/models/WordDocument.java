package com.example.template.models;

import com.example.template.templatefile.FileProcessor;

public class WordDocument extends FileProcessor {

    @Override
    protected void open() {
        System.out.println("Opening Word document");
    }

    @Override
    protected void extract() {
        System.out.println("Extracting text from Word document");
    }

    @Override
    protected void process() {
        System.out.println("Processing Word content");
    }

    @Override
    protected void close(){
        System.out.println("closeing word ...");
    }
}
