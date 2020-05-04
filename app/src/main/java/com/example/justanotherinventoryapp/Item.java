package com.example.justanotherinventoryapp;

import android.content.SharedPreferences;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores information about each item
 */
public class Item {
    // _____________________________________instance  variables_____________________________________
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String NAME = "name";
    public static final String QUANT = "quantity";

    // inner class that holds information for each Item
    static class EachItem {
        public EachItem(String setItemName, int setItemQuantity) {
            itemName = setItemName;
            itemQuantity = setItemQuantity;
        }
        public String itemName;
        public int itemQuantity;
    }

    public static List<EachItem> listOfItems = new ArrayList<>();

    // ___________________________________________methods___________________________________________
    // adds the new Item to the list. Returns false if the item is already exists.
    public static boolean addNewItem(String itemName, int itemQuantity) {
        for (int i = 0; i < listOfItems.size(); i++) {
            if (itemName.equals(listOfItems.get(i).itemName)) {
                return false; //The item is already inside the list
            }
        }
        listOfItems.add(new EachItem(itemName, itemQuantity));
        return true;
    }

    // returns the array of names
    public static String[] getItemNames() {
        String[] toReturn = new String[listOfItems.size()];
        for(int i = 0; i < listOfItems.size(); i++) {
            toReturn[i] = listOfItems.get(i).itemName;
        }
        return toReturn;
    }

    // returns the array of integers
    public static int[] getItemQuantities() {
        int[] toReturn = new int[listOfItems.size()];
        for(int i = 0; i < listOfItems.size(); i++) {
            toReturn[i] = listOfItems.get(i).itemQuantity;
        }
        return toReturn;
    }

    // saves the inputted changed to the Item
    public static void modifyItemQuantity(String itemName, int newQuantity) {
        for(int i = 0; i < listOfItems.size(); i++) {
            if (itemName.equals(listOfItems.get(i).itemName)) {
                listOfItems.get(i).itemQuantity = newQuantity;
            }
        }
    }
}
