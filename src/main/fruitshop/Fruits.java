package fruitshop;

import java.util.HashMap;
import java.util.Map;

public class Fruits {

    private static Map<Fruit, Double> fruits = new HashMap<>();

    // Current Prices - can be updated by calling setPrice()
    protected static double orangePrice = 0.26;
    protected static double applePrice = 0.60;

    // Set prices
    static {
        fruits.put(Fruit.ORANGE, orangePrice);
        fruits.put(Fruit.APPLE, applePrice);
    }
    protected enum Fruit {
        ORANGE,
        APPLE;
    }

    protected static void setPrice(Fruit fruit, double price) {
        // Map will not allow duplicate keys, so only price will be updated.
        fruits.put(fruit, price);
    }
    protected static double getPrice(Fruit fruit) {
        return fruits.get(fruit);
    }
}
