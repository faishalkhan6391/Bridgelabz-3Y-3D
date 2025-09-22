package MixConceptoops;



import java.util.ArrayList;
import java.util.List;

interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

abstract class Employee {
    private final int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
    }

    public abstract double calculateSalary();
}

class FullTimeEmployee extends Employee implements Department {
    private String departmentName;
    private double bonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return departmentName;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Employee Type: Full-Time");
        System.out.println("Department: " + departmentName);
        System.out.println("Salary after Bonus: $" + calculateSalary());
    }
}

class PartTimeEmployee extends Employee implements Department {
    private String departmentName;
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return departmentName;
    }

    @Override
    public void displayDetails() {
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Name: " + getName());
        System.out.println("Employee Type: Part-Time");
        System.out.println("Department: " + departmentName);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Calculated Salary: $" + calculateSalary());
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Alice", 5000, 500);
        emp1.assignDepartment("HR");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 20, 80);
        emp2.assignDepartment("Marketing");

        employees.add(emp1);
        employees.add(emp2);

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }
    }
}

