import java.util.Scanner;


public class t1 {
	public static void main(String[] args) {
		int i,flag=1,count=0;
		int a,b;
		
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=a;
		
		while(a>0) {
			a/=10;
			count++;
		}
		
		int[] s1=new int[count];
		int[] s2=new int[count];
		
		for(i=1;i<=count/2;i++) {
			s1[i]=b%10;
			b/=10;
		}
		
		
		if(count%2!=0) {
			b/=10;
		}
		
		for(i=count/2;i>=0;i--) {
			s2[i]=b%10;
			b/=10;
		}
		
		
		for(i=1;i<=count/2;i++) {
			if(s1[i]!=s2[i]) {
				flag=0;
				break;
			}
		}
		
		if(flag==1) {
			System.out.print("Yes");
		}
		else {
			System.out.print("No");
		}
	}

}
