package Level2;

import java.util.Scanner;

public class StudentGrades {

    // a. Method to generate random 2-digit scores for PCM subjects
    public static int[][] generateScores(int n) {
        int[][] scores = new int[n][3]; // Physics, Chemistry, Math
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int) (Math.random() * 100); // random 0-99
            }
        }
        return scores;
    }

    // b. Method to calculate total, average, percentage
    public static double[][] calculatePercentage(int[][] scores) {
        int n = scores.length;
        double[][] result = new double[n][3]; // total, average, percentage
        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }

    // c. Method to calculate grade based on percentage
    public static String[] calculateGrade(double[][] result) {
        String[] grade = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            double percent = result[i][2];
            if (percent >= 80) grade[i] = "A";
            else if (percent >= 70) grade[i] = "B";
            else if (percent >= 60) grade[i] = "C";
            else if (percent >= 50) grade[i] = "D";
            else if (percent >= 40) grade[i] = "E";
            else grade[i] = "R";
        }
        return grade;
    }

    // d. Display results in tabular format
    public static void displayScorecard(int[][] scores, double[][] result, String[] grades) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("ID\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t\t" + scores[i][1] + "\t\t" + scores[i][2] +
                    "\t" + (int) result[i][0] + "\t" + result[i][1] + "\t" + result[i][2] + "%\t\t" + grades[i]);
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generateScores(n);
        double[][] result = calculatePercentage(scores);
        String[] grades = calculateGrade(result);

        displayScorecard(scores, result, grades);
    }
}
