package fruitshop;

import static fruitshop.Fruits.Fruit.APPLE;
import static fruitshop.Fruits.Fruit.ORANGE;

public class Main {
    public static void main(String[] args) {
        // Open the shop !
        FruitShop shop = new FruitShop();
        // Items are enumerated so no input mistakes possible
        shop.addToCart(ORANGE);
        // Overload
        shop.addToCart(APPLE, 3);
        // Print normal price
        System.out.printf("%.2f%n",shop.getTotal());
        // Print offer price
        System.out.printf("%.2f%n",shop.getOffersTotal());
    }
}
