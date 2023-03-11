import java.util.Scanner;
public class exception {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str3 ,str;
		
		boolean flag1=true,flag2=true,flag3=true;
        int a,b;
		while(flag1) {
			str3=sc.next();
			char str2=str3.charAt(0);
			if(!(str2<='Z'&&str2>='A')) {System.out.println("ID incorrect.");continue;}
			str=str3.substring(1,4);
			try {
				a = java.lang.Integer.parseInt(str);
				
				flag1=false;
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("ID incorrect.");
			}
			catch(NumberFormatException e) {
				System.out.println("ID incorrect.");
			}
		}
	
		
		while(flag2) {
			str=sc.next();
			try {
				b = java.lang.Integer.parseInt(str);
				if(!(b>=10000&&b<=100000)) {
					System.out.println("Account number incorrect."); continue;
				}
				flag2=false;
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Account number incorrect.");
			}
			catch(NumberFormatException e) {
				System.out.println("Account number incorrect.");
			}
		}
		
		while(flag3) {
			str=sc.next();
			try {
				b = java.lang.Integer.parseInt(str);
				if((b<=1000)) {
					System.out.println("Initial balance incorrect."); continue;
				}
				flag3=false;
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Initial balance incorrect.");
			}
		}
        
		System.out.print("Data correct.");
	}
}
