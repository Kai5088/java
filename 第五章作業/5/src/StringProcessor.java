import java.util.Scanner;

/**
Class with static methods for circles and spheres.
*/
public class StringProcessor
{
    
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String a;
        String b=keyboard.next();
        if(keyboard.hasNext()) {
        String s = keyboard.nextLine( );
        a=s.toUpperCase();
        System.out.print(b);
        System.out.print(a);
        }
        else {
        	System.out.print(b);
        }
        
        
        
}
}