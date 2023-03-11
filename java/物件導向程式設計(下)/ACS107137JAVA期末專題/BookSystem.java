import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.io.Console;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;

public class BookSystem
{
	Scanner keyin = new Scanner(System.in);
	ArrayList<BookData> booklist = new ArrayList<>();
	boolean Sorting=true, Name=false, Author=false, Company=false, Number=false, Sort=false, Year=false;
	
	public static void main(String[] args) // Main
	{
		BookSystem demo = new BookSystem();
		demo.login();
		demo.readBook();
		demo.mainMenu();
	}
	
	public void login() // 登入
	{
		System.out.print("\r\n-------------" + time() + "-------------");
		System.out.print("\r\n-- A.顯示密碼　　　　B.隱藏密碼　　　　C.結束\r\n-> ");
		String temp = keyin.next();
		if(temp.equalsIgnoreCase("A"))
		{	
			System.out.print("\r\n帳號：");
			String account = keyin.next();
			System.out.print("密碼：");
			String password = keyin.next();
		
			if(account.equals("cis") && password.equals("1234"))
			{
				System.out.println("\r\n登入成功！");
			}
			else
			{
				System.out.println("\r\n帳號或密碼錯誤，請重新輸入帳號密碼...");
				login();
			}
		}
		else if(temp.equalsIgnoreCase("B"))
		{
			Console console = System.console();
			System.out.print("\r\n帳號：");
			String account = console.readLine();
			char[] passwd = console.readPassword("密碼：");
			String password = String.valueOf(passwd);
		
			if(account.equals("cis") && password.equals("1234"))
			{
				System.out.println("\r\n登入成功！");
			}
			else
			{
				System.out.println("\r\n帳號或密碼錯誤，請重新輸入帳號密碼...");
				login();
			}
		}
		else if(temp.equalsIgnoreCase("C"))
		{
			System.out.println("\r\n系統關閉中...");
			System.exit(0);
		}
		else
		{
			System.out.println("\r\n錯誤！請重新輸入想要執行之功能代碼：");
			login();
		}
	}
	
	public String time() // 顯示現在時間
	{   
		SimpleDateFormat Time = new SimpleDateFormat("YYYY/MM/DD k:mm:ss");
		Date date = new Date();
		String time = Time.format(date);
		return time;
	}
	
	public void mainMenu() // 主選單
	{
		System.out.println("\r\n\r\n---------------" + time() + "---------------");
		System.out.print("\r\n請選擇想要執行之功能代碼：\r\n");
		System.out.print("-- A.管理者功能　　　　B.使用者功能　　　　C.結束\r\n-> ");
		String choice = keyin.next();
		while(true)
		if(choice.equalsIgnoreCase("A"))
		{
			Console console = System.console();
			char[] passwd = console.readPassword("\r\n請輸入管理者密碼(12345)(隱藏)：");
			String password = String.valueOf(passwd);
			if(!password.equals("12345"))
			{
				System.out.println("\r\n密碼錯誤！！！");
				mainMenu();
			}
			else
				managerMenu();
		}
		else if(choice.equalsIgnoreCase("B"))
		{
			userMenu();
		}
		else if(choice.equalsIgnoreCase("C"))
		{
			System.out.print("\r\n請選擇是否要儲存檔案(Y/N)：");
			String temp = keyin.next();
			while(true)
			{
				if(temp.equalsIgnoreCase("Y"))
				{
					storeBook_manager();
					storeBook_user();
					System.out.println("\r\n系統關閉中...");
					System.exit(0);
				}
				else if(temp.equalsIgnoreCase("N"))
				{
					System.out.println("\r\n系統關閉中...");
					System.exit(0);
				}
				else
				{
					System.out.print("請選擇是否要儲存檔案(Y/N)：");
					temp = keyin.next();
				}
			}
		}
		else
		{
			System.out.println("\r\n\r\n---------------" + time() + "---------------");
			System.out.println("\r\n錯誤！請重新選擇想要執行之功能代碼：");
			System.out.print("-- A.管理者功能　　　　B.使用者功能　　　　C.結束\r\n-> ");
			choice = keyin.next();
		}
	}
	
	public void managerMenu() // 管理者選單
	{
		System.out.println("\r\n\r\n------------------" + time() + "-------------------");
		System.out.print("\r\n請選擇想要執行之功能代碼：(管理者)\r\n");
		System.out.println("-- A.設定顯示欄位　　　　B.初始化書庫　　　　C.顯示");
		System.out.print("-- D.備份　　　　　　　　E.還原　　　　　　　F.回主選單\r\n-> ");
		String choice = keyin.next();
		while(true)
		if(choice.equalsIgnoreCase("A"))
		{
			titleControl_manager();
			managerMenu();
		}
		else if(choice.equalsIgnoreCase("B"))
		{
			initializeBook();
			readBook();
			managerMenu();
		}
		else if(choice.equalsIgnoreCase("C"))
		{
			displayBook_manager();
		}
		else if(choice.equalsIgnoreCase("D"))
		{
			backupBook_manager();
			managerMenu();
		}
		else if(choice.equalsIgnoreCase("E"))
		{
			revertBook();
			readBook();
			managerMenu();
		}
		else if(choice.equalsIgnoreCase("F"))
		{
			mainMenu();
		}
		else
		{
			System.out.println("\r\n\r\n------------------" + time() + "-------------------");
			System.out.println("\r\n錯誤！請重新選擇想要執行之功能代碼：");
			System.out.println("-- A.設定顯示欄位　　　　B.初始化書庫　　　　C.顯示所有資料");
			System.out.print("-- D.備份　　　　　　　　E.還原　　　　　　　F.回主選單\r\n-> ");
			choice = keyin.next();
		}
	}
	
	public void userMenu() // 使用者選單
	{
		System.out.println("\r\n\r\n----------------" + time() + "----------------");
		System.out.print("\r\n請選擇想要執行之功能代碼：(使用者)\r\n");
		System.out.println("-- A.查詢　　　　B.新增　　　　C.刪除　　　　D.修改");
		System.out.print("-- E.顯示　　　　F.存檔　　　　G.回主選單\r\n-> ");
		String choice = keyin.next();
		while(true)
		if(choice.equalsIgnoreCase("A"))
		{
			searchBook();
		}
		else if(choice.equalsIgnoreCase("B"))
		{
			addBook();
			userMenu();
		}
		else if(choice.equalsIgnoreCase("C"))
		{
			deleteBook();
			userMenu();
		}
		else if(choice.equalsIgnoreCase("D"))
		{
			modifyBook();
			userMenu();
		}
		else if(choice.equalsIgnoreCase("E"))
		{
			displayBook_user();
		}
			
		else if(choice.equalsIgnoreCase("F"))
		{
			storeBook_manager();
			storeBook_user();
			userMenu();
		}
		else if(choice.equalsIgnoreCase("G"))
		{
			mainMenu();
		}
		else
		{
			System.out.println("\r\n\r\n-------------------" + time() + "------------------");
			System.out.println("\r\n錯誤！請重新選擇想要執行之功能代碼：");
			System.out.println("-- A.查詢　　　　B.新增　　　　C.刪除　　　　D.修改");
			System.out.print("-- E.顯示　　　　F.存檔　　　　G.回主選單\r\n-> ");
			choice = keyin.next();
		}
	}
	
