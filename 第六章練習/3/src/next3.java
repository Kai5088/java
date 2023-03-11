import java.util.Scanner;

public class next3
{
    /**
     A demonstration to see how == and an equalArrays method are different.
    */
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        
        int a=sc.nextInt();
    	int[] c = new int[a];
        int i;
        for (i = 0; i < c.length; i++) {
        	a=sc.nextInt();
        	c[i] = a;
        }
        
        int b=sc.nextInt();
        int[] d = new int[b]; 
    
        for (i = 0; i < d.length; i++) {
        	b=sc.nextInt();
    		d[i] = b;
    	}
        
        
        for (i = 0; i < c.length; i++) {
        	
        	c[i]=c[i]+d[i];
        	System.out.print(c[i]+ " ");
        }

    }
}
   