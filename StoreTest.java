import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StoreTest {
    private Store store;
    private Goods[] goodsList;

    @Before
    public void setUp() {
        store = new Store();
        goodsList = new Goods[]{
                new Goods("Bread", 1.0f),
                new Goods("Cocacola", 1.0f),
                new Goods("Beer", 1.0f),
                new Goods("Chocalate", 1.0f),
                new Goods("Pencil", 0.5f),
                new Goods("Notebook", 3.0f),
        };
    }

    @Test
    public void testAddGoods() {
        Basket basket = new Basket();

        basket.addGoods(goodsList[0]);
        assertFalse(basket.isEmpty());
        assertEquals(1, basket.getAllGoods().size());

        basket.addGoods(goodsList[1]);
        assertFalse(basket.isEmpty());
        assertEquals(2, basket.getAllGoods().size());
    }

    @Test
    public void testGetTotalPrice() {
        Basket basket = new Basket();

        basket.addGoods(goodsList[0]);
        basket.addGoods(goodsList[1]);
        basket.addGoods(goodsList[2]);

        float totalPrice = basket.getTotalPrice();
        assertEquals(3.0f, totalPrice, 0.01);
    }

    @Test
    public void testCheckOut() {
        Basket basket = new Basket();

        basket.addGoods(goodsList[0]);
        basket.addGoods(goodsList[1]);
        basket.addGoods(goodsList[2]);

        ArrayList<Goods> goodsList = basket.getAllGoods();
        assertEquals(3, goodsList.size());

        float totalPrice = basket.getTotalPrice();
        assertEquals(3.0f, totalPrice, 0.01);
    }
}
