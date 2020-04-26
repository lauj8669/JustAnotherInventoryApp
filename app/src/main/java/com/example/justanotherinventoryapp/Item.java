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

    public static boolean addNewItem(String itemName, int itemQuantity) {
        for (int i = 0; i < listOfItems.size(); i++) {
            if (itemName.equals(listOfItems.get(i).itemName)) {
                return false; //The item is already inside the list
            }
        }
        listOfItems.add(new EachItem(itemName, itemQuantity));
        return true;
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
