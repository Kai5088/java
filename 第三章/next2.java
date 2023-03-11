import java.util.Scanner;


public class next2 {
    public static void main(String[] args) {
        

        Scanner sc=new Scanner(System.in);

        for(int i=0;i<5;i++)
        {
        char a=sc.next().charAt(0);
        
        
        
        switch(a)
        {
        case 'a':
        	System.out.print("A"); break;
        case 'b':
        	System.out.print("B"); break;
        case 'c':
        	System.out.print("C"); break;
        case 'd':
        	System.out.print("D"); break;
        case 'e':
        	System.out.print("E"); break;	
        default:
        	System.out.print("Z"); break;
        
        }
        
        if(i!=4)
        	System.out.print(" ");
       }  

    }
}