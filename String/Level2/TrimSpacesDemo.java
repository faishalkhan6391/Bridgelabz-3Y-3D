package Level2;

import java.util.Scanner;

public class TrimSpacesDemo {

    public static int[] findStartEnd(String text) {
        int start = 0, end = text.length() - 1;

        // Find first non-space character
        while (start < text.length() && text.charAt(start) == ' ') {
            start++;
        }

        // Find last non-space character
        while (end >= 0 && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    public static String customSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        // Find trimming positions
        int[] positions = findStartEnd(text);

        // Handle case where string is only spaces
        String trimmedCustom = "";
        if (positions[0] <= positions[1]) {
            trimmedCustom = customSubstring(text, positions[0], positions[1]);
        }

        // Built-in trim
        String trimmedBuiltIn = text.trim();

        // Compare
        boolean isSame = compareStrings(trimmedCustom, trimmedBuiltIn);

        System.out.println("Custom Trim Result: [" + trimmedCustom + "]");
        System.out.println("Built-in Trim Result: [" + trimmedBuiltIn + "]");
        System.out.println("Are both results same? " + isSame);
    }
}
