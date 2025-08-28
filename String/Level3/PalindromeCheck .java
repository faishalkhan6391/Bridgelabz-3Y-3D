package Level3;
import java.util.Scanner;

public class PalindromeCheck {

    // ------------------ Logic 1: Iterative Two-Pointer ------------------
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // ------------------ Logic 2: Recursive ------------------
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true; // base case
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false; // mismatch
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // ------------------ Logic 3: Using Character Arrays ------------------

    // Helper method: Reverse string using charAt()
    public static char[] reverseString(String text) {
        int len = text.length();
        char[] reversed = new char[len];
        for (int i = 0; i < len; i++) {
            reversed[i] = text.charAt(len - 1 - i);
        }
        return reversed;
    }

    // Check Palindrome using char arrays
    public static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    // ------------------ Display Method ------------------
    public static void displayResult(String text, boolean iterative, boolean recursive, boolean array) {
        System.out.println("\nChecking Palindrome for: \"" + text + "\"");
        System.out.println("--------------------------------------");
        System.out.println("Logic 1 (Iterative Two-Pointer): " + iterative);
        System.out.println("Logic 2 (Recursive): " + recursive);
        System.out.println("Logic 3 (Char Array Comparison): " + array);
    }

    // ------------------ Main Method ------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text to check Palindrome: ");
        String text = sc.nextLine();

        // Call all three logics
        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text, 0, text.length() - 1);
        boolean array = isPalindromeArray(text);

        // Display result
        displayResult(text, iterative, recursive, array);
    }
}
