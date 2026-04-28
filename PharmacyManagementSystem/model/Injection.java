package model;
// import model.Medicine;

// Tablet is a subclass of Medicine
public class Injection extends Medicine {
    private double dosage; // Valume of Syrup in ml

    // Constructor
    public Injection(String name, String genericName, String batchID, double price, int stock, String expiryDate, double dosage) {
        super(name, genericName, batchID, price,stock, expiryDate); // Call parent constructor
        this.dosage = dosage;
    }

    // Getter
    public double getDosage() {
        return dosage;
    }

    // Setter
    public void setDosage(double dosage) {
        this.dosage = dosage;
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
        data += "Medicine Type: Injection\n";
        data += "Name: " + super.getName() + "\n";
        data += "Generic Name: " + super.getGenericName() + "\n";
        data += "Batch ID: " + super.getBatchID() + "\n";
        data += "Dosage: " + dosage + " ml per vial\n";
        data += "Price: " + super.getPrice() + "\n";
        data += "Stock: " + super.getStock() + "\n";
        data += "Expiry Date: " + super.getExpiryDate() + "\n";
        data += "----------------------------------\n";
        return data;
    }
}
