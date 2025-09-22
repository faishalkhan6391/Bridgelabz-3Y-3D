package SingleInheritance;



interface Worker {
    void performDuties();
}

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Preparing dishes with specialty: " + specialty);
    }

    public void displayRole() {
        displayInfo();
        System.out.println("Role: Chef");
        performDuties();
    }

    public String getSpecialty() {
        return specialty;
    }
}

class Waiter extends Person implements Worker {
    private String section;

    public Waiter(String name, int id, String section) {
        super(name, id);
        this.section = section;
    }

    @Override
    public void performDuties() {
        System.out.println("Serving customers in section: " + section);
    }

    public void displayRole() {
        displayInfo();
        System.out.println("Role: Waiter");
        performDuties();
    }

    public String getSection() {
        return section;
    }
}

public class Restaurant {
    public static void main(String[] args) {
        Chef chef1 = new Chef("Gordon", 101, "Italian Cuisine");
        Waiter waiter1 = new Waiter("Emma", 201, "Main Hall");

        chef1.displayRole();
        System.out.println();
        waiter1.displayRole();
    }
}

