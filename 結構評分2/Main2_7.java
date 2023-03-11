import java.math.BigInteger;
import java.util.Scanner;

public class Main2_7{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),sum = 0;
		for(int i = 1;i<=n;i++)
		{
			sum+=i;
			System.out.print((i==n)?sum:sum +"\r\n");
		}
	}
}