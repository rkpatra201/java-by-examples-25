package com.example.services;

import com.example.models.Item;

import java.util.*;
import java.util.stream.Collectors;

public class ItemService {
    public Map<Integer, Item> itemMap = new HashMap<>();
    public void addItem(Item item){
        itemMap.put(item.getId(),item);
    }
    public Item getItemById(int id){
        return itemMap.get(id);
    }

    public void getItems(){
        System.out.println("All items:");
        for (Item item : itemMap.values()) {
            System.out.println(item);
        }
    }

    public Item deleteItemById(int id) {
        return itemMap.remove(id);
    }

    public List<Item> getItemsWithQuantityMoreThan10() {
        List<Item> res = new ArrayList<>();
        for (Item item : itemMap.values()) {
            if (item.getQuantity() > 10) {
                res.add(item);
            }
        }
        return res;
    }


    public Map<String, List<Item>> groupItemsByCategory() {
        Map<String, List<Item>> groupedItem = new HashMap<>();

        for (Item item : itemMap.values()) {
            String category = item.getCategory();

            if (!groupedItem.containsKey(category)) {
                groupedItem.put(category, new ArrayList<>());
            }

            groupedItem.get(category).add(item);
        }

        return groupedItem;
    }

    public List<Item> deleteItems(List<Integer> ids) {
        List<Item> deletedItems = new ArrayList<>();
        for (Integer id : ids) {
            Item removed = itemMap.remove(id);
            if (removed != null) {
                deletedItems.add(removed);
            }
        }
        return deletedItems;
    }

}
