package model;

import exception.InsufficientStockException;

public class Cart {
    private CartItem[] cartItems;   // Array to hold items in the cart
    private int size;               // Number of items currently in the cart
    private int capacity;           // Maximum capacity of the cart

    // Constructor
    public Cart(int capacity) {
        if (capacity <= 0) {
            capacity = 10; // default capacity
        }
        this.capacity = capacity;
        this.cartItems = new CartItem[capacity];
        this.size = 0;
    }

    // ✅ Add item to cart
    public void addItem(Medicine medicine, int quantity) throws InsufficientStockException {
        if (size >= capacity) {
            System.out.println("Cart is full! Cannot add more items.");
            return;
        }
        // Check if medicine is already in cart
        for (int i = 0; i < size; i++) {
            if (cartItems[i].getMedicine().getBatchID().equals(medicine.getBatchID())) {
                int newQuantity = cartItems[i].getQuantity() + quantity;
                if (newQuantity > medicine.getStock()) {
                    throw new InsufficientStockException("Not enough stock for " + medicine.getName());
                }
                cartItems[i].setQuantity(newQuantity);
                return;
            }
        }
        // Add new CartItem
        cartItems[size] = new CartItem(medicine, quantity);
        size++;
    }

    // ✅ Remove item from cart by batchID
    public void removeItem(String batchID) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (cartItems[i].getMedicine().getBatchID().equals(batchID)) {
                // Shift remaining items left
                for (int j = i; j < size - 1; j++) {
                    cartItems[j] = cartItems[j + 1];
                }
                cartItems[size - 1] = null;
                size--;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found in cart: " + batchID);
        }
    }

    // ✅ Get total price of all items in cart
    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += cartItems[i].getTotalPrice();
        }
        return total;
    }

    // ✅ Get all CartItems
    public CartItem[] getCartItems() {
        // Return a copy of the array up to current size
        CartItem[] items = new CartItem[size];
        for (int i = 0; i < size; i++) {
            items[i] = cartItems[i];
        }
        return items;
    }

    // ✅ Get size
    public int getSize() {
        return size;
    }

    // ✅ Display cart details
    public void showCart() {
        if (size == 0) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("-------- Cart Details --------");
        for (int i = 0; i < size; i++) {
            System.out.println(cartItems[i]);
        }
        System.out.println("Total Amount: $" + calculateTotal());
        System.out.println("------------------------------");
    }

    // ✅ Clear cart (after sale)
    public void clearCart() {
        for (int i = 0; i < size; i++) {
            cartItems[i] = null;
        }
        size = 0;
    }
}
