import java.util.Scanner;

public class BasicCalculatorMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double number1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double number2 = sc.nextDouble();

        System.out.println("\nChoose Operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter choice (1-4): ");
        int choice = sc.nextInt();

        double result = 0;
        switch (choice) {
            case 1:
                result = number1 + number2;
                System.out.println("Result of Addition = " + result);
                break;
            case 2:
                result = number1 - number2;
                System.out.println("Result of Subtraction = " + result);
                break;
            case 3:
                result = number1 * number2;
                System.out.println("Result of Multiplication = " + result);
                break;
            case 4:
                if (number2 != 0) {
                    result = number1 / number2;
                    System.out.println("Result of Division = " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed!");
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
