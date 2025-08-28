package Level3;

import java.util.Scanner;

public class BMICalculator {

    // a. Take user input for weight & height, store in 2D array
    public static double[][] takeInput(int n) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[n][2]; // col0 = weight (kg), col1 = height (cm)
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }
        return data;
    }

    // b. Method to calculate BMI and status for one person
    public static String[] getBMIStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0; // convert cm to meter
        double bmi = weight / (heightM * heightM);
        bmi = Math.round(bmi * 100.0) / 100.0; // round to 2 decimals

        String status;
        if (bmi <= 18.4) status = "Underweight";
        else if (bmi <= 24.9) status = "Normal";
        else if (bmi <= 39.9) status = "Overweight";
        else status = "Obese";

        return new String[]{String.valueOf(bmi), status};
    }

    // c. Method that returns 2D String array of Height, Weight, BMI, Status
    public static String[][] calculateBMIArray(double[][] data) {
        int n = data.length;
        String[][] result = new String[n][4]; // Weight, Height, BMI, Status
        for (int i = 0; i < n; i++) {
            result[i][0] = data[i][0] + " kg"; // weight
            result[i][1] = data[i][1] + " cm"; // height
            String[] bmiStatus = getBMIStatus(data[i][0], data[i][1]);
            result[i][2] = bmiStatus[0]; // BMI
            result[i][3] = bmiStatus[1]; // Status
        }
        return result;
    }

    // d. Display 2D array in tabular format
    public static void displayTable(String[][] result) {
        System.out.println("------------------------------------------------------------");
        System.out.println("Person\tWeight\t\tHeight\t\tBMI\t\tStatus");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < result.length; i++) {
            System.out.println((i + 1) + "\t" + result[i][0] + "\t" +
                    result[i][1] + "\t" + result[i][2] + "\t\t" + result[i][3]);
        }
        System.out.println("------------------------------------------------------------");
    }

    // e. Main method
    public static void main(String[] args) {
        int n = 10; // fixed 10 persons
        double[][] data = takeInput(n);
        String[][] result = calculateBMIArray(data);
        displayTable(result);
    }
}
