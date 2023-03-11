import java.util.*;

public class MyMain1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 1;i <= 100 ; ++i) 
			sum += i;
		System.out.print(sum);
	}
}