package Interface;
import model.*;

public interface IInventoryOperations {
    void addMedicine(Medicine m);
    void removeMedicine(String batchID);
    Medicine searchByName(String name);
    Medicine searchByGenericName(String genericName);
    Medicine searchByBatchID(String batchID);
    void showInventory();
}




