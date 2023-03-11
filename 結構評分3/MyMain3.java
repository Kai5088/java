import java.util.*;

public class MyMain3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int sum = 0 ,up = sc.nextInt();
		for (int i = 2;i <= up ; i+=2)
			sum += i;
		System.out.print(sum);
	}
}