import java.util.*;

public class MyMain6
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int sum = 0,up = sc.nextInt();
		for (int i = up;i > 0 ; i-=2)
			sum += i;
		System.out.print(sum);
	}
}