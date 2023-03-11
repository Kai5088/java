import java.text.DecimalFormat;
import java.util.Scanner;

public class next7
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
 
 double a=sc.nextDouble();
 DecimalFormat b=new DecimalFormat("#,##0.00");
 DecimalFormat c=new DecimalFormat("#,##0.000");
 System.out.println(b.format(a));
 System.out.print(c.format(a));
 
 
    }
}