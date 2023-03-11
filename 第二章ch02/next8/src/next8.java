import java.util.Scanner; 

public class next8 { 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 

String a=sc.next();
int num1=sc.nextInt();
int price1=sc.nextInt();
int sum1=num1*price1;
System.out.println(a+" "+num1+" "+price1+" "+sum1);

String b=sc.next();
int num2=sc.nextInt();
int price2=sc.nextInt();
int sum2=num2*price2;
System.out.println(b+" "+num2+" "+price2+" "+sum2);

String c=sc.next();
int num3=sc.nextInt();
int price3=sc.nextInt();
int sum3=num3*price3;
System.out.println(c+" "+num3+" "+price3+" "+sum3);

int d=sum1+sum2+sum3;

System.out.println("sum "+d);

} 
} 