	public void searchBook() // 使用者查詢
	{
		if(booklist.size() == 0)
		{
			displayData_control();
			userMenu();
		}
		System.out.println("\r\n請選擇要查詢的欄位：");
		System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
		System.out.print("-- E.類別　　　　F.年份　　　　G.序列　　　　　H.上一頁\r\n-> ");
		String temp = keyin.next();
		int count = 0;
		while(true)
		{
			if(temp.equalsIgnoreCase("A"))
			{
				if(Name == true)
				{
					System.out.print("\r\n請輸入要查詢的書籍名稱：");
					temp = keyin.next();
					count = 0;
					for(int i=0; i<booklist.size(); i++)
					{
						if(temp.equals(booklist.get(i).getName()))
						{
							if(count == 0)
							{
								System.out.println();
								displayTitle_control();
							}
							displayElement_control(i);
							count++;
						}
					}
					if(count == 0)
					{
						System.out.println("\r\n書庫裡沒有符合的書籍！！");
						searchBook();
					}
					userMenu();
				}
				else
				{
					System.out.println("\r\n此欄位未被允許查詢！！請重新選擇要查詢的欄位：");
					System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
					System.out.print("-- E.類別　　　　F.年份　　　　G.序列　　　　　H.上一頁\r\n-> ");
					temp = keyin.next();
				}
			}
			else if(temp.equalsIgnoreCase("B"))
			{
				if(Author == true)
				{
					System.out.print("\r\n請輸入要查詢的書籍作者：");
					temp = keyin.next();
					count = 0;
					for(int i=0; i<booklist.size(); i++)
					{
						if(temp.equals(booklist.get(i).getAuthor()))
						{
							if(count == 0)
							{
								System.out.println();
								displayTitle_control();
							}
							displayElement_control(i);
							count++;
						}
					}
					if(count == 0)
					{
						System.out.println("\r\n書庫裡沒有符合的書籍！！");
						searchBook();
					}
					userMenu();
				}
				else
				{
					System.out.println("\r\n此欄位未被允許查詢！！請重新選擇要查詢的欄位：");
					System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
					System.out.print("-- E.類別　　　　F.年份　　　　G.序列　　　　　H.上一頁\r\n-> ");
					temp = keyin.next();
				}
			}
			else if(temp.equalsIgnoreCase("C"))
			{
				if(Company == true)
				{
					System.out.print("\r\n請輸入要查詢的書籍出版社：");
					temp = keyin.next();
					count = 0;
					for(int i=0; i<booklist.size(); i++)
					{
						if(temp.equals(booklist.get(i).getCompany()))
						{
							if(count == 0)
							{
								System.out.println();
								displayTitle_control();
							}
							displayElement_control(i);
							count++;
						}
					}
					if(count == 0)
					{
						System.out.println("\r\n書庫裡沒有符合的書籍！！");
						searchBook();
					}
					userMenu();
				}
				else
				{
					System.out.println("\r\n此欄位未被允許查詢！！請重新選擇要查詢的欄位：");
					System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
					System.out.print("-- E.類別　　　　F.年份　　　　G.序列　　　　　H.上一頁\r\n-> ");
					temp = keyin.next();
				}
			}
			else if(temp.equalsIgnoreCase("D"))
			{
				if(Number == true)
				{
					System.out.print("\r\n請輸入要查詢的書籍編號：");
					temp = keyin.next();
					count = 0;
					for(int i=0; i<booklist.size(); i++)
					{
						if(temp.equals(booklist.get(i).getNumber()))
						{
							if(count == 0)
							{
								System.out.println();
								displayTitle_control();
							}
							displayElement_control(i);
							count++;
							break;
						}
					}
					if(count == 0)
					{
						System.out.println("\r\n書庫裡沒有符合的書籍！！");
						searchBook();
					}
					userMenu();
				}
				else
				{
					System.out.println("\r\n此欄位未被允許查詢！！請重新選擇要查詢的欄位：");
					System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
					System.out.print("-- E.類別　　　　F.年份　　　　G.序列　　　　　H.上一頁\r\n-> ");
					temp = keyin.next();
				}
			}
			else if(temp.equalsIgnoreCase("E"))
			{
				if(Sort == true)
				{
					System.out.println("\r\n請選擇要查詢的書籍類別：");
					System.out.println("-- A.電腦　　　　B.宗教　　　　C.科學");
					System.out.print("-- D.史地　　　　E.語文　　　　F.藝術\r\n-> ");
					boolean check = false;
					temp = keyin.next();
					while(check == false)
					{
						switch(temp)
						{
							case "A": case "a":
								temp = "電腦"; check = true; break;
							case "B": case "b":
								temp = "宗教"; check = true; break;
							case "C": case "c":
								temp = "科學"; check = true; break;
							case "D": case "d":
								temp = "史地"; check = true; break;
							case "E": case "e":
								temp = "語文"; check = true; break;
							case "F": case "f":
								temp = "藝術"; check = true; break;
							default:
								System.out.println("\r\n錯誤！！請重新選擇要查詢的書籍類別：");
								System.out.println("-- A.電腦　　　　B.宗教　　　　C.科學");
								System.out.print("-- D.史地　　　　E.語文　　　　F.藝術\r\n-> ");
								temp = keyin.next();
						}
					}
				
					count = 0;
					for(int i=0; i<booklist.size(); i++)
					{
						if(temp.equals(booklist.get(i).getSort()))
						{
							if(count == 0)
							{
								System.out.println();
								displayTitle_control();
							}
							displayElement_control(i);
							count++;
						}
					}
					if(count == 0)
					{
						System.out.println("\r\n書庫裡沒有符合的書籍！！");
						searchBook();
					}
					userMenu();
				}
				else
				{
					System.out.println("\r\n此欄位未被允許查詢！！請重新選擇要查詢的欄位：");
					System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
					System.out.print("-- E.類別　　　　F.年份　　　　G.序列　　　　　H.上一頁\r\n-> ");
					temp = keyin.next();
				}
			}
			else if(temp.equalsIgnoreCase("F"))
			{
				if(Year == true)
				{
					System.out.print("\r\n請輸入要查詢的書籍年份：");
					temp = keyin.next();
					count = 0;
					for(int i=0; i<booklist.size(); i++)
					{
						if(temp.equals(booklist.get(i).getYear()))
						{
							if(count == 0)
							{
								System.out.println();
								displayTitle_control();
							}
							displayElement_control(i);
							count++;
						}
					}
					if(count == 0)
					{
						System.out.println("\r\n書庫裡沒有符合的書籍！！");
						searchBook();
					}
					userMenu();
				}
				else
				{
					System.out.println("\r\n此欄位未被允許查詢！！請重新選擇要查詢的欄位：");
					System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
					System.out.print("-- E.類別　　　　F.年份　　　　G.序列　　　　　H.上一頁\r\n-> ");
					temp = keyin.next();
				}
			}
			else if(temp.equalsIgnoreCase("G"))
			{
				System.out.print("\r\n請輸入要查詢的書籍序列(輸入0回查詢)：");
				int n = 0;
				String sorting = keyin.next();
				try 
				{
					n = Integer.parseInt(sorting);
				}
				catch (NumberFormatException e)
				{
					System.out.println("\r\n不是數字！！");
					searchBook();
				}
				if(n > booklist.size())
				{
					System.out.println("\r\n書庫裡沒有符合的書籍！！");
					searchBook();
				}
				else if(n == 0)
				{
					searchBook();
				}
				else
				{
					System.out.println();
					displayTitle_control();
					displayElement_control(n-1);
					userMenu();
				}
			}
			else if(temp.equalsIgnoreCase("H"))
			{
				userMenu();
			}
			else
			{
				System.out.println("\r\n錯誤！！請重新選擇要查詢的欄位：");
				System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
				System.out.print("-- E.類別　　　　F.年份　　　　G.序列　　　　　H.上一頁\r\n-> ");
				temp = keyin.next();
			}
		}
	}
	
