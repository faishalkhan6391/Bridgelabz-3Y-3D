package Level1;

import java.util.Scanner;

public class NumFormatDemo {

    public static void gen(String text) {
        int number = Integer.parseInt(text); 
        System.out.println("Converted Number: " + number);
    }

    public static void handle(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Converted Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        // gen(input);   // Will throw NumberFormatException if input is not a number
        handle(input);   // Will catch and handle the exception
    }
}

