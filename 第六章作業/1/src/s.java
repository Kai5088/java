

import java.util.Scanner;

public class s
{
    /**
     Reads in 5 scores and shows how much each
     score differs from the highest score.
    */
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int a=keyboard.nextInt();
        int[] score = new int[a];
        int index;
        int min;

        
        score[0] = keyboard.nextInt( );
        min = score[0];
        for (index = 1; index < score.length; index++)
        {
            score[index] = keyboard.nextInt( );
            if (score[index] < min)
                 min = score[index];
        //max is the largest of the values score[0],..., score[index].
        }

        System.out.println( min);
        
        for (index = 0; index < score.length; index++)
            System.out.println( (score[index]-min));
    }
}
