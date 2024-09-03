
package assignment_q2;

// Base class for items
public class Items {
    protected String name;
    protected int quantity;
    protected double price;

    public Items(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public float getTotalPrice() {
        return (float) (quantity * price); //total price is showing more than 2 decimals with double but I'm not sure why
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}