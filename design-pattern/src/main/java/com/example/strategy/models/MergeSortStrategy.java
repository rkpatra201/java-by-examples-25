package com.example.strategy.models;

import com.example.strategy.contracts.SortingStrategy;

public class MergeSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Merge Sort");

    }
}