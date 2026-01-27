package DesignPatterns.Creational;

/**
 * Builder Design Pattern
 * 
 * Purpose: Constructs complex objects step by step.
 * Separates construction from representation.
 * 
 * Use Cases:
 * - Objects with many optional parameters
 * - Immutable objects
 * - Complex object creation
 * 
 * Interview Points:
 * - Avoids telescoping constructors
 * - More readable than constructors with many parameters
 * - Can enforce invariants
 */

// Product class
class Computer {
    // Required parameters
    private final String CPU;
    private final String RAM;

    // Optional parameters
    private final String storage;
    private final String GPU;
    private final boolean isWiFiEnabled;
    private final boolean isBluetoothEnabled;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.isWiFiEnabled = builder.isWiFiEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", GPU='" + GPU + '\'' +
                ", WiFi=" + isWiFiEnabled +
                ", Bluetooth=" + isBluetoothEnabled +
                '}';
    }

    // Builder class
    public static class Builder {
        // Required parameters
        private final String CPU;
        private final String RAM;

        // Optional parameters - initialized to default values
        private String storage = "256GB SSD";
        private String GPU = "Integrated";
        private boolean isWiFiEnabled = false;
        private boolean isBluetoothEnabled = false;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setWiFi(boolean enabled) {
            this.isWiFiEnabled = enabled;
            return this;
        }

        public Builder setBluetooth(boolean enabled) {
            this.isBluetoothEnabled = enabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

// Real-world example: HTTP Request Builder
class HttpRequest {
    private final String url;
    private final String method;
    private final String body;
    private final String contentType;
    private final int timeout;

    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.contentType = builder.contentType;
        this.timeout = builder.timeout;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", body='" + body + '\'' +
                ", contentType='" + contentType + '\'' +
                ", timeout=" + timeout +
                '}';
    }

    public static class Builder {
        private final String url;
        private String method = "GET";
        private String body = "";
        private String contentType = "application/json";
        private int timeout = 30000;

        public Builder(String url) {
            this.url = url;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder contentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        // Computer Builder Example
        System.out.println("=== Computer Builder ===");

        // Basic computer
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                .build();
        System.out.println("Basic: " + basicComputer);

        // Gaming computer
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB NVMe SSD")
                .setGPU("NVIDIA RTX 4090")
                .setWiFi(true)
                .setBluetooth(true)
                .build();
        System.out.println("Gaming: " + gamingComputer);

        // HTTP Request Builder Example
        System.out.println("\n=== HTTP Request Builder ===");

        // Simple GET request
        HttpRequest getRequest = new HttpRequest.Builder("https://api.example.com/users")
                .build();
        System.out.println("GET: " + getRequest);

        // POST request with body
        HttpRequest postRequest = new HttpRequest.Builder("https://api.example.com/users")
                .method("POST")
                .body("{\"name\":\"John\",\"age\":30}")
                .contentType("application/json")
                .timeout(5000)
                .build();
        System.out.println("POST: " + postRequest);
    }
}
