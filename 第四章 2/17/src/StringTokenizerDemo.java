import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerDemo {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String str;
		str=sc.next();
		StringTokenizer st;
String delimiters = "[qwertyuiopasdfghjklzxcvbnm]+|+%"; 
         st = new StringTokenizer(str, delimiters);

			while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
	}
}