package Level2;

import java.util.Scanner;

public class StringLengthDemo {

    public static int manualLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // will throw exception when index is out of range
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        int manual = manualLength(text);
        int builtIn = text.length();

        System.out.println("Manual Length: " + manual);
        System.out.println("Built-in Length: " + builtIn);
    }
}
