package fruitshop;

import java.util.ArrayList;
import java.util.List;

public class FruitShop {

    private List<Fruits.Fruit>  items = new ArrayList<>();

    public void addToCart(Fruits.Fruit fruit) {
        items.add(fruit);
    }

    public void addToCart(Fruits.Fruit fruit, int quantity) {
        for(int i = 0; i < quantity; i++) {
            items.add(fruit);
        }
    }

    public void clearCart() {
        items.clear();
    }

    public double getTotal() {
        double total = 0.0;
       for(Fruits.Fruit fruit : items) {
           total += Fruits.getPrice(fruit);
       }
       return total;
    }

    // 2 for 1 on apples and a 3 for 2 on oranges
    public double getOffersTotal() {
        int oranges = getItems(Fruits.Fruit.ORANGE);
        int apples = getItems(Fruits.Fruit.APPLE);
        return getTotal() - (oranges / 3) * Fruits.getPrice(Fruits.Fruit.ORANGE) - (apples / 2) * Fruits.getPrice(Fruits.Fruit.APPLE);
    }

    protected int getItems(Fruits.Fruit fruit) {
        int count = 0;
        for(Fruits.Fruit item : items) {
            if(item == fruit) {
                count++;
            }
        }
        return count;
    }
}
