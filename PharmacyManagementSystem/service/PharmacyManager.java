package service;

import model.*;
import exception.InsufficientStockException;
import java.time.LocalDate;

public class PharmacyManager {

    private Inventory inventory;          // Association with Inventory
    private SaleRecord[] salesRecords;    // Stores all sales
    private int salesCount;               // Number of sales recorded
    private int salesCapacity;            // Max salesRecords array size

    // Constructor
    public PharmacyManager(int inventorySize, int salesCapacity) {
        inventory = new Inventory(inventorySize);  // Initialize inventory
        this.salesCapacity = salesCapacity;
        salesRecords = new SaleRecord[salesCapacity];
        salesCount = 0;
    }

    // Getter for Inventory
    public Inventory getInventory() {
        return inventory;
    }

    // ==================== Process Sale ====================
    public void processSale(Cart cart, String paymentMethod) throws InsufficientStockException {
        if (cart.getSize() == 0) {
            System.out.println("Cart is empty. Cannot process sale.");
            return;
        }

        // 1. Check stock for each item
        for (CartItem item : cart.getCartItems()) {
            if (item.getQuantity() > item.getMedicine().getStock()) {
                throw new InsufficientStockException(
                        "Not enough stock for " + item.getMedicine().getName()
                );
            }
        }

        // 2. Reduce stock in inventory
        for (CartItem item : cart.getCartItems()) {
            Medicine med = item.getMedicine();
            med.setStock(med.getStock() - item.getQuantity());
        }

        // 3. Generate sale record
        SaleRecord sale = new SaleRecord(LocalDate.now(), cart.getCartItems(), cart.calculateTotal());

        // 4. Add to sales history
        if (salesCount < salesRecords.length) {
            salesRecords[salesCount++] = sale;
        } else {
            System.out.println("Sales history full! Cannot record more sales.");
        }

        // 5. Clear cart
        cart.clearCart();

        // 6. Simulate payment
        System.out.println("Payment done via: " + paymentMethod);
        System.out.println("Sale processed successfully!");
    }

    // ==================== Generate Bill ====================
    public void generateBill(Cart cart) {
        System.out.println("===== BILL =====");
        for (CartItem item : cart.getCartItems()) {
            System.out.println(item); // uses CartItem.toString()
        }
        System.out.println("Total Amount: $" + cart.calculateTotal());
        System.out.println("================");
    }

    // ==================== View Full Sales History ====================
    public void getSalesHistory() {
        if (salesCount == 0) {
            System.out.println("No sales recorded yet.");
            return;
        }
        System.out.println("==== Full Sales History ====");
        for (int i = 0; i < salesCount; i++) {
            System.out.println(salesRecords[i]);
        }
    }

    // ==================== View Monthly Sales ====================
    public void getMonthlySalesHistory(int year, int month) {
        double total = 0;
        boolean found = false;
        System.out.println("==== Sales for " + month + "/" + year + " ====");
        for (int i = 0; i < salesCount; i++) {
            SaleRecord sale = salesRecords[i];
            LocalDate date = sale.getSaleDate();
            if (date.getYear() == year && date.getMonthValue() == month) {
                System.out.println(sale);
                total += sale.getTotalPrice();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No sales found for this month.");
        } else {
            System.out.println("Total Sales Amount: $" + total);
        }
    }

    // ==================== View Yearly Sales ====================
    public void getYearlySalesHistory(int year) {
        double total = 0;
        boolean found = false;
        System.out.println("==== Sales for Year " + year + " ====");
        for (int i = 0; i < salesCount; i++) {
            SaleRecord sale = salesRecords[i];
            if (sale.getSaleDate().getYear() == year) {
                System.out.println(sale);
                total += sale.getTotalPrice();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No sales found for this year.");
        } else {
            System.out.println("Total Sales Amount: $" + total);
        }
    }
}
