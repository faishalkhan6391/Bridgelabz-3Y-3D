package SingleInheritance;



class Device {
    private String deviceName;
    private String manufacturer;

    public Device(String deviceName, String manufacturer) {
        this.deviceName = deviceName;
        this.manufacturer = manufacturer;
    }

    public void displayInfo() {
        System.out.println("Device Name: " + deviceName);
        System.out.println("Manufacturer: " + manufacturer);
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}

class SmartDevice extends Device {
    private boolean isConnected;
    private String features;

    public SmartDevice(String deviceName, String manufacturer, boolean isConnected, String features) {
        super(deviceName, manufacturer);
        this.isConnected = isConnected;
        this.features = features;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Connected to Smart Home: " + isConnected);
        System.out.println("Features: " + features);
    }

    public boolean isConnected() {
        return isConnected;
    }

    public String getFeatures() {
        return features;
    }
}

public class SmartHome {
    public static void main(String[] args) {
        SmartDevice device1 = new SmartDevice("Smart Light", "Philips", true, "Dimmable, Color Changing, Voice Control");
        device1.displayInfo();

        System.out.println();

        SmartDevice device2 = new SmartDevice("Smart Thermostat", "Nest", true, "Temperature Control, Energy Saving, Mobile App Control");
        device2.displayInfo();
    }
}

