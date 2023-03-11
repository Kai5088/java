

import java.util.Scanner;

public class Main {
    public static Scanner scanner;
    public static Control control;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        control = new Control();
        control.doLogin();
        control.loadAllData();
        while (true) {
            control.doMainMenu();
        }
    }
}
