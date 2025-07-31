package com.example.strategy.app;


import com.example.strategy.models.BubbleSortStrategy;
import com.example.strategy.models.MergeSortStrategy;
import com.example.strategy.models.SortingContext;

public class App {
    public static void main(String[] args) {
        SortingContext sortingContext = new SortingContext(new BubbleSortStrategy());
        int[] array1 = {5, 2, 9, 1, 5};
        sortingContext.performSort(array1);

        sortingContext.setSortingStrategy(new MergeSortStrategy());
        int[] array2 = {8, 3, 7, 4, 2};
        sortingContext.performSort(array2);


    }
}
