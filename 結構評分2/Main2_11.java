import java.util.*;

public class Main2_11
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String date;
		int ycli = 0;
		date = sc.next();
		while(true)
		{
			int month = (date.charAt(0) - '0') * 10 + date.charAt(1) - '0';
			int day = (date.charAt(2) - '0') * 10 + date.charAt(3) - '0';
			if(month <= 12 && month >= 1)
			{
				switch(month)
				{
					case 1:case 3:case 5: case 7:case 8:case 10:case 12:
						if(day <= 31 && day >= 1)
							ycli = 1;break;
					case 4:case 6:case 9:case 11:
						if(day <= 30 && day >= 1)
							ycli = 1;break;
					case 2:
						if(day <= 28 && day >= 1)
							ycli = 1;break;
				}
			}
			else ycli = 0;
			if(ycli == 1)
				{System.out.print("confirm");break;}
			else if(ycli == 0) {
				System.out.println("illegal");}


			date = sc.next();
		}
	}
}