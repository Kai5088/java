import java.math.BigInteger;
import java.util.Scanner;

public class Main2_2{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch(n/10)
		{
			case 10:
			case 9:
			case 8:
			case 7:
			case 6:
				System.out.print("Pass");
				break;
			default:
				System.out.print("Fail");
				break;
			
		}

	}
}