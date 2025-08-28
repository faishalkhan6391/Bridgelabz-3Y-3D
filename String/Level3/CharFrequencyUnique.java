package Level3;
import java.util.Scanner;

public class CharFrequencyUnique {

    // Method to find unique characters in a string using nested loops
    public static char[] uniqueCharacters(String text) {
        int n = text.length();
        char[] unique = new char[n]; // store possible unique chars
        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;

            // Check if already stored in unique[]
            for (int j = 0; j < count; j++) {
                if (unique[j] == ch) {
                    isUnique = false;
                    break;
                }
            }

            // If unique, add to result
            if (isUnique) {
                unique[count] = ch;
                count++;
            }
        }

        // Create new array of exact size
        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = unique[i];
        }

        return result;
    }

    // Method to find frequency of characters using unique characters
    public static String[][] charFrequency(String text) {
        int[] freq = new int[256]; // ASCII table frequencies

        // Step 1: Count frequency
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Step 2: Get unique characters
        char[] uniqueChars = uniqueCharacters(text);

        // Step 3: Store char and frequency in 2D String array
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]); // character
            result[i][1] = String.valueOf(freq[uniqueChars[i]]); // frequency
        }

        return result;
    }

    // Method to display result
    public static void display(String[][] arr) {
        System.out.println("Character | Frequency");
        System.out.println("----------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("    " + arr[i][0] + "      |    " + arr[i][1]);
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] freqArray = charFrequency(text);

        display(freqArray);
    }
}

