package SingleInheritance;



interface Refuelable {
    void refuel();
}

class Vehicle {
    private String model;
    private int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}

class ElectricVehicle extends Vehicle {
    private int batteryCapacity; // in kWh

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("Charging the electric vehicle with battery capacity: " + batteryCapacity + " kWh");
    }

    public void displayVehicle() {
        displayInfo();
        System.out.println("Type: Electric Vehicle");
        charge();
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    private int tankCapacity; // in liters

    public PetrolVehicle(String model, int maxSpeed, int tankCapacity) {
        super(model, maxSpeed);
        this.tankCapacity = tankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the petrol vehicle with tank capacity: " + tankCapacity + " liters");
    }

    public void displayVehicle() {
        displayInfo();
        System.out.println("Type: Petrol Vehicle");
        refuel();
    }

    public int getTankCapacity() {
        return tankCapacity;
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model S", 250, 100);
        PetrolVehicle pv = new PetrolVehicle("Toyota Corolla", 180, 50);

        ev.displayVehicle();
        System.out.println();
        pv.displayVehicle();
    }
}
