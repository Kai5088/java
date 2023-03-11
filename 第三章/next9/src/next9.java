public class next9
{
	public static void main(String[] args) {

		

		for (int G = 0; G <=9; G++)   
		{
		    for (int O = 0; O <=9; O++)
		        for (int T = 0; T <=9; T++)
		            for (int D = 0; D <=9; D++)

		    if (((G != O) && (G != T) && (G != D) && 
		            (O != T) && (O != D) && (T != D)) 
		            && 
		            ((400 *T) + (40 * O) + (4*O)) == 
		            ((1000*G) + (100*O) + (10*O) + (1*D)))
		    {
		        System.out.println("T = " + T  + " O = " + O  + 
		                " G = " + G  + " D = " + D); System.exit(0);

		    }
		        
		}
		
}
}