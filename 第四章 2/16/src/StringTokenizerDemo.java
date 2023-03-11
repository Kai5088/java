

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerDemo
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

       
        String inputLine = keyboard.nextLine( );

        String delimiters = ", "; //Comma and blank space
        StringTokenizer nameFactory = 
             new StringTokenizer(inputLine, delimiters);

        String lastName = nameFactory.nextToken( );
        String firstName = nameFactory.nextToken( );
        String middleName = nameFactory.nextToken( );
        if (firstName.equalsIgnoreCase("None")) {
        	firstName = "";System.out.print("Hello "  + middleName + " " + lastName);} //Empty string
        else if (middleName.equalsIgnoreCase("None")) {
        	middleName = "";System.out.print("Hello " + firstName
                    + " " +  lastName);} //Empty string
        else if (lastName.equalsIgnoreCase("None")) {
        	lastName = "";System.out.print("Hello " + firstName
                    + " " + middleName );} //Empty string
        else {
        	System.out.print("Hello "  + firstName + " "  + middleName + " " + lastName);
        }
     }
}
