package MixConceptoops;



interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private final String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayVehicleDetails(int days) {
        if (this instanceof Vehicle) {
            System.out.println("Vehicle Number: " + vehicleNumber);
            System.out.println("Type: " + type);
            System.out.println("Rental Rate per day: $" + rentalRate);
            System.out.println("Rental Cost for " + days + " days: $" + calculateRentalCost(days));
            if (this instanceof Insurable) {
                System.out.println(((Insurable) this).getInsuranceDetails());
            }
            System.out.println();
        } else {
            System.out.println("Invalid vehicle instance.");
        }
    }
}

class Car extends Vehicle implements Insurable {
    private double insuranceRate; // in percentage
    private String policyNumber;

    public Car(String vehicleNumber, double rentalRate, double insuranceRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insuranceRate = insuranceRate;
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate / 100;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (" + policyNumber + "): $" + calculateInsurance();
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8; // bikes get 20% discount
    }
}

class Truck extends Vehicle implements Insurable {
    private double insuranceRate;
    private String policyNumber;

    public Truck(String vehicleNumber, double rentalRate, double insuranceRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insuranceRate = insuranceRate;
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2; // trucks have 20% extra rental rate
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate / 100;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (" + policyNumber + "): $" + calculateInsurance();
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("C101", 50, 10, "CAR-INS-001"),
            new Bike("B202", 20),
            new Truck("T303", 100, 15, "TRUCK-INS-001")
        };

        for (Vehicle v : vehicles) {
            v.displayVehicleDetails(5); // calculate rental for 5 days
        }
    }
}

