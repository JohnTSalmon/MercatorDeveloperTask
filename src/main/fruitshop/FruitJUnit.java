package fruitshop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FruitJUnit {

    FruitShop fruitShop;

    @Before
    public void setUp() {
        fruitShop = new FruitShop();
    }
    @Test
    public void testDefaults() {
        fruitShop.addToCart(Fruits.Fruit.APPLE);
        fruitShop.addToCart(Fruits.Fruit.ORANGE);
        assertTrue(fruitShop.getTotal() == Fruits.getPrice(Fruits.Fruit.APPLE) + Fruits.getPrice(Fruits.Fruit.ORANGE));
    }

    @Test
    public void testPriceChange() {
        Fruits.setPrice(Fruits.Fruit.ORANGE, 0.99);
        Fruits.setPrice(Fruits.Fruit.ORANGE, 0.75);
        fruitShop.addToCart(Fruits.Fruit.APPLE);
        fruitShop.addToCart(Fruits.Fruit.ORANGE);
        assertTrue(fruitShop.getTotal() == Fruits.getPrice(Fruits.Fruit.APPLE) + Fruits.getPrice(Fruits.Fruit.ORANGE));
    }

    @Test
    public void testClearCart() {
        fruitShop.clearCart();
        assertTrue(fruitShop.getTotal() == 0.0);
        fruitShop.clearCart();
        fruitShop.addToCart(Fruits.Fruit.APPLE);
        fruitShop.addToCart(Fruits.Fruit.ORANGE);
    }

    @Test
    public void testMultiAdd() {
        fruitShop.clearCart();
        assertTrue(fruitShop.getTotal() == 0.0);
        fruitShop.addToCart(Fruits.Fruit.APPLE, 10);
        fruitShop.addToCart(Fruits.Fruit.ORANGE, 20);
        assertTrue(fruitShop.getTotal() == Fruits.getPrice(Fruits.Fruit.APPLE) * fruitShop.getItems(Fruits.Fruit.APPLE) +
                                                    Fruits.getPrice(Fruits.Fruit.ORANGE) * fruitShop.getItems(Fruits.Fruit.ORANGE));

    }

    @Test
    public void testOffers() {
        fruitShop.clearCart();
        assertTrue(fruitShop.getTotal() == 0.0);
        fruitShop.addToCart(Fruits.Fruit.APPLE, 10);
        fruitShop.addToCart(Fruits.Fruit.ORANGE, 20);
        assertTrue(fruitShop.getOffersTotal() == fruitShop.getTotal() -
                (fruitShop.getItems(Fruits.Fruit.ORANGE) / 3) * Fruits.getPrice(Fruits.Fruit.ORANGE) -
                (fruitShop.getItems(Fruits.Fruit.APPLE) / 2) * Fruits.getPrice(Fruits.Fruit.APPLE));

    }
}
