package DesignPatterns.Creational;

/**
 * Singleton Design Pattern
 * 
 * Purpose: Ensures a class has only one instance and provides global access to
 * it.
 * 
 * Use Cases:
 * - Database connections
 * - Logger instances
 * - Configuration managers
 * - Thread pools
 * 
 * Interview Points:
 * - Thread safety
 * - Lazy vs Eager initialization
 * - Double-checked locking
 * - Serialization issues
 */

// 1. Eager Initialization (Thread-safe, created at class loading)
class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        // Private constructor prevents instantiation
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}

// 2. Lazy Initialization with Double-Checked Locking (Thread-safe, created when
// needed)
class LazyThreadSafeSingleton {
    private static volatile LazyThreadSafeSingleton instance;

    private LazyThreadSafeSingleton() {
    }

    public static LazyThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new LazyThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}

// 3. Bill Pugh Singleton (Best approach - Thread-safe, lazy, no synchronization
// overhead)
class BillPughSingleton {
    private BillPughSingleton() {
    }

    // Inner static helper class
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

// 4. Enum Singleton (Safest against reflection and serialization)
enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Enum Singleton method");
    }
}

// Real-world example: Database Connection Manager
class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private String connectionString;

    private DatabaseConnection() {
        // Simulate expensive initialization
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Database connection initialized");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("Executing query: " + query + " on " + connectionString);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        // Test Eager Singleton
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println("Eager Singleton - Same instance: " + (eager1 == eager2));

        // Test Lazy Thread-Safe Singleton
        LazyThreadSafeSingleton lazy1 = LazyThreadSafeSingleton.getInstance();
        LazyThreadSafeSingleton lazy2 = LazyThreadSafeSingleton.getInstance();
        System.out.println("Lazy Singleton - Same instance: " + (lazy1 == lazy2));

        // Test Bill Pugh Singleton
        BillPughSingleton bp1 = BillPughSingleton.getInstance();
        BillPughSingleton bp2 = BillPughSingleton.getInstance();
        System.out.println("Bill Pugh Singleton - Same instance: " + (bp1 == bp2));

        // Test Enum Singleton
        EnumSingleton.INSTANCE.doSomething();

        // Test Database Connection (Real-world example)
        System.out.println("\nDatabase Connection Example:");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println("Same database connection: " + (db1 == db2));
        db1.executeQuery("SELECT * FROM users");

        // Test thread safety
        System.out.println("\nTesting thread safety:");
        Thread t1 = new Thread(() -> {
            DatabaseConnection db = DatabaseConnection.getInstance();
            System.out.println("Thread 1: " + db);
        });

        Thread t2 = new Thread(() -> {
            DatabaseConnection db = DatabaseConnection.getInstance();
            System.out.println("Thread 2: " + db);
        });

        t1.start();
        t2.start();
    }
}
