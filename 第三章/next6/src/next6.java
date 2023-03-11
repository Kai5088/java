import java.util.Scanner;


public class next6 {
    public static void main(String[] args) {
        
    	
        Scanner sc=new Scanner(System.in);

        
        String a=sc.next();
        char data1[]=a.toCharArray();
        String b=sc.next();
        char data2[]=b.toCharArray();
        
        int c,d,m, e,f,g ,h,i,j;
        
        c = data1[0];
        d = data2[0];
        m = c - 65+d -65;
       
        e = data1[1];
        f = data2[1];
        g = e - 65+f -65;
        
        h = data1[2];
        i = data2[2];
        j = h - 65+i -65;
        
        
        m=m*100+g*10+j;
        
        System.out.print(m);
        
        
       

    }
}