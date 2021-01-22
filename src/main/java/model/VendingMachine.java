package model;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Item> itemList;


    public VendingMachine() {
        itemList = new ArrayList<>();
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
