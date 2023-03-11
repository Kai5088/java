import java.util.*;

public class Main2_14
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String number;
		int times = 0;
		do
		{
			number = sc.next();
			if(number.length() == 6 && number.substring(0,3).equals("107"))
				times++;
			else System.out.println("N");
		}while(times < 3);
	}
}