
import java.math.BigInteger;
import java.util.Scanner;

public class Main2_6{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		while(true)
		{
			int in = sc.nextInt();
			if(in>max)
				max = in;
			if(in!=0)
				System.out.println(max);
			else if(in==0) {
				System.out.print(max);
				break;
				}
		}
	}
}