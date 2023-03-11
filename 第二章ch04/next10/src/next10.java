import java.text.DecimalFormat;
import java.util.Scanner;

public class next10
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
 
 double a=sc.nextDouble();
 
DecimalFormat b=new DecimalFormat("0.0##");
 System.out.print(b.format(a));

 
    }
}