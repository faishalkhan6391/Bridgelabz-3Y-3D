package MixConceptoops;


import java.util.ArrayList;
import java.util.List;

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private final String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Patient ID: " + patientId);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Total Bill: $" + calculateBill());
        } else {
            System.out.println("Invalid patient instance.");
        }
    }
}

class InPatient extends Patient implements MedicalRecord {
    private double roomChargePerDay;
    private int daysStayed;
    private List<String> medicalHistory;

    public InPatient(String patientId, String name, int age, double roomChargePerDay, int daysStayed) {
        super(patientId, name, age);
        this.roomChargePerDay = roomChargePerDay;
        this.daysStayed = daysStayed;
        this.medicalHistory = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return roomChargePerDay * daysStayed + 200; // 200 for basic treatment charges
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for " + getName() + ":");
        for (String rec : medicalHistory) {
            System.out.println("- " + rec);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalHistory;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee + 50; // 50 for basic tests
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for " + getName() + ":");
        for (String rec : medicalHistory) {
            System.out.println("- " + rec);
        }
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient p1 = new InPatient("IP101", "John Doe", 45, 150, 3);
        Patient p2 = new OutPatient("OP201", "Jane Smith", 30, 80);

        MedicalRecord mr1 = (MedicalRecord) p1;
        MedicalRecord mr2 = (MedicalRecord) p2;

        mr1.addRecord("Appendectomy");
        mr1.addRecord("Blood Test");
        mr2.addRecord("General Consultation");
        mr2.addRecord("X-Ray");

        Patient[] patients = {p1, p2};

        for (Patient p : patients) {
            p.getPatientDetails();
            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();
            }
            System.out.println();
        }
    }
}

