package service;

import model.Item;
import model.VendingMachine;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VendingMachineService {
    private VendingMachine vendingMachine = new VendingMachine();
    private double itemBalance = 0;
    private double moneyBalance = 0;


    public boolean isEmpty() {
        return vendingMachine.getItemList().isEmpty();
    }

    public void addItem(Item item) {
        if (vendingMachine.getItemList().containsKey(item) &&
                vendingMachine.getItemList().get(item) > 0) {
            vendingMachine.getItemList().put(item, vendingMachine.getItemList().get(item) + 1);
        } else {
            vendingMachine.getItemList().put(item, 1);
        }
        itemBalance += item.getPrice();

    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public double getItemBalance() {
        return itemBalance;
    }

    public double getMoneyBalance() {
        return moneyBalance;
    }

    public double deposit(double i) {
        moneyBalance += i;
        return i;
    }

    public double withdraw(double i) {
        moneyBalance -= i;
        return i;
    }

    public Map<Item, Integer> getAvailableItems() {
        return vendingMachine.getItemList();
    }

//    public void getItemByCode(String code) {
//        Item item = vendingMachine.getItemList().stream().filter(item -> item.getCode().equals(code)).findFirst();
//        item.setQuantity(item.getQuantity() - 1);
//
//    }
}
