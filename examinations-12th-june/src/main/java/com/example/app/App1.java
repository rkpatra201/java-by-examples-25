package com.example.app;

import com.example.models.Item;
import com.example.services.ItemService;

import java.awt.*;
import java.util.*;
import java.util.List;

public class App1 {
    public static void main(String[] args) {
        ItemService itemService = new ItemService();
        itemService.addItem(new Item(1,"Apple",20,"Fruit"));
        itemService.addItem(new Item(2,"Orange",100,"Fruit"));
        itemService.addItem(new Item(3,"Bat",5,"Goods"));
        itemService.addItem(new Item(4,"Bed",10,"Goods"));

        System.out.println("Get Item by ID: "+ itemService.getItemById(3));

        System.out.println("Delete Item by ID: "+ itemService.deleteItemById(2));

        System.out.println("Items with quantity more than 10: ");
        for (Item item : itemService.getItemsWithQuantityMoreThan10()) {
            System.out.println(item);
        }

        System.out.println("Group items by category:");
        Map<String, List<Item>> grouped = itemService.groupItemsByCategory();
        for (String category : grouped.keySet()) {
            System.out.println(category + ":");
            for (Item item : grouped.get(category)) {
                System.out.println("  " + item);
            }
        }

        System.out.println("Delete items with IDs 1 and 4:");
        List<Item> deleted = itemService.deleteItems(Arrays.asList(1, 4));
        for (Item item : deleted) {
            System.out.println(item);
        }

        itemService.getItems();

    }
}
