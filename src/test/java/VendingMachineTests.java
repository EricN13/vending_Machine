import model.Item;
import org.junit.Test;
import service.VendingMachineService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class VendingMachineTests {

    VendingMachineService vendingMachineService = new VendingMachineService();

    Item item = new Item(24.24, "Coca-Cola", "23123");
    Item item1 = new Item(27.24, "Fanta",  "232132");
    Item item2 = new Item(21.24, "Ginger Ale", "534234");
    Item item3 = new Item(39.24, "Sprite", "2321553");

    @Test
    public void isEmpty() {
        assertTrue(vendingMachineService.isEmpty());
    }

    @Test
    public void addItem() {
        vendingMachineService.addItem(item);

        assertFalse(vendingMachineService.isEmpty());
        assertTrue(vendingMachineService.getVendingMachine().getItemList().containsKey(item));

    }

    @Test
    public void addMultipleItems() {
        vendingMachineService.addItem(item);
        vendingMachineService.addItem(item1);

        assertEquals(2, vendingMachineService.getVendingMachine().getItemList().size());
    }

    @Test
    public void displayCurrentBalance() {
        vendingMachineService.addItem(item);

        assertEquals(item.getPrice(), vendingMachineService.getItemBalance(), 0);

        vendingMachineService.addItem(item1);

        double sum = item.getPrice() + item1.getPrice();
        assertEquals(sum, vendingMachineService.getItemBalance(), 0);

    }

    @Test
    public void withdrawDepositMoney() {
        vendingMachineService.deposit(10);

        double result = vendingMachineService.getMoneyBalance();
        double expected = 10;

        assertEquals(expected, result, 0);

        vendingMachineService.deposit(20);

        result = vendingMachineService.getMoneyBalance();
        expected = 30;

        assertEquals(expected, result, 0);


        vendingMachineService.withdraw(10);

        result = vendingMachineService.getMoneyBalance();
        expected = 20;

        assertEquals(expected, result, 0);
    }

    @Test
    public void checkWhatIsAvailable() {
        vendingMachineService.addItem(item);
        vendingMachineService.addItem(item1);
        vendingMachineService.addItem(item2);
        vendingMachineService.addItem(item3);
        vendingMachineService.addItem(item3);
        Map<Item, Integer> listOfAvailableItems = vendingMachineService.getAvailableItems();
        Map<Item, Integer> expected = new HashMap<>();
        expected.put(item, 1);
        expected.put(item1, 1);
        expected.put(item2, 1);
        expected.put(item3, 2);

        assertEquals(expected, listOfAvailableItems);
        assertEquals(expected.get(item).toString(), listOfAvailableItems.get(item).toString());
    }

    @Test
    public void checkAmountInserted() {
        double currentBalance = vendingMachineService.getMoneyBalance();
        double expected = vendingMachineService.deposit(10);

        double result = vendingMachineService.getMoneyBalance() - currentBalance;

        assertEquals(expected, result, 0);
    }

//    @Test
//    public void checkBalanceOfTheVendingMachine() {
//        vendingMachineService.addItem(item);
//        vendingMachineService.addItem(item1);
//        vendingMachineService.addItem(item2);
//        vendingMachineService.addItem(item3);
//
//        vendingMachineService.getItemByCode(item1.getCode());
//
//
//    }
}
