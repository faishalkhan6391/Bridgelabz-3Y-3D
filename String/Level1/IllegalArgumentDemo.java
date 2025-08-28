package Level1;

import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateException(String text) {
        // Start index > End index → IllegalArgumentException
        System.out.println(text.substring(5, 2));
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        // This will throw an exception and stop the program
        // generateException(input);

        // This will handle the exception safely
        handleException(input);
    }
}

