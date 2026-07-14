package OOps.LowLevelDesign;

import java.util.ArrayList;
import java.util.List;

/**
 * Low Level Design (LLD) for a Parking Lot.
 * 
 * Key Object-Oriented Principles Demonstrated:
 * 1. Encapsulation: Hiding internal state of ParkingSpot and Level.
 * 2. Enums: Using enums for VehicleSize to ensure type safety.
 * 3. Inheritance / Polymorphism: Abstract Vehicle class extended by Car, Motorcycle, Bus.
 */

// 1. Enums
enum VehicleSize { MOTORCYCLE, COMPACT, LARGE }

// 2. Abstract Base Class
abstract class Vehicle {
    protected int spotsNeeded;
    protected VehicleSize size;
    protected String licensePlate;

    public VehicleSize getSize() { return size; }
    public int getSpotsNeeded() { return spotsNeeded; }
}

// 3. Concrete Classes
class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        this.spotsNeeded = 1;
        this.size = VehicleSize.MOTORCYCLE;
        this.licensePlate = licensePlate;
    }
}

class Car extends Vehicle {
    public Car(String licensePlate) {
        this.spotsNeeded = 1;
        this.size = VehicleSize.COMPACT;
        this.licensePlate = licensePlate;
    }
}

class Bus extends Vehicle {
    public Bus(String licensePlate) {
        this.spotsNeeded = 5; // A bus needs 5 large spots
        this.size = VehicleSize.LARGE;
        this.licensePlate = licensePlate;
    }
}

// 4. Parking Spot
class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int spotNumber;

    public ParkingSpot(int spotNumber, VehicleSize spotSize) {
        this.spotNumber = spotNumber;
        this.spotSize = spotSize;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle v) {
        // Motorcycle can fit in any spot, Car can fit in Compact or Large, Bus only in Large
        return isAvailable() && v.getSize().ordinal() <= spotSize.ordinal();
    }

    public boolean park(Vehicle v) {
        if (!canFitVehicle(v)) return false;
        vehicle = v;
        return true;
    }

    public void removeVehicle() {
        vehicle = null;
    }
}

// 5. Level
class Level {
    private int floor;
    private List<ParkingSpot> spots;
    private int availableSpots;

    public Level(int floor, int numberSpots) {
        this.floor = floor;
        spots = new ArrayList<>();
        availableSpots = numberSpots;

        // Initialize spots (e.g., 20% Motorcycle, 60% Compact, 20% Large)
        for (int i = 0; i < numberSpots; i++) {
            VehicleSize size = VehicleSize.COMPACT;
            if (i < numberSpots / 5) size = VehicleSize.MOTORCYCLE;
            else if (i >= numberSpots * 4 / 5) size = VehicleSize.LARGE;
            spots.add(new ParkingSpot(i, size));
        }
    }

    public boolean parkVehicle(Vehicle v) {
        if (availableSpots < v.getSpotsNeeded()) return false;
        // In a real system, you would find contiguous spots for a Bus here.
        for (ParkingSpot spot : spots) {
            if (spot.park(v)) {
                availableSpots--;
                return true;
            }
        }
        return false;
    }
}

// 6. Main Parking Lot System
public class ParkingLot {
    private List<Level> levels;

    public ParkingLot(int numOfLevels, int spotsPerLevel) {
        levels = new ArrayList<>();
        for (int i = 0; i < numOfLevels; i++) {
            levels.add(new Level(i, spotsPerLevel));
        }
    }

    public boolean parkVehicle(Vehicle v) {
        for (Level level : levels) {
            if (level.parkVehicle(v)) {
                System.out.println(v.getClass().getSimpleName() + " parked successfully.");
                return true;
            }
        }
        System.out.println(v.getClass().getSimpleName() + " could not be parked. Lot is full.");
        return false;
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(3, 10);
        Vehicle car = new Car("ABC-123");
        Vehicle moto = new Motorcycle("MOTO-999");
        Vehicle bus = new Bus("BUS-001");

        lot.parkVehicle(car);
        lot.parkVehicle(moto);
        lot.parkVehicle(bus);
    }
}
