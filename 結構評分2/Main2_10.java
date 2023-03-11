import java.util.*;

public class Main2_10
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int savings = 1000, money = 0;
		String func = sc.next();
		while(!func.equals("E"))
		{
			if(func.equals("A"))
			{
				money = sc.nextInt();
				if(money > savings)
				{
					System.out.println("error");
				}
				else
				{
					savings -= money;
				}

			}
			else if(func.equals("B"))
			{
				money = sc.nextInt();
				savings += money;
			}	
			else if(func.equals("C"))
			{
				System.out.println(savings);
			}
			func = sc.next();
		}
	}
}