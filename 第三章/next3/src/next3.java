import java.util.Scanner;

public class next3
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
	    int x = 0;
	    for(int i = 0; i < n ; i++) {       // �Ĥ@�h�j��t�d�L�_��(\n)
	        for(int k = (n-1); k > i; k--) {  // �ĤG�h�j��t�d�L�ť�( )
	            System.out.print(" ");
	        }
	        for(int j = 0; j <= x; j++) {     // �ĤG�h�j��t�d�L�P��(*)
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