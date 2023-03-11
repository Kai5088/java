import java.util.Scanner;

public class next10 {
    public static void main(String[] args) {
        
    	Scanner sc=new Scanner(System.in); 
        int b,d,e,c;
        b=sc.nextInt();
        d=sc.nextInt();
        e=sc.nextInt();
        
        if(b+e>0)
        	c=b-e;
        else
        	c=b-e+10;
        
        
        System.out.print(c);
        
        
       

    }
}