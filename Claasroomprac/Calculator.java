import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter  your first number");
        int a=sc.nextInt();
        System.out.print("Enter yor operator");
        char op=sc.next().charAt(0);
        System.out.print("Enterb your Second number");
        int b=sc.nextInt();
        switch(op){
            case '+':System.out.println(a+b);
            break;
            case '-':System.out.println(a-b);
            break;
            case '*':System.out.println(a*b);
            break;
            case '/':if(b!=0){
                System.out.println(a/b);
                
            }else{
                System.out.println("Divisibility Error2");
            }
            break;
            default:System.out.println("Enter valid operator");

        }
     
        


    }
    
}
