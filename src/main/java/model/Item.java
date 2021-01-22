package model;

public class Item {
    double price;
    private String name;
    private String code;
    private boolean isAvailable;

    public Item(double price, String name, String code) {
        this.price = price;
        this.name = name;
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
