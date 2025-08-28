package Level1;


import java.util.Scanner;

public class ArrayIndexDemo {

    public static void gen(String[] arr) {
        // Accessing invalid index -> Exception
        System.out.println(arr[arr.length]); 
    }

    public static void handle(String[] arr) {
        try {
            System.out.println(arr[arr.length]); 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        // gen(names);   // Will throw exception
        handle(names);   // Will handle exception safely
    }
}

