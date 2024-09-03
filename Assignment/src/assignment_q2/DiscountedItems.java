package assignment_q2;

public class DiscountedItems extends Items {
    private double discountPercentage;

    public DiscountedItems(String name, int quantity, double price, double discountPercentage) {
        super(name, quantity, price);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public float getTotalPrice() {
        return (float) (super.getTotalPrice() * (1 - discountPercentage / 100));
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
