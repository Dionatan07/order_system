package entities;

public class OrderItem {

    private int quantity;
    private double price;

    private Product product;

    public OrderItem() {
    }

    public OrderItem(int quantity, double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public double subTotal() {
        return quantity * price;
    }

    public String toString() {
        return product.getName() + ", $" + String.format("%.2f", product.getPrice()) +
                " , Quantity: " + quantity + ", Subtotal: $" + String.format("%.2f", subTotal());
    }
}