	public void addBook() // 使用者新增
	{
		BookData data = new BookData();
		System.out.println("\r\n輸入0回使用者選單");
		System.out.print("請輸入新增的書籍名稱：");
		String temp = keyin.next();
		if(temp.equalsIgnoreCase("0")) userMenu();
		while(!data.setName(temp))
		{
			temp = keyin.next();
			if(temp.equalsIgnoreCase("0")) userMenu();
		}
		
		System.out.print("請輸入新增的書籍作者：");
		temp = keyin.next();
		if(temp.equalsIgnoreCase("0")) userMenu();
		while(!data.setAuthor(temp))
		{
			temp = keyin.next();
			if(temp.equalsIgnoreCase("0")) userMenu();
		}
		
		System.out.print("請輸入新增的書籍出版社：");
		temp = keyin.next();
		if(temp.equalsIgnoreCase("0")) userMenu();
		while(!data.setCompany(temp))
		{
			temp = keyin.next();
			if(temp.equalsIgnoreCase("0")) userMenu();
		}
		
		System.out.print("請輸入新增的書籍編號：");
		boolean check = false;
		do
		{
			temp = keyin.next();
			if(temp.equalsIgnoreCase("0")) userMenu();
			while(!data.setNumber(temp))
			{
				temp = keyin.next();
				if(temp.equalsIgnoreCase("0")) userMenu();
			}
			if(booklist.size() == 0)
			{
				data.setNumber(temp);
				check = true;
				break;
			}
			else
			{
				for(int i=0; i<booklist.size(); i++)
				{
					if(temp.equals(booklist.get(i).getNumber()))
					{
						System.out.print("重複！！請重新輸入編號：");
						check = false;
						break;
					}
					else if((i == booklist.size()-1 && !temp.equals(booklist.get(i).getNumber())))
					{
						data.setNumber(temp);
						check = true;
						break;
					}
				}
			}
		} while(check == false);
			
		System.out.println("請選擇新增書籍的類別");
		System.out.println("-- A.電腦　　　　B.宗教　　　　C.科學");
		System.out.print("-- D.史地　　　　E.語文　　　　F.藝術\r\n-> ");
		check = false;
		temp = keyin.next();
		if(temp.equalsIgnoreCase("0")) userMenu();
		while(check == false)
		{
			switch(temp)
			{
				case "A": case "a":
					data.setSort("電腦"); check = true; break;
				case "B": case "b":
					data.setSort("宗教"); check = true; break;
				case "C": case "c":
					data.setSort("科學"); check = true; break;
				case "D": case "d":
					data.setSort("史地"); check = true; break;
				case "E": case "e":
					data.setSort("語文"); check = true; break;
				case "F": case "f":
					data.setSort("藝術"); check = true; break;
				default:
					System.out.println("\r\n錯誤！請重新選擇新增書籍的類別");
					System.out.println("-- A.電腦　　　　B.宗教　　　　C.科學");
					System.out.print("-- D.史地　　　　E.語文　　　　F.藝術\r\n-> ");
					temp = keyin.next();
					if(temp.equalsIgnoreCase("0")) userMenu();
			}
		}
		
		System.out.print("請輸入新增的書籍出版年份：");
		temp = keyin.next();
		if(temp.equalsIgnoreCase("0")) userMenu();
		while(!data.setYear(temp))
		{
			temp = keyin.next();
			if(temp.equalsIgnoreCase("0")) userMenu();
		}
		booklist.add(data);
		
		System.out.println();
		displayTitle_all();
		displayElement_all(booklist.size()-1);
		System.out.println();
		System.out.println("新增完成！！");
	}
	
	public void deleteBook() // 使用者刪除
	{
		displayData_control();
		if(booklist.size() == 0) userMenu();
		System.out.print("\r\n請輸入要刪除的書籍序列(輸入0回使用者選單)：");
		int n = 0;
		String sorting = keyin.next();
		try 
		{
			n = Integer.parseInt(sorting);
		}
		catch (NumberFormatException e)
		{
			System.out.println("\r\n不是數字！！");
			userMenu();
		}
		while(n >= 0)
		{
			if(n > booklist.size())
			{
				System.out.print("請重新輸入想要刪除的書籍序列：");
				sorting = keyin.next();
				try 
				{
					n = Integer.parseInt(sorting);
				}
				catch (NumberFormatException e)
				{
					System.out.println("\r\n不是數字！！");
					userMenu();
				}
				continue;
			}
			else if(n != 0 && n <= booklist.size())
			{
				booklist.remove(n-1);
				System.out.println("\r\n刪除完成！！");
				userMenu();
			}
			else if(n == 0)
				userMenu();
		}
		System.out.println("\r\n無效的數字！！");
	}
	
