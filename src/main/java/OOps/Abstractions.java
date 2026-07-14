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