import java.util.Scanner;

public class next3 
{ 
	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
		double a,b;
		double result;
		a=scan.nextFloat();
		b=scan.nextFloat();
		result=a*(b*2/9.8);
		System.out.printf("%.2f", result); 
	} 

}