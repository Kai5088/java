import java.util.*;
import java.io.*;
import java.text.*;


public class login {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Account=null,Password=null,Verify_string=null,enter=null;
		int count=1;
		
		while(count<=3) {
			
			System.out.println("Account:");
			Account=sc.next();
			System.out.println("Password:");
			Password=sc.next();
			System.out.println("Verify_string:12345");
			System.out.println("Input_Verify_string:");
			Verify_string=sc.next();
			if(!Account.equals("cis")||!Password.equals("1234")||!Verify_string.equals("12345")) {
			System.out.println("Error_wrong_account_password_or_verify_string");
			count++;
		}
		else {
			System.out.println("Login_success"); break;
		}
	}
		if(count==4) {
			System.exit(0);
		}
		System.out.println("****************************************\n" +
                "[1].Show_all [2].Show_per_page [3].Show_by_catalog\n" +
                "[4].Search [5].Modify [6].Delete [7].Add_contact\n" +
                "[8].Add_catalog [9].Show_all_catalog [10].Set_display_field\n" +
                "[11].Set_show_perpage [12].Set_order [13].Set_sort_by_field\n" +
				"[14].Show_raw_data [15].Data_optimize [99].Exit_system\n" +
                "****************************************");
		
		while(true) {
			enter=sc.next();
			try {
			    int Enter = Integer.parseInt(enter);
			    switch(Enter) {
				case 99 :System.exit(0);
				case 4: System.out.print("****************************************\r\n"
						+ "Search by:\r\n"
						+ "[a].ID [b].Name [c].Birthday [0].Go_back_to_main_menu\r\n"
						+ "[99]. Exit_system\r\n"
						+ "****************************************\n"); break;
				default: System.out.print("Error_wrong_command\n"+"Please_enter_again:"); break;
				}
			} catch (NumberFormatException e) {
			    
			}
		
		}	
	}

}
