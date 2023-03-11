import java.math.BigInteger;
import java.util.Scanner;
 
public class biginterger {
 
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        BigInteger result = new BigInteger("1");
        for (int i = 2; i <= N; ++i) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(result);
    }
}