	public void modifyBook() // 使用者修改
	{
		displayData_control();
		if(booklist.size() == 0) userMenu();
		System.out.print("\r\n請輸入想要修改的書籍序列(輸入0回使用者選單)：");
		int n = 0;
		String sorting = keyin.next();
		try 
		{
			n = Integer.parseInt(sorting);
		}
		catch (NumberFormatException e)
		{
			System.out.println("\r\n不是數字！！");
			userMenu();
		}
		while(n >= 0)
		{
			if(n > booklist.size())
			{
				System.out.print("請重新輸入想要修改的書籍序列：");
				sorting = keyin.next();
				try 
				{
					n = Integer.parseInt(sorting);
				}
				catch (NumberFormatException e)
				{
					System.out.println("\r\n不是數字！！");
					userMenu();
				}
				continue;
			}
			else if(n == 0)
				userMenu();
			n--;
			
			System.out.println("\r\n請選擇想要修改的欄位：");
			System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
			System.out.print("-- E.類別　　　　F.年份　　　　G.上一頁\r\n-> ");
			
			String temp = keyin.next();
			while(true)
			{
				if(temp.equalsIgnoreCase("A"))
				{
					if(Name == true)
					{
						System.out.print("\r\n請輸入新的書名：");
						temp = keyin.next();
						while(!booklist.get(n).setName(temp))
							temp = keyin.next();
						System.out.println();
						displayTitle_control();
						displayElement_control(n);
						System.out.println("\r\n修改成功！！");
						userMenu();
					}
					else
					{
						System.out.println("\r\n此欄位未被允許修改！！請重新選擇要修改的欄位：");
						System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
						System.out.print("-- E.類別　　　　F.年份　　　　G.上一頁\r\n-> ");
						temp = keyin.next();
					}
				}
				else if(temp.equalsIgnoreCase("B"))
				{
					if(Author == true)
					{
						System.out.print("\r\n請輸入新的作者：");
						temp = keyin.next();
						while(!booklist.get(n).setAuthor(temp))
							temp = keyin.next();
						System.out.println();
						displayTitle_control();
						displayElement_control(n);
						System.out.println("\r\n修改成功！！");
						userMenu();
					}
					else
					{
						System.out.println("\r\n此欄位未被允許修改！！請重新選擇要修改的欄位：");
						System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
						System.out.print("-- E.類別　　　　F.年份　　　　G.上一頁\r\n-> ");
						temp = keyin.next();
					}
				}
				else if(temp.equalsIgnoreCase("C"))
				{
					if(Company == true)
					{
						System.out.print("\r\n請輸入新的出版社：");
						temp = keyin.next();
						while(!booklist.get(n).setCompany(temp))
							temp = keyin.next();
						System.out.println();
						displayTitle_control();
						displayElement_control(n);
						System.out.println("\r\n修改成功！！");
						userMenu();
					}
					else
					{
						System.out.println("\r\n此欄位未被允許修改！！請重新選擇要修改的欄位：");
						System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
						System.out.print("-- E.類別　　　　F.年份　　　　G.上一頁\r\n-> ");
						temp = keyin.next();
					}
				}
				else if(temp.equalsIgnoreCase("D"))
				{
					if(Number ==true)
					{
						System.out.print("\r\n請輸入新的編號：");
						boolean check = false;
						BookData tempData = new BookData();
						do
						{
							temp = keyin.next();
							while(!tempData.setNumber(temp))
							{
								temp = keyin.next();
							}
							for(int i=0; i<booklist.size(); i++)
							{
								if(temp.equals(booklist.get(i).getNumber()))
								{
									System.out.print("重複！！請重新輸入編號：");
									check = false;
									break;
								}
								else if((i == booklist.size()-1 && !temp.equals(booklist.get(i).getNumber())))
								{
									booklist.get(n).setNumber(temp);
									check = true;
									break;
								}
							}
						} while(check == false);
						System.out.println();
						displayTitle_control();
						displayElement_control(n);
						System.out.println("\r\n修改成功！！");
						userMenu();
					}
					else
					{
						System.out.println("\r\n此欄位未被允許修改！！請重新選擇要修改的欄位：");
						System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
						System.out.print("-- E.類別　　　　F.年份　　　　G.上一頁\r\n-> ");
						temp = keyin.next();
					}
				}
				else if(temp.equalsIgnoreCase("E"))
				{
					if(Sort == true)
					{
						System.out.println("\r\n請選擇新的類別：");
						System.out.println("-- A.電腦　　　　B.宗教　　　　C.科學");
						System.out.print("-- D.史地　　　　E.語文　　　　F.藝術\r\n-> ");
						boolean check = false;
						temp = keyin.next();
						while(check == false)
						{
							switch(temp)
							{
								case "A": case "a":
									booklist.get(n).setSort("電腦"); check = true; break;
								case "B": case "b":
									booklist.get(n).setSort("宗教"); check = true; break;
								case "C": case "c":
									booklist.get(n).setSort("科學"); check = true; break;
								case "D": case "d":
									booklist.get(n).setSort("史地"); check = true; break;
								case "E": case "e":
									booklist.get(n).setSort("語文"); check = true; break;
								case "F": case "f":
									booklist.get(n).setSort("藝術"); check = true; break;
								default:
									System.out.println("錯誤！請重新選擇書籍的類別");
									System.out.println("-- A.電腦　　　　B.宗教　　　　C.科學");
									System.out.print("-- D.史地　　　　E.語文　　　　F.藝術\r\n-> ");
									temp = keyin.next();
							}
						}
						System.out.println();
						displayTitle_control();
						displayElement_control(n);
						System.out.println("\r\n修改成功！！");
						userMenu();
					}
					else
					{
						System.out.println("\r\n此欄位未被允許修改！！請重新選擇要修改的欄位：");
						System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
						System.out.print("-- E.類別　　　　F.年份　　　　G.上一頁\r\n-> ");
						temp = keyin.next();
					}
				}
				else if(temp.equalsIgnoreCase("F"))
				{
					if(Year == true)
					{
						System.out.print("\r\n請輸入新的年份：");
						temp = keyin.next();
						while(!booklist.get(n).setYear(temp))
							temp = keyin.next();
						System.out.println();
						displayTitle_control();
						displayElement_control(n);
						System.out.println("\r\n修改成功！！");
						userMenu();
					}
					else
					{
						System.out.println("\r\n此欄位未被允許修改！！請重新選擇要修改的欄位：");
						System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
						System.out.print("-- E.類別　　　　F.年份　　　　G.上一頁\r\n-> ");
						temp = keyin.next();
					}
				}
				else if(temp.equalsIgnoreCase("G"))
				{
					modifyBook();
				}
				else
				{
					System.out.println("\r\n錯誤！！請重新選擇要修改的欄位：");
					System.out.println("-- A.書名　　　　B.作者　　　　C.出版社　　　　D.編號");
					System.out.print("-- E.類別　　　　F.年份　　　　G.上一頁\r\n-> ");
					temp = keyin.next();
				}
			}
		}
		System.out.println("\r\n無效的數字！！");
	}
	
