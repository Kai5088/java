import java.util.Scanner;

public class BMI 
{ 
	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
		
		float a,b,c;
		b=scan.nextInt();
		a=scan.nextInt();
		b=b/100;
		b*=b;
		c=a/b*10;
		
		System.out.printf("%.1f", Math.floor(c)/10); 
	} 

}