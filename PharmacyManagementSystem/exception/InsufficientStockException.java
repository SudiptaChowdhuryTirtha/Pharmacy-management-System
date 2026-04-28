package exception;

public class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);  // pass error message to parent Exception
    }
}
