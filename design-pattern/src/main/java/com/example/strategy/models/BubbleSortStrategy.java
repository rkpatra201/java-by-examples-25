package com.example.strategy.models;

import com.example.strategy.contracts.SortingStrategy;

public class BubbleSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Bubble Sort");
    }
}
