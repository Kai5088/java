import java.util.*;

public class MyMain8
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		for (int i = 1;i <= 9;++i) {
			for (int j = 1;j <= 9;++j) {
				System.out.printf("%d*%d=%d", i, j, i*j);
				if(i != 9 || j != 9)
					System.out.println();
			}
		}
	}
}