	public void displayBook_user() // 使用者顯示資料
	{
		if(booklist.size() == 0)
		{
			displayData_control();
			userMenu();
		}
		System.out.println("\r\n請選擇顯示的方式：");
		System.out.println("-- A.所有資料　　　　B.以編號排序　　　　C.以年份排序");
		System.out.print  ("-- D.單一類別　　　　E.分頁　　　　　　　F.上一頁\r\n-> ");
		String temp = keyin.next();
		while(true)
		{
			if(temp.equalsIgnoreCase("A"))
			{
				displayData_control();
				userMenu();
			}
			else if(temp.equalsIgnoreCase("B"))
			{
				displaySortingNumber_control();
			}
			else if(temp.equalsIgnoreCase("C"))
			{
				displaySortingYear_control();
			}
			else if(temp.equalsIgnoreCase("D"))
			{
				displaySort_control();
				userMenu();
			}
			else if(temp.equalsIgnoreCase("E"))
			{
				displayPageData_control();
				userMenu();
			}
			else if(temp.equalsIgnoreCase("F"))
			{
				userMenu();
			}
			else
			{
				System.out.println("\r\n錯誤！！請重新選擇要查詢的欄位：");
				System.out.println("-- A.所有資料　　　　B.以編號排序　　　　C.以年份排序");
				System.out.print  ("-- D.單一類別　　　　E.分頁　　　　　　　F.上一頁\r\n-> ");
				temp = keyin.next();
			}
		}
	}
	
	public void displayBook_manager() // 管理者顯示資料
	{
		if(booklist.size() == 0)
		{
			displayData_all();
			managerMenu();
		}
		System.out.println("\r\n請選擇顯示的方式：");
		System.out.print("-- A.所有資料　　　　B.以編號排序　　　　C.以年份排序　　　　D.上一頁\r\n-> ");
		String temp = keyin.next();
		while(true)
		{
			if(temp.equalsIgnoreCase("A"))
			{
				displayData_all();
				managerMenu();
			}
			else if(temp.equalsIgnoreCase("B"))
			{
				displaySortingNumber_all();
			}
			else if(temp.equalsIgnoreCase("C"))
			{
				displaySortingYear_all();
			}
			else if(temp.equalsIgnoreCase("D"))
			{
				managerMenu();
			}
			else
			{
				System.out.println("\r\n錯誤！！請重新選擇要查詢的欄位：");
				System.out.print("-- A.所有資料　　　　B.以編號排序　　　　C.以年份排序　　　　D.上一頁\r\n-> ");
				temp = keyin.next();
			}
		}
	}
	
	public void titleControl_manager() // 管理者控制欄位顯示
	{
		System.out.println("\r\n請選擇各欄位是否要顯示(Y/N)");
		System.out.print("書名：");
		String temp = keyin.next();
		while(true)
		{
			if(temp.equalsIgnoreCase("Y"))
			{
				Name = true;
				break;
			}
			else if(temp.equalsIgnoreCase("N"))
			{
				Name = false;
				break;
			}
			else
			{
				System.out.print("錯誤！請重新輸入：");
				temp = keyin.next();
			}
		}
		
		System.out.print("作者：");
		temp = keyin.next();
		while(true)
		{
			if(temp.equalsIgnoreCase("Y"))
			{
				Author = true;
				break;
			}
			else if(temp.equalsIgnoreCase("N"))
			{
				Author = false;
				break;
			}
			else
			{
				System.out.print("錯誤！請重新輸入：");
				temp = keyin.next();
			}
		}
		
		System.out.print("出版社：");
		temp = keyin.next();
		while(true)
		{
			if(temp.equalsIgnoreCase("Y"))
			{
				Company = true;
				break;
			}
			else if(temp.equalsIgnoreCase("N"))
			{
				Company = false;
				break;
			}
			else
			{
				System.out.print("錯誤！請重新輸入：");
				temp = keyin.next();
			}
		}
		
		System.out.print("編號：");
		temp = keyin.next();
		while(true)
		{
			if(temp.equalsIgnoreCase("Y"))
			{
				Number = true;
				break;
			}
			else if(temp.equalsIgnoreCase("N"))
			{
				Number = false;
				break;
			}
			else
			{
				System.out.print("錯誤！請重新輸入：");
				temp = keyin.next();
			}
		}
		
		System.out.print("類別：");
		temp = keyin.next();
		while(true)
		{
			if(temp.equalsIgnoreCase("Y"))
			{
				Sort = true;
				break;
			}
			else if(temp.equalsIgnoreCase("N"))
			{
				Sort = false;
				break;
			}
			else
			{
				System.out.print("錯誤！請重新輸入：");
				temp = keyin.next();
			}
		}
		
		System.out.print("年份：");
		temp = keyin.next();
		while(true)
		{
			if(temp.equalsIgnoreCase("Y"))
			{
				Year = true;
				break;
			}
			else if(temp.equalsIgnoreCase("N"))
			{
				Year = false;
				break;
			}
			else
			{
				System.out.print("錯誤！請重新輸入：");
				temp = keyin.next();
			}
		}
		
		System.out.println("\r\n設定完成！");
	}
	
	public void displaySort_control() // 控制顯示單一類別資料
	{
		System.out.println("\r\n請輸入要顯示的書籍類別：");
		System.out.println("-- A.電腦　　　　B.宗教　　　　C.科學");
		System.out.print("-- D.史地　　　　E.語文　　　　F.藝術\r\n-> ");
		boolean check = false;
		String temp = keyin.next();
		while(check == false)
		{
			switch(temp)
			{
				case "A": case "a":
					temp = "電腦"; check = true; break;
				case "B": case "b":
					temp = "宗教"; check = true; break;
				case "C": case "c":
					temp = "科學"; check = true; break;
				case "D": case "d":
					temp = "史地"; check = true; break;
				case "E": case "e":
					temp = "語文"; check = true; break;
				case "F": case "f":
					temp = "藝術"; check = true; break;
				default:
					System.out.println("\r\n錯誤！！請重新輸入要顯示的書籍類別：");
					System.out.println("-- A.電腦　　　　B.宗教　　　　C.科學");
					System.out.print("-- D.史地　　　　E.語文　　　　F.藝術\r\n-> ");
					temp = keyin.next();
			}
		}
					
		int count = 0;
		boolean sortcheck = true;
		if(Sort == false)
		{
			Sort = true;
			sortcheck = false;
		}
		for(int i=0; i<booklist.size(); i++)
		{
			if(temp.equals(booklist.get(i).getSort()))
			{
				if(count == 0)
				{
					System.out.println();
					displayTitle_control();
				}
				displayElement_control(i);
				count++;
			}
		}
		if(sortcheck == false)
		{
			Sort = false;
			sortcheck = true;
		}
		if(count == 0)
			System.out.println("\r\n沒有資料！！");
	}
	
