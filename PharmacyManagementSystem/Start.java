

import model.*;
import service.*;

import java.time.LocalDate;

import exception.*;

public class Start {
    public static void main(String[] args) {

        // 1️⃣ Create Inventory (size 10)
        Inventory inventory = new Inventory(10);
        PharmacyManager manager = new PharmacyManager(100,20);

        // 2️⃣ Create some medicines
        Tablet t1 = new Tablet("Paracetamol", "Acetaminophen", "B123", 5.5, 100, "2025-12-31", 500);
        Liquid l1 = new Liquid("Cough Syrup", "Dextromethorphan", "B456", 12.75, 50, "2026-06-30", 100.0);
        Injection i1 = new Injection("Insulin", "Human Insulin", "B789", 25.0, 20, "2024-03-15", 5.0);

        // 3️⃣ Add medicines to inventory
        inventory.addMedicine(t1);
        inventory.addMedicine(l1);
        inventory.addMedicine(i1);

        // 4️⃣ Show inventory
        inventory.showInventory();

        // 5️⃣ Search by Name
        System.out.println("\n🔍 Search by Name: 'Paracetamol'");
        Medicine found = inventory.searchByName("Paracetamol");
        if (found != null) System.out.println(found);

        // 6️⃣ Search by Generic Name
        System.out.println("\n🔍 Search by Generic Name: 'Dextromethorphan'");
        found = inventory.searchByGenericName("Dextromethorphan");
        if (found != null) System.out.println(found);

        // 7️⃣ Update stock (reduce stock)
        System.out.println("\n🔄 Updating stock for B123 (-20)");
        try {
            inventory.updateStock("B123", -20);
            System.out.println("✅ Updated successfully!");
        } catch (InsufficientStockException e) {
            System.out.println(e.getMessage());
        }

        // 8️⃣ Show inventory after stock update
        inventory.showInventory();

        // 9️⃣ Remove a medicine
        System.out.println("\n❌ Removing medicine B456");
        inventory.removeMedicine("B456");

        // 10️⃣ Show final inventory
        inventory.showInventory();



        // 5️⃣ Create Cart
        Cart cart = new Cart(10);

        try {
            // 6️⃣ Add items to Cart
            cart.addItem(t1, 5);   // 5 Paracetamol
            cart.addItem(l1, 2);   // 2 Cough Syrup
            cart.addItem(i1, 1);   // 1 Insulin

            // 7️⃣ Generate Bill
            System.out.println("\n=== Cart Bill Before Sale ===");
            manager.generateBill(cart);

            // 8️⃣ Process Sale
            manager.processSale(cart, "Cash");

        } catch (InsufficientStockException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 9️⃣ View Inventory After Sale
        System.out.println("\n=== Inventory After Sale ===");
        manager.getInventory().viewAllMedicines();

        // 10️⃣ View Full Sales History
        System.out.println("\n=== Full Sales History ===");
        manager.getSalesHistory();

        // 11️⃣ View Monthly Sales (current month)
        LocalDate now = LocalDate.now();
        System.out.println("\n=== Monthly Sales ===");
        manager.getMonthlySalesHistory(now.getYear(), now.getMonthValue());

        // 12️⃣ View Yearly Sales (current year)
        System.out.println("\n=== Yearly Sales ===");
        manager.getYearlySalesHistory(now.getYear());
    }
}
