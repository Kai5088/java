import java.text.DecimalFormat;
import java.util.Scanner;

public class next9
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
 
 double a=sc.nextDouble();
 
DecimalFormat b=new DecimalFormat("#.###");
 System.out.print(b.format(a));

 
    }
}