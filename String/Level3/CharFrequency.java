package Level3;
import java.util.Scanner;

public class CharFrequency {

    // Method to find frequency of characters in a string
    public static String[][] findFrequency(String text) {
        int[] freq = new int[256]; // ASCII frequency array

        // Step 1: Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Step 2: Count how many unique characters are present
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
            }
        }

        // Step 3: Create 2D array to store character and frequency
        String[][] result = new String[uniqueCount][2];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] > 0) {
                result[index][0] = String.valueOf(ch); // store character
                result[index][1] = String.valueOf(freq[ch]); // store frequency
                freq[ch] = 0; // mark as processed
                index++;
            }
        }

        return result;
    }

    // Method to display the 2D array
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

        String[][] freqArray = findFrequency(text);

        display(freqArray);
    }
}
