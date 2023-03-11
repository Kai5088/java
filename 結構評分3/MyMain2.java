import java.util.*;

public class MyMain2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int sum = 0, up = sc.nextInt();
		for (int i = 1;i <= up ; ++i)
			sum += i;
		System.out.print(sum);
	}
}