package model;
import exception.InsufficientStockException;

public class CartItem {
    private Medicine medicine;  // Medicine object in cart
    private int quantity;       // Quantity of this medicine in cart

    // Constructor
    public CartItem(Medicine medicine, int quantity) throws InsufficientStockException {
        if (medicine == null) {
            throw new IllegalArgumentException("Medicine cannot be null.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (quantity > medicine.getStock()) {
            throw new InsufficientStockException("Not enough stock for " + medicine.getName());
        }

        this.medicine = medicine;
        this.quantity = quantity;
    }

    // ✅ Getters
    public Medicine getMedicine() {
        return medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    // ✅ Setters
    public void setQuantity(int quantity) throws InsufficientStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (quantity > medicine.getStock()) {
            throw new InsufficientStockException("Not enough stock for " + medicine.getName());
        }
        this.quantity = quantity;
    }

    // ✅ Calculate total price for this cart item
    public double getTotalPrice() {
        return medicine.getPrice() * quantity;
    }

    // ✅ Display cart item details for bill or console
   @Override
    public String toString() {
    String data = "";
    data += "Medicine: " + medicine.getName() + "\n";
    data += "Generic Name: " + medicine.getGenericName() + "\n";
    data += "Batch ID: " + medicine.getBatchID() + "\n";
    data += "Price per Unit: $" + medicine.getPrice() + "\n";
    data += "Quantity: " + quantity + "\n";
    data += "Total Price: $" + getTotalPrice() + "\n";
    data += "---------------------------";
    return data;
}

}
