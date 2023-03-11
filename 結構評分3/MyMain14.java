import java.util.*;

public class MyMain14
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int i = 0, sum = 0;
		for (; ; ) {
			i = sc.nextInt();
			if (i == 0) {
				break;
			}
			sum += i;
		}
		System.out.print(sum);
	}
}