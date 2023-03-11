import java.util.Scanner;

public class Redeem 
{ 
	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
		
		int a,b,c,d;
		a=scan.nextInt();
		
		b=a/10;
		c=(a-b*10)/3;
		d=a-b*10-c*3;
		
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	} 

}