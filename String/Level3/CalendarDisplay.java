package Level3;

import java.util.Scanner;

public class CalendarDisplay {

    // Array of month names
    static String[] months = {
        "", "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    // Days in each month
    static int[] daysInMonth = {
        0, 31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    // Check leap year
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // Get number of days in a given month
    public static int getNumberOfDays(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month];
    }

    // Get the first day of the month using Gregorian calendar algorithm
    public static int getStartDay(int month, int year) {
        int d = 1; // first day of month
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (d + x + (31 * m0) / 12) % 7;
    }

    // Display calendar
    public static void printCalendar(int month, int year) {
        System.out.println("\n   " + months[month] + " " + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getStartDay(month, year);
        int numberOfDays = getNumberOfDays(month, year);

        // Print spaces before first day
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print days of the month
        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%4d", day);

            // Go to new line after Saturday
            if ((day + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        printCalendar(month, year);
    }
}