	public void displaySortingNumber_control() // 控制顯示以編號排序資料
	{
		ArrayList templist = new ArrayList(booklist);
		Collections.sort(templist, new Comparator<BookData>()
		{
			@Override
			public int compare(BookData o1, BookData o2)
			{ 
				int n1 = ((int)o1.getNumber().charAt(0))*10000 + Integer.parseInt(o1.getNumber().substring(1));
				int n2 = ((int)o2.getNumber().charAt(0))*10000 + Integer.parseInt(o2.getNumber().substring(1));
				return n1 - n2;
			}
		});
		boolean numbercheck = true;
		if(Number == false)
		{
			Number = true;
			numbercheck = false;
		}
		if(Sorting == true)
			System.out.print("序列\t");
		if(Name == true)
			System.out.print("書名\t\t");
		if(Author == true)
			System.out.print("作者\t\t");
		if(Company == true)
			System.out.print("出版社\t\t");
		if(Number == true)
			System.out.print("編號\t\t");
		if(Sort == true)
			System.out.print("類別\t\t");
		if(Year == true)
			System.out.print("年份");
		System.out.println("\r\n--------------------------------------------------------------------------------------------");
				
		for(int i=0; i<templist.size(); i++)
		{
			BookData list = (BookData) templist.get(i);
			if(Sorting == true)
				System.out.printf("%4d\t", i+1);
			if(Name == true)
				System.out.printf("%-8s\t", list.getName());
			if(Author == true)
				System.out.printf("%-8s\t", list.getAuthor());
			if(Company == true)
				System.out.printf("%-8s\t", list.getCompany());
			if(Number == true)
								System.out.printf("%-8s\t", list.getNumber());
			if(Sort == true)
				System.out.printf("%-8s\t", list.getSort());
			if(Year == true)
				System.out.printf("%-4s", list.getYear());
			System.out.println();
			if(i == templist.size()-1)
			{
				if(numbercheck == false)
				{
					Number = false;
					numbercheck = true;
				}
				userMenu();
			}
		}
	}
	
	public void displaySortingNumber_all() // 顯示以編號排序所有資料
	{
		ArrayList templist = new ArrayList(booklist);
		Collections.sort(templist, new Comparator<BookData>()
		{
			@Override
			public int compare(BookData o1, BookData o2)
			{ 
				int n1 = ((int)o1.getNumber().charAt(0))*10000 + Integer.parseInt(o1.getNumber().substring(1));
				int n2 = ((int)o2.getNumber().charAt(0))*10000 + Integer.parseInt(o2.getNumber().substring(1));
				return n1 - n2;
			}
		});
		System.out.print("序列\t");
		System.out.print("書名\t\t");
		System.out.print("作者\t\t");
		System.out.print("出版社\t\t");
		System.out.print("編號\t\t");
		System.out.print("類別\t\t");
		System.out.print("年份");
		System.out.println("\r\n--------------------------------------------------------------------------------------------");
				
		for(int i=0; i<templist.size(); i++)
		{
			BookData list = (BookData) templist.get(i);
			System.out.printf("%4d\t", i+1);
			System.out.printf("%-8s\t", list.getName());
			System.out.printf("%-8s\t", list.getAuthor());
			System.out.printf("%-8s\t", list.getCompany());
			System.out.printf("%-8s\t", list.getNumber());
			System.out.printf("%-8s\t", list.getSort());
			System.out.printf("%-4s", list.getYear());
			System.out.println();
			if(i == templist.size()-1) managerMenu();
		}
	}
	
	public void displaySortingYear_control() // 控制顯示以年份排序資料
	{
		System.out.println("\r\n請選擇要排序的方式：");
		System.out.print("-- A.從小到大　　　　B.從大到小　　　　C.上一頁\r\n-> ");
		String temp = keyin.next();
		while(true)
		{
			ArrayList templist = new ArrayList(booklist);
			if(temp.equalsIgnoreCase("A"))
			{
				Collections.sort(templist, new Comparator<BookData>()
				{
					@Override
					public int compare(BookData o1, BookData o2)
					{
						int n1 = Integer.parseInt(o1.getYear());
						int n2 = Integer.parseInt(o2.getYear());
						return n1 - n2; 
					} 
				});
			}
			else if(temp.equalsIgnoreCase("B"))
			{
				Collections.sort(templist, new Comparator<BookData>()
				{
					@Override
					public int compare(BookData o1, BookData o2)
					{
						int n1 = Integer.parseInt(o1.getYear());
						int n2 = Integer.parseInt(o2.getYear());
						return n2 - n1; 
					}
				});
			}
			else
			{
				System.out.println("\r\n請選擇要排序的方式：");
				System.out.print("-- A.從小到大　　　　B.從大到小　　　　C.上一頁\r\n-> ");
				temp = keyin.next();
			}
			if(temp.equalsIgnoreCase("A") || temp.equalsIgnoreCase("B"))
			{
				boolean yearcheck = true;
				if(Year == false)
				{
					Year = true;
					yearcheck = false;
				}
				if(Sorting == true)
					System.out.print("序列\t");
				if(Name == true)
					System.out.print("書名\t\t");
				if(Author == true)
					System.out.print("作者\t\t");
				if(Company == true)
					System.out.print("出版社\t\t");
				if(Number == true)
					System.out.print("編號\t\t");
				if(Sort == true)
					System.out.print("類別\t\t");
				if(Year == true)
					System.out.print("年份");
				System.out.println("\r\n--------------------------------------------------------------------------------------------");
		
				for(int i=0; i<templist.size(); i++)
				{
					BookData list = (BookData) templist.get(i);
					if(Sorting == true)
						System.out.printf("%4d\t", i+1);
					if(Name == true)
						System.out.printf("%-8s\t", list.getName());
					if(Author == true)
						System.out.printf("%-8s\t", list.getAuthor());
					if(Company == true)
						System.out.printf("%-8s\t", list.getCompany());
					if(Number == true)
						System.out.printf("%-8s\t", list.getNumber());
					if(Sort == true)
						System.out.printf("%-8s\t", list.getSort());
					if(Year == true)
						System.out.printf("%-4s", list.getYear());
					System.out.println();	
					if(i == templist.size()-1)
					{
						if(yearcheck == false)
						{
							Year = false;
							yearcheck = true;
						}
						userMenu();
					}
				}
			}	
		}
	}
	
