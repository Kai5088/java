import java.util.*;

public class MyMain13
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int jump = sc.nextInt();

		for (int i = 1;i <= 100;++i) {
			if(i % jump == 0)
				continue;
			else if(i == 100)
				System.out.print(i);
			else
				System.out.println(i);
		}
	}
}