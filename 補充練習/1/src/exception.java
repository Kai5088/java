import java.util.Scanner;
public class exception {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int count=0,sum=0;
        if(a<0) {
        	System.out.print("N must be positive.");
        }
        else {
        while(count<a) {
        	int b=sc.nextInt();
        	if(b>0) {count++; sum+=b;}
        	else {System.out.println("N must be positive.");}
        }
        System.out.print(sum);
        }
	}
}
