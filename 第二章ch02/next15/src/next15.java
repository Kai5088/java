
import java.util.Scanner;

public class next15 
{ 
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		
		
		double a;
		a=sc.nextFloat(); 
		a=a*100;
		a=Math.round(a);
		
			System.out.print(a/10);
	}
}