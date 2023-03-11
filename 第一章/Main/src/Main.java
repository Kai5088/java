import java.util.Scanner;

public class Main 
{ 
	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
		
		float a,b,c,d;
		a=scan.nextInt();
		b=scan.nextInt();
		c=scan.nextInt();
		
		d=(a+b)*c/2;
		
		System.out.printf("%.1f", d); 
	} 

}