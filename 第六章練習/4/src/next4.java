import java.util.*;

public class next4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x1,x2,y1,y2;
		
		x1=sc.nextInt();
		y1=sc.nextInt();
		int [][] a =new int [x1][y1];
		
		for(int i=0;i<x1;i++) {
			for(int j=0;j<y1;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		x2=sc.nextInt();
		y2=sc.nextInt();
		int [][] b = new int [x2][y2];
		
		for(int i=0;i<x2;i++) {
			for(int j=0;j<y2;j++) {
				b[i][j]=sc.nextInt();
			}
		}
		
		if(x1!=x2&&y1!=y2) {
			System.out.print("false");
		}
		else {
			for(int i=0;i<x1;i++) {
				for(int j=0;j<y2;j++) {
					System.out.print(a[i][j]+b[i][j]);
					if(j!=y2-1) {
						System.out.print(" ");
					}
				}
				
				
			}
			
		}
		
	}

}