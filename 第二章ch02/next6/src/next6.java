import java.util.Scanner; 
import java.lang.Math;
public class next6 { 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in).useDelimiter("\n"); 

String a=sc.nextLine(); 
String b=sc.nextLine(); 
Scanner str = new Scanner(a).useDelimiter(b);

while(str.hasNext()) {
	String temp=str.next();
	System.out.println(temp);
	
}

} 
} 