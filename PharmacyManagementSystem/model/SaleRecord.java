package model;

import java.time.LocalDate;

public class SaleRecord {
    private LocalDate saleDate;     // Date of the sale
    private CartItem[] soldItems;   // Array of sold CartItems
    private int itemCount;          // Number of sold items
    private double totalPrice;      // Total price of this sale

    // Constructor
    public SaleRecord(LocalDate saleDate, CartItem[] soldItems, double totalPrice) {
        if (saleDate == null) {
            this.saleDate = LocalDate.now(); // default to today if null
        } else {
            this.saleDate = saleDate;
        }

        if (soldItems == null || soldItems.length == 0) {
            throw new IllegalArgumentException("Sold items cannot be empty.");
        }

        // Copy sold items to avoid external modification
        this.itemCount = soldItems.length;
        this.soldItems = new CartItem[itemCount];
        for (int i = 0; i < itemCount; i++) {
            this.soldItems[i] = soldItems[i];
        }

        this.totalPrice = totalPrice;
    }

    // ✅ Getters
    public LocalDate getSaleDate() {
        return saleDate;
    }

    public CartItem[] getSoldItems() {
        // Return a copy to maintain encapsulation
        CartItem[] itemsCopy = new CartItem[itemCount];
        for (int i = 0; i < itemCount; i++) {
            itemsCopy[i] = soldItems[i];
        }
        return itemsCopy;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // ✅ Display sale details (for reports or console)
    @Override
    public String toString() {
        String data = "===== Sale Record =====\n";
        data += "Sale Date: " + saleDate + "\n";
        data += "Number of Items Sold: " + itemCount + "\n";
        data += "Items Sold:\n";

        for (int i = 0; i < itemCount; i++) {
            data += soldItems[i].toString() + "\n"; // Uses CartItem.toString()
        }

        data += "Total Sale Amount: $" + totalPrice + "\n";
        data += "=======================";
        return data;
    }
}
