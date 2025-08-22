import java.util.*;
public class Average {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter phy marks");
        int phy=sc.nextInt();
        System.out.println("enter chem marks");
        int chem=sc.nextInt();
        System.out.println("enter math marks");
        
        int math=sc.nextInt();
        int avg=(phy+chem+math)/3;
        System.out.println("average is : "+avg);


    }
    
}
