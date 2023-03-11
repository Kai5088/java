import java.util.*;
public class t4 {
    public static void main(String [] args){
        char[] ch1 = new char[20];
        char[] ch2 = new char[20];
        Scanner sc = new Scanner(System.in);
        String st1 = sc.next();
        String st2 = sc.next();

        st1 = st1.toUpperCase();
        st2 = st2.toUpperCase();
        for(int i=0;i<st1.length();i++){
            ch1[i] = st1.charAt(i);
        }

        for(int i=0;i<st2.length();i++){
            ch2[i] = st2.charAt(i);
        }
        
        int n=0, m=0;
        while(n<st2.length()){
            for(int i=m;i<st1.length();i++){
                if(n==(st2.length()-1) && ch1[i]==ch2[n]){
                    System.out.print("Y");
                }
                if(ch1[i]==ch2[n]){
                    m=i;
                    break;
                }
                else if(i==(st1.length()-1) && ch1[i]!=ch2[i]){
                    System.out.print("N");
                    System.exit(0);
                }
            }
            n++;
        }

        /*for(int i=0;i<st1.length();i++){
            System.out.print(ch1[i]);
        }
        for(int i=0;i<st2.length();i++){
            System.out.print(ch2[i]);
        }*/
    }
}
