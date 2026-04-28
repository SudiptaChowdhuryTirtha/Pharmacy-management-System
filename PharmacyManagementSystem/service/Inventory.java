package service;

import model.Medicine;
import Interface.IInventoryOperations;
import exception.InsufficientStockException;

public class Inventory implements IInventoryOperations {
    private Medicine[] medicines;
    private int medicineCount; // keeps track of added items

    // Constructor
    public Inventory(int size) {
        medicines = new Medicine[size];
        medicineCount = 0;
    }

    // Add medicine at next available slot
    public void addMedicine(Medicine m) {
        if (medicineCount < medicines.length) {
            medicines[medicineCount] = m;
            medicineCount++;
        } else {
            System.out.println("❌ Inventory is full!");
        }
    }

    // Search by Batch ID
    public Medicine searchByBatchID(String batchID) {
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i] != null && medicines[i].getBatchID().equals(batchID)) {
                return medicines[i];
            }
        }
        return null;
    }

    // Search by Name
    public Medicine searchByName(String name) {
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i] != null && medicines[i].getName().equalsIgnoreCase(name)) {
                return medicines[i];
            }
        }
        return null;
    }

    // Search by Generic Name
    public Medicine searchByGenericName(String genericName) {
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i] != null && medicines[i].getGenericName().equalsIgnoreCase(genericName)) {
                return medicines[i];
            }
        }
        return null;
    }

    // Update stock (can throw exception if not enough stock)
    public void updateStock(String batchID, int quantityChange) throws InsufficientStockException {
        Medicine m = searchByBatchID(batchID);
        if (m != null) {
            int newStock = m.getStock() + quantityChange;
            if (newStock < 0) {
                throw new InsufficientStockException("Not enough stock for " + m.getName());
            }
            m.setStock(newStock);
        } else {
            System.out.println("❌ Medicine not found with Batch ID: " + batchID);
        }
    }

    // Remove medicine
    public void removeMedicine(String batchID) {
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i] != null && medicines[i].getBatchID().equals(batchID)) {
                medicines[i] = null;
                System.out.println("✅ Medicine removed successfully.");
                return;
            }
        }
        System.out.println("❌ Medicine not found.");
    }

    // Show all inventory
    public void showInventory() {
        System.out.println("------------ Inventory Details --------------");
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i] != null) {
                System.out.println(medicines[i]);
            }
        }
        System.out.println("-------------------------------------------");
    }

    @Override
    public String toString() {
        String allData = "------------ Inventory Details --------------\n";
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i] != null) {
                allData += medicines[i].toString() + "\n";
            }
        }
        allData += "-------------------------------------------\n";
        return allData;
    }

    public void viewAllMedicines(){
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i] != null) {
                System.out.println(medicines[i]);
            }
        }
        System.out.println("-------------------------------------------");
    }
}
