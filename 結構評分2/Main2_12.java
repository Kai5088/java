import java.util.*;

public class Main2_12
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		int times = 0;
		while(true)
		{
			if(number.length() == 6 && number.substring(0,3).equals("107"))
			{
				times++;
			}
			else
			{
				System.out.println("N");
			}
			if(times >= 3)break;
			number = sc.next();
		}
	}
}