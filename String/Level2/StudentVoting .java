package Level2;
import java.util.Random;
import java.util.Scanner;

public class StudentVoting {

    // Method to generate random 2-digit ages for n students
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 10; // generates 10–99
        }
        return ages;
    }

    // Method to check if student can vote
    public static String[][] checkVoting(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]); // store age as String
            if (ages[i] < 0) {
                result[i][1] = "false"; // invalid age
            } else if (ages[i] >= 18) {
                result[i][1] = "true"; // can vote
            } else {
                result[i][1] = "false"; // cannot vote
            }
        }
        return result;
    }

    // Method to display result in tabular format
    public static void display(String[][] data) {
        System.out.println("Age\tCan Vote?");
        System.out.println("----------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input for number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Generate random ages
        int[] ages = generateAges(n);

        // Check voting eligibility
        String[][] votingResult = checkVoting(ages);

        // Display
        display(votingResult);
    }
}

