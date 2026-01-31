package DesignPatterns.Behavioral;

/**
 * Strategy Design Pattern
 * 
 * Purpose: Defines a family of algorithms, encapsulates each one, and makes
 * them interchangeable.
 * Strategy lets the algorithm vary independently from clients that use it.
 * 
 * Use Cases:
 * - Different payment methods
 * - Multiple sorting algorithms
 * - Various compression algorithms
 * - Different validation strategies
 * Interview Points:
 * - Promotes Open/Closed Principle
 * - Eliminates conditional statements
 * - Runtime algorithm selection
 */

// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Credit Card ending in " +
                cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using PayPal account: " + email);
    }
}

class CryptoPayment implements PaymentStrategy {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Crypto wallet: " + walletAddress);
    }
}

// Context class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

// Another example: Sorting Strategy
interface SortStrategy {
    void sort(int[] array);
}

class BubbleSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Bubble Sort");
        // Bubble sort implementation
    }
}

class QuickSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Quick Sort");
        // Quick sort implementation
    }
}

class Sorter {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] array) {
        strategy.sort(array);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        // Payment Strategy Example
        System.out.println("=== Payment Strategy ===");
        ShoppingCart cart = new ShoppingCart();

        // Pay with Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234567890123456", "123"));
        cart.checkout(100);

        // Pay with PayPal
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(200);

        // Pay with Crypto
        cart.setPaymentStrategy(new CryptoPayment("0x1234...5678"));
        cart.checkout(300);

        // Sorting Strategy Example
        System.out.println("\n=== Sorting Strategy ===");
        Sorter sorter = new Sorter();
        int[] data = { 5, 2, 8, 1, 9 };

        sorter.setStrategy(new BubbleSortStrategy());
        sorter.sort(data);

        sorter.setStrategy(new QuickSortStrategy());
        sorter.sort(data);
    }
}
