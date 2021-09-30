package com.techelevator.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineItem {
    private Integer itemType;
    private double price;
    Map<String, Double> items = new HashMap<>();

    public List<String> itemTypes = new ArrayList<>(); {
        itemTypes.add("beverages");
        itemTypes.add("candy");
        itemTypes.add("chips");
        itemTypes.add("gum");
    }
    public VendingMachineItem(int type, double price) {
            items.put(itemTypes.get(type), price);
    }

}

