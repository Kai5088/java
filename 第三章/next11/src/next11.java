import java.util.Scanner;

public class next11 {
    public static void main(String[] args) {
        
    	Scanner sc=new Scanner(System.in); 
        int a,b,c,d,e,g,h,i;
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        d=sc.nextInt();
        e=sc.nextInt();
        if(d-c>0)
        	h=d-c;
        else
        	h=d-c+10;
        
        if(b*10+c+c*10+h>100)
        	i=(b*10+c+c*10+h-100-d)/10;
        else
        	i=(b*10+c+c*10+h-d)/10;
        
        if(e*100+i*10+d-a*100-b*10-c>0)
        	g=(e*100+i*10+d-a*100-b*10-c-c*10-h)/100;
        else
        	g=(e*100+i*10+d-a*100-b*10-c-c*10-h+1000)/100;
        
        
        System.out.println(g);
        System.out.println(h);
        System.out.print(i);
       

    }
}