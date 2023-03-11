import java.util.Scanner;

public class MyMain 
{ 
	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
		
		int a;
		a=scan.nextInt();
		
		if(a>100)
			System.out.printf("OOR");
		else if(a>=90)
			System.out.printf("A");
		else if(a>=80)
			System.out.printf("B");
		else if(a>=70)
			System.out.printf("C");
		else if(a>=60)
			System.out.printf("D");
		else if(a>=50)
			System.out.printf("E");
		else if(a>=0)
			System.out.printf("Failed");
		else
			System.out.printf("OOR");
		
	} 

}