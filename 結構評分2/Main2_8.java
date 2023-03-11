import java.util.*;

public class Main2_8
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int input = 0, score = 0, count = 0;
		input = sc.nextInt();
		while((score+=input) < 100)
		{
			System.out.println(score);
			count++;
			input = sc.nextInt();
		}
		System.out.print("over, " + (count+1) + " times.");
	}
}