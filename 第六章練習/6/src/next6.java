import java.util.Scanner;

public class next6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x1,x2,y1,y2,sum;
		int i,j,k;
		x1=sc.nextInt();
		y1=sc.nextInt();
		int [][] a =new int [x1][y1];
		
		for(i=0;i<x1;i++) {
			for(j=0;j<y1;j++) {
				a[i][j] = sc.nextInt();
			}
		}
	
		x2=sc.nextInt();
		y2=sc.nextInt();
		int [][] b = new int [x2][y2];
		
		for( i=0;i<x2;i++) {
			for(j=0;j<y2;j++) {
				b[i][j]=sc.nextInt();
			}
		}
		
		int [][] d =new int [x1][y2];
		
			for (i =0; i < x1; i++) {
				for (j=0; j < y2; j++) {
				sum =0;
				for (k=0; k < y1; k++) {
					sum += (a[i][k] *b[k][j]); 
				}
				d[i][j] =sum; 
				}
			}
		
			for( i=0;i<x1;i++) {
			for(j=0;j<y2;j++) {
				System.out.print(d[i][j]+ " ");
			}
		}
	}

}