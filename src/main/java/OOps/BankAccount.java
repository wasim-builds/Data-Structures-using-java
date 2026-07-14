package OOps;
// encapsulation

class BankAccounte {
    private double balance;  // Private variable, can't be accessed directly
    
    public BankAccounte(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public double getBalance() {  // Public method to access balance
        return balance;
    }
}

public class BankAccount {
    public static void main(String[] args) {
        BankAccounte account = new BankAccounte(1000);
        account.deposit(500);
        System.out.println("Balance: " + account.getBalance()); // Output: Balance: 1500
    }
}

