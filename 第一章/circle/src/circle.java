import java.util.Scanner;

public class circle 
{ 
	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
		
		int a,b,c;
		a=scan.nextInt();
		b=scan.nextInt();
		c=a*a+b*b;
		if(c<=10000)
			System.out.print("inside");
		else
			System.out.print("outside");
		
	}
}