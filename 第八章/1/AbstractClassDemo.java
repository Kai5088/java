
import java.util.Scanner;

/**
 Demonstrates where the clone method works,
 but copy constructors do not.
*/
public class AbstractClassDemo
{

    public static void main(String[] args)
    {
        
        Employee a1,a2,a3;
        int b1,b2,b3;
        int hourlyrate, weeklyrate;
        Scanner keyboard = new Scanner(System.in);

        
        hourlyrate = keyboard.nextInt( );
        
        b1 = keyboard.nextInt( );

        
        b2 = keyboard.nextInt( ); 
 
        
        weeklyrate = keyboard.nextInt( );
        
        b3 = keyboard.nextInt( );

       // ***********************************
       // insert your code
       //a1: assign a HourlyEmployee class, name is Tom
       //a1: assign a SalariedEmployee class, name is Mary
       //a1: assign a WeeklyEmployee class, name is Mary
       // ***********************************


        a1 = new HourlyEmployee("Tom",new Date(),hourlyrate,b1);
        a2 = new SalariedEmployee("Mary",new Date(),b2);
        a3 = new WeeklyEmployee("Mary",new Date(),weeklyrate,b3);
        
        if (a1.samePay(a2) )
            System.out.print("Tom and Mary are the same pay");
        else
            System.out.print("Tom and Mary are not the same pay");

        if (a1.samePay(a3) )
            System.out.print("Tom and Keivan are the same pay");
        else
            System.out.print("Tom and Keivan are not the same pay");


     }
 }
