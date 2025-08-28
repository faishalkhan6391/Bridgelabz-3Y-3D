package Level1;

import java.util.Scanner;

public class CharArrayCompare {
    public static char[] manualToCharArray(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    public static boolean compareArrays(char[] a1, char[] a2) {
        if (a1.length != a2.length) return false;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char[] manualArray = manualToCharArray(text);
        char[] builtInArray = text.toCharArray();
        boolean areEqual = compareArrays(manualArray, builtInArray);
        System.out.println("Manual Array: " + String.valueOf(manualArray));
        System.out.println("Built-in Array: " + String.valueOf(builtInArray));
        System.out.println("Are Both Equal: " + areEqual);
    }
}
