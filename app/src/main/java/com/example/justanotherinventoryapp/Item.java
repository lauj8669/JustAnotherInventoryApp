package com.example.justanotherinventoryapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores information about each item
 */
public class Item {
    static class EachItem {
        public EachItem(String setItemName, int setItemQuantity) {
            itemName = setItemName;
            itemQuantity = setItemQuantity;
        }
        public String itemName;
        public int itemQuantity;
    }
    private static List<EachItem> listOfItems = new ArrayList<>();

    public static void addNewItem(String itemName, int itemQuantity) {
        listOfItems.add(new EachItem(itemName, itemQuantity));
    }
    //returns array of names
    public static String[] getItemNames() {
        String[] toReturn = new String[listOfItems.size()];
        for(int i = 0; i < listOfItems.size(); i++) {
            toReturn[i] = listOfItems.get(i).itemName;
        }
        return toReturn;
    }
    //returns array of integers
    public static int[] getItemQuantities() {
        int[] toReturn = new int[listOfItems.size()];
        for(int i = 0; i < listOfItems.size(); i++) {
            toReturn[i] = listOfItems.get(i).itemQuantity;
        }
        return toReturn;
    }
}
