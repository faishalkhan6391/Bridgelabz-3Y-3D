package Level3;

import java.util.Scanner;

public class UniqueCharacters {

    // Method to find length of string without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // will throw exception when out of range
                count++;
            }
        } catch (Exception e) {
            // loop ends
        }
        return count;
    }

    // Method to find unique characters in a string
    public static char[] findUniqueCharacters(String text) {
        int len = findLength(text);
        char[] temp = new char[len]; // store unique chars temporarily
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // check if already seen
            for (int j = 0; j < uniqueCount; j++) {
                if (temp[j] == current) {
                    isUnique = false;
                    break;
                }
            }

            // if unique, add to result
            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // create final array with only unique characters
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    // Method to display characters in array
    public static void displayResult(char[] arr) {
        System.out.print("Unique characters: ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char[] uniqueChars = findUniqueCharacters(text);

        displayResult(uniqueChars);
    }
}

