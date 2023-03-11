import java.util.Scanner;

public class next3
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
	    int x = 0;
	    for(int i = 0; i < n ; i++) {       // 第一層迴圈負責印斷行(\n)
	        for(int k = (n-1); k > i; k--) {  // 第二層迴圈負責印空白( )
	            System.out.print(" ");
	        }
	        for(int j = 0; j <= x; j++) {     // 第二層迴圈負責印星號(*)
	            System.out.print("*");
	        }
	        if(i<(n-1))
	        {	
	        System.out.println("");
	        }
	        x+=2;
	    }

	}
}