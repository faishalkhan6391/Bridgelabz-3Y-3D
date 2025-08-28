package Level1;

import java.util.Scanner;

public class StringIndexDemo {

    public static void generateException(String text) {
        // This will generate StringIndexOutOfBoundsException
        System.out.println(text.charAt(text.length())); 
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length())); 
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        // First call (will throw exception)
        // generateException(input);

        // Second call (will handle exception)
        handleException(input);
    }
}
