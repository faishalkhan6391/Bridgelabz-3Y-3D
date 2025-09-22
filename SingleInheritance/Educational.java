package SingleInheritance;


class Course {
    private String courseName;
    private int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }
}

class OnlineCourse extends Course {
    private String platform;
    private boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded Sessions: " + (isRecorded ? "Yes" : "No"));
    }

    public String getPlatform() {
        return platform;
    }

    public boolean isRecorded() {
        return isRecorded;
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; // in percentage

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getDiscountedFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Course Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Fee After Discount: $" + getDiscountedFee());
    }

    public double getFee() {
        return fee;
    }

    public double getDiscount() {
        return discount;
    }
}

public class Educational {
    public static void main(String[] args) {
        Course course1 = new Course("Introduction to Programming", 40);
        OnlineCourse course2 = new OnlineCourse("Java Basics", 30, "Udemy", true);
        PaidOnlineCourse course3 = new PaidOnlineCourse("Advanced Java", 50, "Coursera", false, 200, 20);

        course1.displayCourseInfo();
        System.out.println();
        course2.displayCourseInfo();
        System.out.println();
        course3.displayCourseInfo();
    }
}
