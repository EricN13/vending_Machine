import model.Item;
import org.junit.Test;
import service.VendingMachineService;

import static org.junit.Assert.*;

public class VendingMachineTests {

    VendingMachineService vendingMachineService = new VendingMachineService();

    Item item = new Item(24.24f);
    Item item1 = new Item(27.24f);

    @Test
    public void isEmpty() {
        assertTrue(vendingMachineService.isEmpty());
    }

    @Test
    public void addItem() {
        vendingMachineService.addItem(item);

        assertFalse(vendingMachineService.isEmpty());
        assertEquals(vendingMachineService.getVendingMachine().getItemList().get(0), item);

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
}
