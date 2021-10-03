package com.techelevator.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineItem {
    private Double price;
    private String name;
    private String slotLocation;
    private int itemStock;


    public VendingMachineItem(String slotLocation, String name, Double price, int itemStock) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.itemStock = itemStock;
    }

    public void depleteStock() {
        itemStock -= 1;
    }

    public int getItemStock() {
        return itemStock;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    @Override
    public String toString() {
        return  slotLocation + " | " +
                name + " | " +
                "price: " + price + " | " +
                "itemStock: " + itemStock +
                "\n";
    }
}

