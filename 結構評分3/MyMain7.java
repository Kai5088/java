import java.util.*;

public class MyMain7
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int up = sc.nextInt();
		int k = sc.nextInt();
		for (int i = up;i > 0 ; i-=k) 
			sum += i;
		System.out.print(sum);
	}
}