	public void displaySortingYear_all() // 顯示以年份排序所有資料
	{
		System.out.println("\r\n請選擇要排序的方式：");
		System.out.print("-- A.從小到大　　　　B.從大到小　　　　C.上一頁\r\n-> ");
		String temp = keyin.next();
		while(true)
		{
			ArrayList templist = new ArrayList(booklist);
			if(temp.equalsIgnoreCase("A"))
			{
				Collections.sort(templist, new Comparator<BookData>()
				{
					@Override
					public int compare(BookData o1, BookData o2)
					{
						int n1 = Integer.parseInt(o1.getYear());
						int n2 = Integer.parseInt(o2.getYear());
						return n1 - n2;
					}
				});
			}
			else if(temp.equalsIgnoreCase("B"))
			{
				Collections.sort(templist, new Comparator<BookData>()
				{
					@Override
					public int compare(BookData o1, BookData o2)
					{
						int n1 = Integer.parseInt(o1.getYear());
						int n2 = Integer.parseInt(o2.getYear());
						return n2 - n1; 
					}
				});
			}
			else
			{
				System.out.println("\r\n請選擇要排序的方式：");
				System.out.print("-- A.從小到大　　　　B.從大到小　　　　C.上一頁\r\n-> ");
				temp = keyin.next();
			}
			if(temp.equalsIgnoreCase("A") || temp.equalsIgnoreCase("B"))
			{
				System.out.print("序列\t");
				System.out.print("書名\t\t");
				System.out.print("作者\t\t");
				System.out.print("出版社\t\t");
				System.out.print("編號\t\t");
				System.out.print("類別\t\t");
				System.out.print("年份");
				System.out.println("\r\n--------------------------------------------------------------------------------------------");
				for(int i=0; i<templist.size(); i++)
				{
					BookData list = (BookData) templist.get(i);
					System.out.printf("%4d\t", i+1);
					System.out.printf("%-8s\t", list.getName());
					System.out.printf("%-8s\t", list.getAuthor());
					System.out.printf("%-8s\t", list.getCompany());
					System.out.printf("%-8s\t", list.getNumber());
					System.out.printf("%-8s\t", list.getSort());
					System.out.printf("%-4s", list.getYear());
					System.out.println();	
					if(i == templist.size()-1) managerMenu();
				}
			}	
		}
	}
	
	public void displayPageData_control()
	{
		System.out.print("\r\n請輸入每分頁之資料數量：");
		int n = 0;
		String page = keyin.next();
		try 
		{
			n = Integer.parseInt(page);
		}
		catch (NumberFormatException e)
		{
			System.out.println("\r\n不是數字！！");
			displayPageData_control();
		}
		if(booklist.size() != 0)
		{
			int count = 0;
			System.out.println();
			displayTitle_control();
			for(int i=0; i<booklist.size(); i++)
			{
				displayElement_control(i);
				count++;
				if(count%n == 0 && count<booklist.size())
					pause();			
			}
		}
		else
			System.out.println("\r\n書庫裡沒有書籍！！");
	}
	
	public void displayData_control() // 控制顯示書庫資料
	{
		
		if(booklist.size() != 0)
		{
			System.out.println();
			displayTitle_control();
			for(int i=0; i<booklist.size(); i++)
				displayElement_control(i);
		}
		else
			System.out.println("\r\n書庫裡沒有書籍！！");
	}
	
	public void displayData_all() // 顯示書庫所有資料
	{
		if(booklist.size() != 0)
		{
			System.out.println();
			displayTitle_all();
			for(int i=0; i<booklist.size(); i++)
				displayElement_all(i);
		}
		else
			System.out.println("\r\n書庫裡沒有書籍！！");
	}
	
	public void displayTitle_control() // 控制顯示書庫欄位
	{
		if(Sorting == true)
			System.out.print("序列\t");
		if(Name == true)
			System.out.print("書名\t\t");
		if(Author == true)
			System.out.print("作者\t\t");
		if(Company == true)
			System.out.print("出版社\t\t");
		if(Number == true)
			System.out.print("編號\t\t");
		if(Sort == true)
			System.out.print("類別\t\t");
		if(Year == true)
			System.out.print("年份");
		System.out.println("\r\n--------------------------------------------------------------------------------------------");
	}
	
