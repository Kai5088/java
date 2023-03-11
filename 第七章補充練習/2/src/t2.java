import java.util.Scanner;

public class t2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        double[] array = new double[50];
        String kin = sc.nextLine();
        Scanner test = new Scanner(kin);
        
        test.useDelimiter(" ");
        int i=0;
        while(test.hasNext()){
            array[i] = Double.parseDouble(test.next());
            i++;
        }
        
        int x=i;
        
        for(int j=0;j<i;j++){
            for(int k=0;k<(i-1);k++){
                if(array[k]<=array[k+1]){
                	double a = array[k];
                    array[k] = array[k+1];
                    array[k+1] = a;
                }
            }
        }

		System.out.print("Large to small: ");
		for (i=0;i<x;i++) {
		System.out.print(array[i]+ " ");
		}

	}

}
