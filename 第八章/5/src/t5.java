import java.util.Scanner;

public class t5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double a,b,c,l,h;
		a=sc.nextDouble();
		b=sc.nextDouble();
		l=sc.nextDouble();
		h=sc.nextDouble();
		c=sc.nextDouble();
		
		System.out.print((a*a*3.14+b*b+l*h/2)*c);
	}

}