	public void displayTitle_all() // 顯示書庫所有欄位
	{
		System.out.println("序列\t書名\t\t作者\t\t出版社\t\t編號\t\t類別\t\t年份");
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	public void displayElement_control(int i) // 控制顯示書庫欄位之資訊
	{
		if(Sorting == true)
			System.out.printf("%4d\t", i+1);
		if(Name == true)
			System.out.printf("%-8s\t", booklist.get(i).getName());
		if(Author == true)
			System.out.printf("%-8s\t", booklist.get(i).getAuthor());
		if(Company == true)
			System.out.printf("%-8s\t", booklist.get(i).getCompany());
		if(Number == true)
			System.out.printf("%-8s\t", booklist.get(i).getNumber());
		if(Sort == true)
			System.out.printf("%-8s\t", booklist.get(i).getSort());
		if(Year == true)
			System.out.printf("%-4s", booklist.get(i).getYear());
		System.out.println();
	}
	
	public void displayElement_all(int i) // 顯示書庫所有欄位之資訊
	{
		System.out.printf("%4d\t", i+1);
		System.out.printf("%-8s\t", booklist.get(i).getName());
		System.out.printf("%-8s\t", booklist.get(i).getAuthor());
		System.out.printf("%-8s\t", booklist.get(i).getCompany());
		System.out.printf("%-8s\t", booklist.get(i).getNumber());
		System.out.printf("%-8s\t", booklist.get(i).getSort());
        System.out.printf("%-4s\r\n", booklist.get(i).getYear());
	}
	
	public void pause()  // 暫停畫面
	{
		System.out.print("\r\n按Enter鍵繼續...\r\n");
		try
		{
			System.in.read();
		}
		catch(Exception e){}
	}
	
	public void readBook() // 讀檔
	{
		String filename_manager = "Book_manager.txt";
		String filename_user = "Book_user.txt";
		File file = new File(filename_manager);
		try
		{
			if(!file.exists())
			{
				file.createNewFile();
				initializeBook();
			}
		}
		catch (Exception e)
		{
			System.out.println("無法開啟檔案");
			System.exit(0);
		}
		
		Scanner InputFile = null;
		try
		{
			InputFile = new Scanner(new FileInputStream(filename_manager));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("無法開啟檔案");
			System.exit(0);
		}
		
		String name=null, author=null, company=null, number=null, sort=null, year=null, temp=null;
		booklist.clear();
		temp = InputFile.nextLine();
		temp = InputFile.nextLine();
		while(InputFile.hasNext())
		{
			name = InputFile.next();
			author = InputFile.next();
			company = InputFile.next();
			number = InputFile.next();
			sort = InputFile.next();
			year = InputFile.next();
			BookData data = new BookData(name, author, company, number, sort, year);
			booklist.add(data);
		}
		InputFile.close();
		
		file = new File(filename_user);
		try
		{
			if(!file.exists())
			{
				file.createNewFile();
				initializeBook();
			}
		}
		catch (Exception e)
		{
			System.out.println("無法開啟檔案");
			System.exit(0);
		}
		
		InputFile = null;
		try
		{
			InputFile = new Scanner(new FileInputStream(filename_user));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("無法開啟檔案");
			System.exit(0);
		}
		
		temp = InputFile.nextLine();
		String[] title = temp.split("\t");
		for(int i=0; i<title.length; i++)
		{
			if(title[i].equals("書名"))
				Name = true;
			else if(title[i].equals("作者"))
				Author = true;
			else if(title[i].equals("出版社"))
				Company = true;
			else if(title[i].equals("編號"))
				Number = true;
			else if(title[i].equals("類別"))
				Sort = true;
			else if(title[i].equals("年份"))
				Year = true;
			
		}
		InputFile.close();
	}
	
	public void storeBook_user() // 寫檔(使用者)
	{
		String filename = "Book_user.txt";
		File file = new File(filename);
		try
		{
			if(!file.exists())
			{
				file.createNewFile();
			}
		}
		catch (Exception e)
		{
			System.out.println("無法開啟檔案");
			userMenu();
		}
		
		PrintWriter OutputFile = null;
		try
		{
			OutputFile = new PrintWriter(new FileOutputStream(filename, false));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("無法寫入檔案");
			userMenu();
		}
		
		if(Name == true)
			OutputFile.print("書名\t\t");
		if(Author == true)
			OutputFile.print("作者\t\t");
		if(Company == true)
			OutputFile.print("出版社\t\t");
		if(Number == true)
			OutputFile.print("編號\t\t");
		if(Sort == true)
			OutputFile.print("類別\t\t");
		if(Year == true)
			OutputFile.print("年份");
		OutputFile.println("\r\n--------------------------------------------------------------------------------------------");
		for(int i=0; i<booklist.size(); i++)
		{
			if(Name == true)
				OutputFile.printf("%-8s\t", booklist.get(i).getName());
			if(Author == true)
				OutputFile.printf("%-8s\t", booklist.get(i).getAuthor());
			if(Company == true)
				OutputFile.printf("%-8s\t", booklist.get(i).getCompany());
			if(Number == true)
				OutputFile.printf("%-8s\t", booklist.get(i).getNumber());
			if(Sort == true)
				OutputFile.printf("%-8s\t", booklist.get(i).getSort());
			if(Year == true)
				OutputFile.printf("%-4s\t", booklist.get(i).getYear());
			OutputFile.println();
		}
		OutputFile.close();
		
		System.out.println("\r\n存檔成功！！");
	}
	
	public void storeBook_manager() // 寫檔(管理者)
	{
		String filename = "Book_manager.txt";
		File file = new File(filename);
		try
		{
			if(!file.exists())
			{
				file.createNewFile();
			}
		}
		catch (Exception e)
		{
			System.out.println("無法開啟檔案");
			System.exit(0);
		}
		
		PrintWriter OutputFile = null;
		try
		{
			OutputFile = new PrintWriter(new FileOutputStream(filename, false));
		}
		catch(FileNotFoundException e)
		{
			userMenu();
		}
		
		OutputFile.println("書名\t\t作者\t\t出版社\t\t編號\t\t類別\t\t年份");
		OutputFile.println("--------------------------------------------------------------------------------------------");
		for(int i=0; i<booklist.size(); i++)
		{
			OutputFile.printf("%-8s\t", booklist.get(i).getName());
			OutputFile.printf("%-8s\t", booklist.get(i).getAuthor());
			OutputFile.printf("%-8s\t", booklist.get(i).getCompany());
			OutputFile.printf("%-8s\t", booklist.get(i).getNumber());
			OutputFile.printf("%-8s\t", booklist.get(i).getSort());
			OutputFile.printf("%-4s\t", booklist.get(i).getYear());
			OutputFile.println();
		}
		OutputFile.close();
		
		// System.out.println("\r\n存檔成功！！");
	}
	
	public void backupBook_manager() // 備份(管理者)
	{
		String filename = "Book_backup_manager.txt";
		File file = new File(filename);
		try
		{
			if(!file.exists())
			{
				file.createNewFile();
			}
		}
		catch (Exception e)
		{
			System.out.println("無法開啟檔案");
			System.exit(0);
		}
		
		PrintWriter BackupFile = null;
		try
		{
			BackupFile = new PrintWriter(new FileOutputStream(filename, false));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("無法備份檔案");
			managerMenu();
		}
		
		BackupFile.println("書名\t\t作者\t\t出版社\t\t編號\t\t類別\t\t年份");
		BackupFile.println("--------------------------------------------------------------------------------------------");
		for(int i=0; i<booklist.size(); i++)
		{
			BackupFile.printf("%-8s\t", booklist.get(i).getName());
			BackupFile.printf("%-8s\t", booklist.get(i).getAuthor());
			BackupFile.printf("%-8s\t", booklist.get(i).getCompany());
			BackupFile.printf("%-8s\t", booklist.get(i).getNumber());
			BackupFile.printf("%-8s\t", booklist.get(i).getSort());
			BackupFile.printf("%-4s\t", booklist.get(i).getYear());
			BackupFile.println();
		}
		BackupFile.close();
		
		System.out.println("\r\n備份成功！！");
	}
	
	public void revertBook() // 還原(管理者)
	{
		FileInputStream RevertBook_input = null;
		FileOutputStream RevertBook_output = null;
		try
		{
			RevertBook_input = new FileInputStream("Book_backup_manager.txt");
			RevertBook_output = new FileOutputStream("Book_manager.txt", false);
			byte[] buf = new byte[1024];    
			int bytesRead;    
			while ((bytesRead = RevertBook_input.read(buf)) > 0)
			{
				RevertBook_output.write(buf, 0, bytesRead);
			}
			RevertBook_input.close();
			RevertBook_output.close();
		}
		catch (Exception e)
		{
			System.out.println("無法還原檔案");
			managerMenu();
		}
		
		System.out.println("\r\n還原成功！！");
	}
	
	public void initializeBook() // 初始化檔案(管理者)
	{
		String filename = "Book_manager.txt";
		File file = new File(filename);
		try
		{
			if(!file.exists())
			{
				file.createNewFile();
			}
		}
		catch (Exception e)
		{
			System.out.println("無法開啟檔案");
			System.exit(0);
		}
		
		PrintWriter InitializeFile = null;
		try
		{
			InitializeFile = new PrintWriter(new FileOutputStream(filename, false));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("無法開啟檔案");
			System.exit(0);
		}
		
		InitializeFile.println("書名\t\t作者\t\t出版社\t\t編號\t\t類別\t\t年份");
		InitializeFile.println("--------------------------------------------------------------------------------------------");
		InitializeFile.close();
		
		System.out.println("\r\n初始化成功！！");
	}
}