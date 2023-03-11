import java.math.BigInteger;
import java.util.Scanner;

public class Main2_5{
	public static void main(String[] args) {
		int i = 10,ans = 0;
		while(true)
		{
			ans+=i--;
			if(i==0)
				break;
		}
		System.out.print(ans);


	}
}
