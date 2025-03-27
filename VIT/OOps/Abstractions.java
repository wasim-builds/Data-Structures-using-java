package OOps;


abstract class ATM {
    abstract void withdrawMoney(double amount);
    
    public void checkBalance() {  // Concrete method
        System.out.println("Balance checked.");
    }
}

class BankATM extends ATM {
    public void withdrawMoney(double amount) {
        System.out.println("Dispensing $" + amount);
    }
}

public class Abstractions {
    public static void main(String[] args) {
        ATM atm = new BankATM();
        atm.withdrawMoney(500);  // Output: Dispensing $500
        atm.checkBalance();       // Output: Balance checked.
    }
}
// 1. Abstraction (Hiding Implementation, Showing Only Essentials)
// 🔹 Real-Life Example: ATM Machine
// When you use an ATM (Automated Teller Machine), you interact with a simple interface:

// Insert your card

// Enter PIN

// Choose an option (Withdraw, Deposit, Balance Inquiry)

// But you don’t see how the ATM connects to the bank, validates your PIN, or processes transactions.
// The complex logic inside is hidden (abstracted) from the user.