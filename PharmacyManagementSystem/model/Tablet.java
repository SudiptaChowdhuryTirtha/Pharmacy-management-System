package model;
// import model.Medicine;

// Tablet is a subclass of Medicine
public class Tablet extends Medicine {
    private int strengthMg; // strength of tablet in mg

    // Constructor
    public Tablet(String name, String genericName, String batchID, double price, int stock, String expiryDate, int strengthMg) {
        super(name, genericName, batchID, price,stock, expiryDate); // Call parent constructor
        this.strengthMg = strengthMg;
    }

    // Getter
    public int getStrengthMg() {
        return strengthMg;
    }

    // Setter
    public void setStrengthMg(int strengthMg) {
        this.strengthMg = strengthMg;
    }

    // Implementation of abstract method from Medicine
        @Override
    public String getDetails() {
        return toString(); // Just call toString for details
    }

    // Nicely formatted toString like your example
    @Override
    public String toString() {
        String data = "";
        data += "Medicine Type: Tablet\n";
        data += "Name: " + super.getName() + "\n";
        data += "Generic Name: " + super.getGenericName() + "\n";
        data += "Batch ID: " + super.getBatchID() + "\n";
        data += "Strength: " + strengthMg + " mg\n";
        data += "Price: " + super.getPrice() + "\n";
        data += "Stock: " + super.getStock() + "\n";
        data += "Expiry Date: " + super.getExpiryDate() + "\n";
        data += "----------------------------------\n";
        return data;
    }
}
