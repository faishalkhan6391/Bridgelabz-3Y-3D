package MixConceptoops;



interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicle {
    private final String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Vehicle ID: " + vehicleId);
            System.out.println("Driver Name: " + driverName);
            System.out.println("Rate per Km: $" + ratePerKm);
        } else {
            System.out.println("Invalid vehicle instance.");
        }
    }
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9; // Bikes have 10% discount
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 1.1; // Auto charges 10% extra
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle car = new Car("C001", "Alice", 15, "Downtown");
        Vehicle bike = new Bike("B001", "Bob", 10, "Uptown");
        Vehicle auto = new Auto("A001", "Charlie", 12, "Central Park");

        Vehicle[] vehicles = {car, bike, auto};
        double distance = 10; // 10 km ride

        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
            if (v instanceof GPS) {
                System.out.println("Current Location: " + ((GPS) v).getCurrentLocation());
            }
            System.out.println("Fare for " + distance + " km: $" + v.calculateFare(distance));
            System.out.println();
        }
    }
}

