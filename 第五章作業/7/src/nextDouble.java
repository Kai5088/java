import java.util.Scanner; 
import java.lang.Math;
public class nextDouble { 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 

double num=sc.nextDouble(); 
double a=14+Math.log(num)/Math.log(10);


System.out.printf("%.2f", a); 
} 
} 