import java.util.*;
public class t3 {
    public static void main(String [] args){
        char[][] array = {{'1','A','B','C','D'},
                          {'2','A','B','C','D'},
                          {'3','A','B','C','D'},
                          {'4','A','B','C','D'},
                          {'5','A','B','C','D'},
                          {'6','A','B','C','D'},
                          {'7','A','B','C','D'}};

        Scanner sc = new Scanner(System.in);
        String[] a = new String[50];
        String kin = sc.nextLine();
        Scanner test = new Scanner(kin);
        
        test.useDelimiter(" ");
        int n=0;
        while(test.hasNext()){
            a[n] = test.next();
            switch(a[n]){
                case "1A": case "1a":
                    array[0][1] = 'X';
                    break;
                case "1B": case "1b":
                    array[0][2] = 'X';
                    break;
                case "1C": case "1c":
                    array[0][3] = 'X';
                    break;
                case "1D": case "1d":
                    array[0][4] = 'X';
                    break;
                case "2A": case "2a":
                    array[1][1] = 'X';
                    break;
                case "2B": case "2b":
                    array[1][2] = 'X';
                    break;
                case "2C": case "2c":
                    array[1][3] = 'X';
                    break;
                case "2D": case "2d":
                    array[1][4] = 'X';
                    break;
                case "3A": case "3a":
                    array[2][1] = 'X';
                    break;
                case "3B": case "3b":
                    array[2][2] = 'X';
                    break;
                case "3C": case "3c":
                    array[2][3] = 'X';
                    break;
                case "3D": case "3d":
                    array[2][4] = 'X';
                    break;
                case "4A": case "4a":
                    array[3][1] = 'X';
                    break;
                case "4B": case "4b":
                    array[3][2] = 'X';
                    break;
                case "4C": case "4c":
                    array[3][3] = 'X';
                    break;
                case "4D": case "4d":
                    array[3][4] = 'X';
                    break;
                case "5A": case "5a":
                    array[4][1] = 'X';
                    break;
                case "5B": case "5b":
                    array[4][2] = 'X';
                    break;
                case "5C": case "5c":
                    array[4][3] = 'X';
                    break;
                case "5D": case "5d":
                    array[4][4] = 'X';
                    break;
                case "6A": case "6a":
                    array[5][1] = 'X';
                    break;
                case "6B": case "6b":
                    array[5][2] = 'X';
                    break;
                case "6C": case "6c":
                    array[5][3] = 'X';
                    break;
                case "6D": case "6d":
                    array[5][4] = 'X';
                    break;
                case "7A": case "7a":
                    array[6][1] = 'X';
                    break;
                case "7B": case "7b":
                    array[6][2] = 'X';
                    break;
                case "7C": case "7c":
                    array[6][3] = 'X';
                    break;
                case "7D": case "7d":
                    array[6][4] = 'X';
                    break;
                default:
                    System.out.print("ERROR");
                    System.exit(0);
                    break;
            }
            n++;
        }
        
        


        /*for(int i=0;i<n;i++){
            System.out.print(a[i]);
            if(i==(n-1)){
                System.out.println();
            }
            else{
                System.out.print(" ");
            }
        }*/

        for(int i=0;i<7;i++){
            for(int j=0;j<5;j++){
                System.out.print(array[i][j]);
                if(j==4&&i!=6){
                    System.out.println();
                }
                else if(j==4&&i==6){
                    break;
                }
                else{
                    System.out.print(" ");
                }
            }
        }
    }
}
