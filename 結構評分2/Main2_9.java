import java.util.*;

public class Main2_9
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int i = 0, sum = 0;

		i = sc.nextInt();
		while(i < 9999)
		{
			sum += i;
			i = sc.nextInt();
		}
		System.out.print(sum);
	}
}