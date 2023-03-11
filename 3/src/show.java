import java.util.*;
import java.io.*;
import java.text.*;


public class show {

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
				case 1:System.out.print("[ID] [Name]       [Phone]     [Catalog]    [Email]                  [BD]\r\n"
						+ "0001 Andy         0934-675983 Family       alice0212@gmail.com      0212\r\n"
						+ "0002 Cherry       0943-333165 Classmate    Cherry1029@gmail.com     1029\r\n"
						+ "0003 Ivy          0936-408012 Family       Ivy0716@yahoo.com.tw     0716\r\n"
						+ "0004 Kelly        0965-009832 Friend       Kelly0303@yahoo.com.tw   0303\r\n"
						+ "0005 Paul         0965-431322 Classmate    Paul1201@yahoo.com.tw    1201\r\n"
						+ "0006 Zack         0912-125498 Friend       Zack0101@gmail.com       0101\r\n"
						+ "[0].Go_back_to_main_menu [99].Exit_system\r\n"
						); break;
				default: System.out.print("Error_wrong_command\n"+"Please_enter_again:"); break;
				}
			} catch (NumberFormatException e) {
			    
			}
		
		}	
	}

}
