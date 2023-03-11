import java.util.*;

public class t4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x,y,count1=1,count2=1;
		
		x=sc.nextInt();
		y=sc.nextInt();
		double [][] a =new double [x][y];
		double b=0;
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				a[i][j] = sc.nextDouble();
			}
		}
			
			for(int j=0;j<y;j++) {
				for(int i=0;i<x;i++) {
					b+=a[i][j];
				
				}
				
				System.out.println("exam"+count1+":"+Math.round(b/x));
				b=0;
				count1++;
			}
		
		
			for(int i=0;i<x;i++) {
				for(int j=0;j<y;j++) {
					b+=a[i][j];
					
					}
				
				System.out.println("st"+count2+":"+Math.round(b/y));
				b=0;
				count2++;
				}
				
				
			}
			
		
		
	}

