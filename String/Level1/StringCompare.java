package Level1;

import java.util.Scanner;

public class StringCompare {
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        boolean manualCompare = compareStrings(str1, str2);
        boolean builtInCompare = str1.equals(str2);
        System.out.println("Manual Compare: " + manualCompare);
        System.out.println("Built-in Compare: " + builtInCompare);
        System.out.println("Results Match: " + (manualCompare == builtInCompare));
    }
}
