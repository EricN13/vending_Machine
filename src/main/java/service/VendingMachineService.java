package service;

import model.Item;
import model.VendingMachine;

public class VendingMachineService {
    private VendingMachine vendingMachine = new VendingMachine();
    private double itemBalance = 0;
    private double moneyBalance = 0;

    public boolean isEmpty() {
        return vendingMachine.getItemList().isEmpty();
    }

    public void addItem(Item item) {
        vendingMachine.getItemList().add(item);
        itemBalance +=item.getPrice();
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

    public void deposit(double i) {
        moneyBalance+=i;
    }

    public void withdraw(double i) {
        moneyBalance-=i;
    }
}
