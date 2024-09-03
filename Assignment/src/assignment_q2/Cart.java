package assignment_q2;

import javax.swing.JOptionPane;

public class Cart {
    public Items[] items;
    public int itemCount;
    public float total;

    public Cart() {
        items = new Items[100];
        itemCount = 0;
        total = 0;
    }

    public void addItem(Items item) {
        items[itemCount] = item;
        total += item.getTotalPrice();
        itemCount++;
    }

   public void removeItem(String itemName) {
    boolean itemFound = false;
    for (int i = 0; i < itemCount; i++) {
        if (items[i].getName().equalsIgnoreCase(itemName)) {
            total -= items[i].getTotalPrice();
            for (int j = i; j < itemCount - 1; j++) {
                items[j] = items[j + 1];
            }
            itemCount--;
            itemFound = true;
            break;
        }
    }
    if (!itemFound) {
        JOptionPane.showMessageDialog(null, "Item not found in cart.");
    }
}

   public void displayCart() {
    StringBuilder cartString = new StringBuilder("Shopping Cart:\n");
    cartString.append("--------------------\n");
    for (int i = 0; i < itemCount; i++) {
        if (items[i] instanceof DiscountedItems) {
            DiscountedItems discountedItem = (DiscountedItems) items[i];
            cartString.append(discountedItem.getName()).append(" x ").append(discountedItem.getQuantity())
                    .append(": ").append(discountedItem.getPrice()).append(" (Discounted ")
                    .append(discountedItem.getDiscountPercentage()).append("%)\n");
        } else {
            cartString.append(items[i].getName()).append(" x ").append(items[i].getQuantity())
                    .append(": $").append(items[i].getPrice()).append("\n");
        }
    }
    cartString.append("--------------------\n");
    cartString.append("Total: ").append(total);
    JOptionPane.showMessageDialog(null, cartString.toString());
}
}