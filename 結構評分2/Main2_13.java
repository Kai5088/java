import java.util.*;

public class Main2_13
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int lucky = sc.nextInt();
		int guess = 0;
		guess = sc.nextInt();

		while(true)
		{
			if(guess > lucky)
			{
				System.out.println("smaller");
			}
			else if(guess < lucky)
			{
				System.out.println("bigger");
			}
			else
			{
				System.out.print("bingo");
				break;
			}
			guess = sc.nextInt();
		}

	}
}