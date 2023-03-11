
import java.util.Scanner;

public class next14 
{ 
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		
		
		long a,b,c,d,e;
		a=sc.nextLong(); 
		a=a/1000; 
		
		if(a>=86400) {
		b=a/86400; c=(a-b*86400)/3600; d=(a-b*86400-c*3600)/60; e= a-b*86400-c*3600-d*60;
		System.out.print(b+" "+c+" "+d+" "+e); 
		}
		else if(a>=3600)
		{
			b=a/3600; c=(a-b*3600)/60; d=a-b*3600-c*60;
			System.out.print("0 "+b+" "+c+" "+d);
		}
		else if(a>=60)
		{
			b=a/60; c=a-b*60;
			System.out.print("0 "+"0 "+b+" "+c);
		}
		else
		{
			System.out.print("0 "+"0 "+"0 "+a);
		}	
	}
}