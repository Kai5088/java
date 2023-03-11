import java.util.*;
public class t2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int[] array = new int[50];
        String kin = sc.nextLine();
        Scanner test = new Scanner(kin);
        
        test.useDelimiter(" ");
        int i=0;
        while(test.hasNext()){
            array[i] = Integer.parseInt(test.next());
            i++;
        }

        for(int j=0;j<i;j++){
            for(int k=0;k<(i-1);k++){
                if(array[k]<=array[k+1]){
                    int a = array[k];
                    array[k] = array[k+1];
                    array[k+1] = a;
                }
            }
        }

        int[] element = new int[50];
        int[] count = new int[50];
        for(int j=0;j<i;j++){
            count[j] = 1;
        }
        element[0] = array[0];
        int elength = 1;
        for(int j=1;j<i;j++){
            if(array[j]!=array[j-1]){
                element[elength]=array[j];
                elength++;
            }
            else{
                count[elength-1]++;
            }
        }
        
        for(int j=0;j<elength;j++){
            System.out.print(element[j]+" "+count[j]);
            if(j!=elength-1){
                System.out.println();
            }
        }

        /*for(int j=0;j<elength;j++){
            System.out.print(element[j]);
            if(j!=elength-1){
                System.out.print(" ");
            }
            else System.out.print("\n");
        }

        for(int j=0;j<elength;j++){
            System.out.print(count[j]);
            if(j!=elength-1){
                System.out.print(" ");
            }
            else System.out.print("\n");
        }

        for(int j=0;j<i;j++){
            System.out.print(array[j]);
            if(j!=i-1){
                System.out.print(" ");
            }
        }*/
    }
}
