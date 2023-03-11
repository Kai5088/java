import java.util.Scanner;

public class time 
{ 
	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
		
		
		double a,b;
		a=scan.nextFloat();
		
		b=a*100/23.8;
		
		
		b+=0.5;
		System.out.print(Math.round(b)); 
	} 

}