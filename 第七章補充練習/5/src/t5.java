import java.util.Scanner;

public class t5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        String kin = sc.nextLine();
        Scanner test = new Scanner(kin);
        
        test.useDelimiter(" ");
        
        boolean re=kin.contains(".");
        
        
        int i=0;
        if(re) {
        	double[] array = new double[50];
        while(test.hasNextDouble()){
            array[i] = Double.parseDouble(test.next());
            i++;
        }
        
        int x=i;
        
        for(int j=0;j<i;j++){
            for(int k=0;k<(i-1);k++){
                if(array[k]>=array[k+1]){
                	double a = array[k];
                    array[k] = array[k+1];
                    array[k+1] = a;
                }
            }
        }
        System.out.println("Output");
		System.out.println("The least score is "+array[0]);
		System.out.println("The scores are:");
		
			for (i=0;i<x;i++) {
				System.out.printf("%.1f differs from min by %.1f", array[i], (array[i]-array[0]));
				if(i<x-1)
					System.out.println("");
			}
        }
        else {
        	int[] array = new int[50];
        	while(test.hasNextInt()){
                array[i] = Integer.parseInt(test.next());
                i++;
            }
            
            int x=i;
            
            for(int j=0;j<i;j++){
                for(int k=0;k<(i-1);k++){
                    if(array[k]>=array[k+1]){
                    	int a = array[k];
                        array[k] = array[k+1];
                        array[k+1] = a;
                    }
                }
            }
            System.out.println("Output");
    		System.out.println("The least score is "+array[0]);
    		System.out.println("The scores are:");
    		
    			for (i=0;i<x;i++) {
    				System.out.printf("%d differs from min by %d.0", array[i], (array[i]-array[0]));
    				if(i<x-1)
    					System.out.println("");
    			}
            }
        }
	}


