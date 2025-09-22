package SingleInheritance;


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        displayInfo();
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }

    public String getSubject() {
        return subject;
    }
}

class Student extends Person {
    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        displayInfo();
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }

    public String getGrade() {
        return grade;
    }
}

class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        displayInfo();
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }

    public String getDepartment() {
        return department;
    }
}

public class School {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Alice", 35, "Mathematics");
        Student student1 = new Student("Bob", 15, "10th Grade");
        Staff staff1 = new Staff("Charlie", 40, "Administration");

        teacher1.displayRole();
        System.out.println();
        student1.displayRole();
        System.out.println();
        staff1.displayRole();
    }
}
