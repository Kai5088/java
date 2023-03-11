import java.util.Scanner;


public class next5 {
    public static void main(String[] args) {
        

        Scanner sc=new Scanner(System.in);
        int a=0;
        
        int sizeW=sc.nextInt();
        int sizeH=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        
        int count = 0;
        for(int i=0; i < sizeW; i++){
           for(int j=0; j < sizeH; j++){
                 count++;
                 if((i==x) && (j==y)) {
                	 a=count; break;
                	 } 
           }
        }
        
        
         System.out.print(a);

    }
}