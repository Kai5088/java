import java.util.*;

public class MyMain9
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		for (int i = 9;i >= 1 ;--i) {
			for (int j = 9;j > 9-i;--j ) 
				System.out.print(j);
			System.out.println();
		}
	}
}