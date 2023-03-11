import java.math.BigInteger;
import java.util.Scanner;

public class Main2_3{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch(n/10)
		{
			case 10:
				System.out.print("Excellent");
				break;
			case 9:
				System.out.print("Great");
				break;
			case 8:
				System.out.print("Good");
				break;
			case 7:
				System.out.print("Average");
				break;
			case 6:
				System.out.print("Poor");
				break;
			default:
				System.out.print("Failing");
				break;
			
		}

	}
}