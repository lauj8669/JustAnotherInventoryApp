package com.example.justanotherinventoryapp;

/**
 * Stores information about each item
 */
public class Item {
    private String itemName;
    private int quantity;
    public Item(String setItemName, int setQuantity) {
        itemName = setItemName;
        quantity = setQuantity;
    }
    public void setQuantity(int setQuantity) {
        quantity = setQuantity;
    }
    public void changeQuantityBy (int change) {
        quantity = quantity + change;
    }
}
