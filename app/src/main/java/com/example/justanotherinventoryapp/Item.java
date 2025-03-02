package com.example.justanotherinventoryapp;

import android.content.SharedPreferences;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Stores information about each item
 */
public class Item {
    // _____________________________________instance  variables_____________________________________
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String QUANT = "quantity";

    // inner class that holds information for each Item
    static class EachItem {
        public EachItem(String setItemName, String setItemType, int setItemQuantity) {
            itemName = setItemName;
            itemType = setItemType;
            itemQuantity = setItemQuantity;
        }
        public String itemName;
        public String itemType;
        public int itemQuantity;
    }

    public static List<EachItem> listOfItems = new ArrayList<>();

    // ___________________________________________methods___________________________________________
    // adds the new Item to the list. Returns false if the item is already exists.
    public static boolean addNewItem(String itemName, String itemType, int itemQuantity) {
        for (int i = 0; i < listOfItems.size(); i++) {
            if (itemName.equals(listOfItems.get(i).itemName)) {
                return false; //The item is already inside the list
            }
        }
        listOfItems.add(new EachItem(itemName, itemType, itemQuantity));
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

    // returns the array of types
    public static String[] getItemTypes() {
        String[] toReturn = new String[listOfItems.size()];
        for(int i = 0; i < listOfItems.size(); i++) {
            toReturn[i] = listOfItems.get(i).itemType;
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
    public static void modifyItemQuantity(String itemName, String newType, int newQuantity) {
        for(int i = 0; i < listOfItems.size(); i++) {
            if (itemName.equals(listOfItems.get(i).itemName)) {
                listOfItems.get(i).itemQuantity = newQuantity;
                listOfItems.get(i).itemType = newType;
            }
        }
    }

    // sorts the list of Items alphabetically by name
    public static void sortAlphabet() {
        List<EachItem> newList = new ArrayList<>();
        String[] names = getItemNames();
        Arrays.sort(names, Collator.getInstance());
        for (int i = 0; i < listOfItems.size(); i++) {
            for (int j = 0; j < listOfItems.size(); j++) {
                if (names[i].equals(listOfItems.get(j).itemName)) {
                    newList.add(listOfItems.get(j));
                    break;
                }
            }

        }
        listOfItems = newList;
    }

    // sorts the list of Items alphabetically by type
    public static void sortType() {
        List<EachItem> newList = new ArrayList<>();
        String[] types = getItemTypes();
        Arrays.sort(types, Collator.getInstance());
        for (int i = 0; i < listOfItems.size(); i++) {
            for (int j = 0; j < listOfItems.size(); j++) {
                if (types[i].equals(listOfItems.get(j).itemType)) {
                    newList.add(listOfItems.get(j));
                    break;
                }
            }

        }
        listOfItems = newList;
    }
}
