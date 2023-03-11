
/**
 Class Invariant: All objects have a name string, hire date, nonnegative 
 wage rate, and nonnegative number of weeks worked. A name string of 
 "No name" indicates no real name specified yet. A hire date of Jan 1, 1000 
 indicates no real hire date specified yet.
*/
public class WeeklyEmployee extends Employee 
{
    private double weeklyRate; 
    private double weeks; //for the month

    public WeeklyEmployee( )
    {
        super( );
        weeklyRate = 0;
        weeks = 0;
    }

    /**
     Precondition: Neither theName nor theDate is null; 
     theweeklyRate and theweeks are nonnegative.
    */
    public WeeklyEmployee(String theName, Date theDate,
                       double theweeklyRate, double theweeks)
    {
      	super(theName,theDate);
	weeklyRate=theweeklyRate;
	weeks=theweeks;
    }

    public WeeklyEmployee(WeeklyEmployee originalObject)
    {
         super(originalObject);
         weeklyRate = originalObject.weeklyRate;
         weeks = originalObject.weeks;
    }

    public double getPay( )
    {
      return weeks*weeklyRate;
      


    }

    public double getRate( )
    {
      return weeklyRate;
      
    }

    public double getweeks( )
    {
       return weeks;
      
    }

    /**
     Returns the pay for the month.
    */

    /**
     Precondition: weeksWorked is nonnegative.
    */
    public void setweeks(double weeksWorked)
    {
      if (weeksWorked >= 0)
             weeks = weeksWorked;
         else
         {
             System.out.println("Fatal Error: Negative weeks worked.");
             System.exit(0);
         }
      
     }

    /**
     Precondition: newweeklyRate is nonnegative.
    */
    public void setRate(double newweeklyRate)
    {
     	if (newweeklyRate >= 0)
             weeklyRate = newweeklyRate;
         else
         {
             System.out.println("Fatal Error: Negative week rate.");
             System.exit(0);
         }
      
    }

    public boolean equals(WeeklyEmployee other)
    {
      return (getName( ).equals(other.getName( )) 
                && getHireDate( ).equals(other.getHireDate( ))
                && weeklyRate == other.weeklyRate
                && weeks == other.weeks);
      
    }

    public String toString( )
    {
        return (getName( ) + " " + getHireDate( ).toString( ) 
                + "\n$" + weeklyRate + " per hour for " + weeks + " weeks");
    }
 

}
