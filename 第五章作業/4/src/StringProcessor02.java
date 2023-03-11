import java.util.Scanner;

/**
Class with static methods for circles and spheres.
*/
public class StringProcessor02
{
    
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String a,b;
        String s = keyboard.nextLine( );
        a=s.toUpperCase();
        b=s.toLowerCase();
        System.out.println(a);
        System.out.print(b);
}
}