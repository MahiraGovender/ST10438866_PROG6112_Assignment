package assignment_q2;

import assignment_q2.Cart;
import assignment_q2.Items;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartTest {
    Cart cart = new Cart();

    @Test
    public void testAddItem() {
        Items item = new Items("Apple iPhone", 1, 999.99);
        cart.addItem(item);
        assertEquals(1, cart.itemCount);
        assertEquals(999.99, cart.total, 0.01);
    }

    @Test
    public void testAddMultipleItems() {
        Items item1 = new Items("Apple iPhone", 1, 999.99);
        Items item2 = new Items("Samsung TV", 1, 1299.99);
        cart.addItem(item1);
        cart.addItem(item2);
        assertEquals(2, cart.itemCount);
        assertEquals(2299.98, cart.total, 0.01);
    }

    @Test
    public void testRemoveItem() {
        Items item = new Items("Apple iPhone", 1, 999.99);
        cart.addItem(item);
        cart.removeItem("Apple iPhone");
        assertEquals(0, cart.itemCount);
        assertEquals(0, cart.total, 0.01);
    }

    @Test
    public void testRemoveNonExistingItem() {
        cart.removeItem("NonExistingItem");
        assertEquals(0, cart.itemCount);
        assertEquals(0, cart.total, 0.01);
    }

    @Test
    public void testDisplayCart() {
        Items item = new Items("Apple iPhone", 1, 999.99);
        cart.addItem(item);
        cart.displayCart();
    }
}
