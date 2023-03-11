import java.text.DecimalFormat;
import java.util.Scanner;

public class next6
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
 
 double a=sc.nextDouble();
 DecimalFormat b=new DecimalFormat("#,##0.00");
 System.out.println("$"+b.format(a));
 System.out.print("NT$"+b.format(a));
 
 
    }
}