package assignment_q2;

import assignment_q2.DiscountedItems;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiscountedItemsTest {
  @Test
    public void testGetTotalPrice() {
        DiscountedItems item = new DiscountedItems("Apple iPhone", 1, 999.99, 10.0);
        assertEquals(899.99, item.getTotalPrice(), 0.01);
    }

    @Test
    public void testGetDiscountPercentage() {
        DiscountedItems item = new DiscountedItems("Apple iPhone", 1, 999.99, 10.0);
        assertEquals(10.0, item.getDiscountPercentage(), 0.01);
    }

    @Test
    public void testGetTotalPriceWithZeroDiscount() {
        DiscountedItems item = new DiscountedItems("Apple iPhone", 1, 999.99, 0.0);
        assertEquals(999.99, item.getTotalPrice(), 0.01);
    }

    @Test
    public void testGetTotalPriceWithNegativeDiscount() {
        DiscountedItems item = new DiscountedItems("Apple iPhone", 1, 999.99, -10.0);
        assertEquals(1099.99, item.getTotalPrice(), 0.01);
    }
    
}
