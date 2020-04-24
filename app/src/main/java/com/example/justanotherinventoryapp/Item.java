package com.example.justanotherinventoryapp;

/**
 * Stores information about each item
 */
public class Item {
    private String itemName;
    private int quantity;
    private String categoryName;
    public Item(String setItemName, String setCategoryName, int setQuantity) {
        itemName = setItemName;
        categoryName = setCategoryName;
        quantity = setQuantity;
    }
    public void setCategoryName(String setCategoryName) {
        categoryName = setCategoryName;
    }
    public void setQuantity(int setQuantity) {
        quantity = setQuantity;
    }
    public void changeQuantityBy (int change) {
        quantity = quantity + change;
    }
}
