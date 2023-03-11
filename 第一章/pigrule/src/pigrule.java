import java.util.Scanner;

public class pigrule
{ 
	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
		
		
		String a=scan.next();
		String b=scan.next();
		
		String temp1=a.substring(0, 1).toLowerCase();
		String temp2=a.substring(1, 2).toUpperCase();
		String temp3=a.substring(2);
		String temp4=temp2+temp3+temp1+"ay";
		
		
		String temp5=b.substring(0, 1).toLowerCase();
		String temp6=b.substring(1, 2).toUpperCase();
		String temp7=b.substring(2);
		String temp8=temp6+temp7+temp5+"ay";
		System.out.print(temp4+" "+temp8);
		
	}
}