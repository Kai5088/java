import java.math.BigInteger;
import java.util.Scanner;

public class Main2_4{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch(n)
		{
			case 5:
				System.out.println("*****");
			case 4:
				System.out.println("****");
			case 3:
				System.out.println("***");
			case 2:
				System.out.println("**");
			case 1:
				System.out.print("*");
				break;
			
		}

	}
}