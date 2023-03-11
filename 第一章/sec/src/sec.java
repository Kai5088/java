import java.util.Scanner;

public class sec 
{ 
	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
		
		
		int a,b,c,d;
		a=scan.nextInt();
		
		if(a>=86400) {
		b=a/86400; c=(a-b*86400)/3600; d=(a-b*86400-c*3600)/60; 
		System.out.print(d); 
		}
		else if(a>=3600)
		{
			b=a/3600; c=(a-b*3600)/60;
			System.out.print(c);
		}
		else
		{
			b=a/60;
			System.out.print(b);
		}
	}
}