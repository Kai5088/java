
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
        int rate;
        double t;
        Scanner keyboard = new Scanner(System.in);
        
        rate = keyboard.nextInt( );
        
        b1 = keyboard.nextInt( );

        
        b2 = keyboard.nextInt( ); 
        
        b3 = keyboard.nextInt( ); 

        a1 = new HourlyEmployee("Tom", new Date("January", 1, 2008), rate, b1);
                               //(theName, Date , theWageRate, theHours)
        a2 = new SalariedEmployee("Mary", new Date("January", 11, 2008), b2);
                               //(theName, Date , the year Salary)
        a3 = new SalariedEmployee("Keivan", new Date("January", 21, 2008), b3);
                               //(theName, Date , the year Salary)
        
        if(a1.morePay(a2)) {
        	if(a1.morePay(a3))
        		System.out.print(Math.round(a1.getPay()*12));
        	else
        		System.out.print(Math.round(a3.getPay()*12));
        }
        else {
        	if(a2.morePay(a3))
        		System.out.print(Math.round(a2.getPay()*12));
        	else
        		System.out.print(Math.round(a3.getPay()*12));
        }
     }
 }
