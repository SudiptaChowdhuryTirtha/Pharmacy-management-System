package model;
// import model.Medicine;

// Tablet is a subclass of Medicine
public class Liquid extends Medicine {
    private double volume; // Valume of Syrup in ml

    // Constructor
    public Liquid(String name, String genericName, String batchID, double price, int stock, String expiryDate, double volume) {
        super(name, genericName, batchID, price,stock, expiryDate); // Call parent constructor
        this.volume = volume;
    }

    // Getter
    public double getVolume() {
        return volume;
    }

    // Setter
    public void setVolume(double volume) {
        this.volume = volume;
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
        data += "Medicine Type: Syrup/Liquid\n";
        data += "Name: " + super.getName() + "\n";
        data += "Generic Name: " + super.getGenericName() + "\n";
        data += "Batch ID: " + super.getBatchID() + "\n";
        data += "Volume: " + volume + " ml\n";
        data += "Price: " + super.getPrice() + "\n";
        data += "Stock: " + super.getStock() + "\n";
        data += "Expiry Date: " + super.getExpiryDate() + "\n";
        data += "----------------------------------\n";
        return data;
    }
}
