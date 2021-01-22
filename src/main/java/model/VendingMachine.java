package model;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<Item, Integer> itemList;


    public VendingMachine() {
        itemList = new HashMap<>();
    }

    public Map<Item, Integer> getItemList() {
        return itemList;
    }
}
