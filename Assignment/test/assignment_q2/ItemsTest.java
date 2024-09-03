package assignment_q2;

import assignment_q2.Items;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemsTest {
    
    public ItemsTest() {
    }

   @Test
    public void testGetTotalPrice() {
        Items item = new Items("Apple iPhone", 2, 999.99);
        assertEquals(1999.98, item.getTotalPrice(), 0.01);
    }

    @Test
    public void testGetName() {
        Items item = new Items("Apple iPhone", 1, 999.99);
        assertEquals("Apple iPhone", item.getName());
    }

    @Test
    public void testGetQuantity() {
        Items item = new Items("Apple iPhone", 2, 999.99);
        assertEquals(2, item.getQuantity());
    }

    @Test
    public void testGetPrice() {
        Items item = new Items("Apple iPhone", 1, 999.99);
        assertEquals(999.99, item.getPrice(), 0.01);
    }
    
}
