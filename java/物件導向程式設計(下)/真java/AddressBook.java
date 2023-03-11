import java.util.*;
import java.io.*;
import java.text.*;

public class AddressBook
{
	String temp = null;
	Scanner in = new Scanner(System.in);
	ArrayList<library> myList = new ArrayList<library>();
	ArrayList<library> temp_list = new ArrayList<library>();
	int page = 5;
	library data = null;
	boolean Sorting = true, Name = true, Birthday = true, Number = true, Type = true, Mail = true;
public static void main(String[] args) //main function
{
     AddressBook demo = new AddressBook();
     demo.time();
     demo.login();
     demo.library();
     demo.welcome();
   
 }
public void login()  //登入系統
{
	String account = null, password = null;
	
		System.out.print( "請輸入帳號：" );
		account = in.next();
		System.out.print( "請輸入密碼：" );
		password = in.next();
		int a,b;
		b=(int)(Math.random()*1000);
		System.out.println("驗證碼:"+b);
		while(in.hasNextInt())
		{
		a=in.nextInt();
			if(a==b)
			break;
			else
			System.out.println("請看清楚後輸入");
		}

		if( account.equals("cis") && password.equals("1234") )
			System.out.println( "登入成功!" );
                else if( account.equals(password))
			System.out.println( "登入成功!" );
		else
			System.out.printf( "帳號或密碼錯誤，請重新輸入!\n\n" );
	
 }
public void library()  //讀library文字檔
{
    Scanner sc = null;
     try  
     {
       sc = new Scanner(new FileInputStream("library.txt"));
     }
     catch(FileNotFoundException e)
     {
      System.out.println("檔案不存在或損毀");
      System.exit(0);
     }
    
    String name = null, birthday = null, number=null,  type = null, mail = null;

		temp = sc.nextLine();
		temp = sc.nextLine();
		while( sc.hasNext() ) {
			name = sc.next();
			birthday = sc.next();
			number = sc.next();
			type= sc.next();
			mail = sc.next();
			data = new library( name, birthday, number, type, mail );
			myList.add(data);
		}

		sc.close();
 }
public void welcome( )  // 主選單
{
     System.out.println("\n請輸入想要執行功能的代碼：");
     System.out.println("A:管理者功能　　　　　　B:使用者功能　　　　　C:結束程式");

     temp = in.next();
	while( true ) 
         {
		if( temp.equalsIgnoreCase("A") )
			administrator( );
		else if ( temp.equalsIgnoreCase("B") )
			user( );
		else if( temp.equalsIgnoreCase("C") ) 
		{
			store_book( );
			System.out.println( "因選擇結束所以系統關閉" );
			System.exit( 0 );
		}
		else 
		{
			System.out.println("錯誤!請重新輸入代碼：");
			temp = in.next();
		}
	}
 }
public void administrator()  //管理者功能的選單
{
	System.out.println("\n請輸入想要執行功能的代碼：");
	System.out.println("A.設定顯示的欄位　B.設定每頁筆數  C.上一頁");

	temp = in.next();
	while( true ) {
		if( temp.equalsIgnoreCase("A") )
			display_set( );
                else if( temp.equalsIgnoreCase("B") ){
                        setpage();
                        System.out.println( "設定完成!!!" );
                        administrator();}
		else if( temp.equalsIgnoreCase("C") )
			welcome( );
		else {
			System.out.println("錯誤!請重新輸入想要執行功能的代碼：");
			System.out.println("A.設定顯示的欄位  B.設定每頁筆數  C.上一頁");
			temp = in.next();
		}
	}
    }
public void user()  //使用者功能選單
{
	System.out.println("請輸入想要執行功能的代碼：");
	System.out.println("A.新增　　　　　　　　B.查詢　　　　　　　　C.修改");
	System.out.println("D.刪除　　　　　　　　E.顯示　　　　　　　　F.存檔");
	System.out.println("G.返回上一頁");

	temp = in.next();
	while( true ) {
		if( temp.equalsIgnoreCase("A") )
			add_book();
		else if( temp.equalsIgnoreCase("B") )
			search_book();
		else if( temp.equalsIgnoreCase("C") )
			edit_book();
		else if( temp.equalsIgnoreCase("D") )
			delete_book();
		else if( temp.equalsIgnoreCase("E") )
			display();
		else if( temp.equalsIgnoreCase("F") ) {
			store_book();
			System.out.print( "\n存檔成功" );
			print_enter();
			welcome();
		}
                else if( temp.equalsIgnoreCase("G") )
                        welcome();
		
		else 
		{
			System.out.println("錯誤，請重新選取：");
			System.out.println("A.新增　　　　　　　　B.查詢　　　　　　　　C.修改");
			System.out.println("D.刪除　　　　　　　　E.顯示　　　　　　　　F.存檔");
			System.out.println("G.返回上一頁");
			temp = in.next();
		}
	}
 }
public void add_book()   //新增通訊錄
{
	data = new library();

	System.out.println("請輸入姓名：");
	temp = in.next();
	while( data.setName( temp )==false )
		temp = in.next();

	System.out.println("請輸入生日：");
	temp = in.next();
	while( data.setBirthday(temp )==false )
		temp = in.next();

	System.out.println("請輸入手機號碼：");
	temp = in.next();
	while( data.setNumber(temp )==false )
		temp = in.next();

        System.out.println("請輸入分類：");
	temp = in.next();
	while( data.setType( temp )==false )
		temp = in.next();

	System.out.println("請輸入E-mail：");
	temp = in.next();
	while( data.setMail( temp )==false )
		temp = in.next();

	myList.add( data );

	System.out.println();
	display_all_title();
	System.out.printf( " %-5d", myList.size() );
	display_all_elements( myList.size() - 1 );
	System.out.print("\n新增成功");
	print_enter();
	user();
 }
public void delete_book( )   //刪除通訊錄
{
	System.out.println("請輸入要刪除的通訊錄序列(輸入0則回到上一頁)：");

	int sorting = in.nextInt( );
	while( sorting > 0 ) {
		if( sorting > myList.size( ) ) {
			System.out.println("請重新輸入想要刪除的書籍序列(輸入0則回到上一頁)：");
			sorting =in.nextInt( );
			continue;
		}

		display_all_title( );
		System.out.printf( " %-5d", sorting );
		display_all_elements( --sorting );
		myList.remove( sorting );

		System.out.print("\n刪除OK!");
		print_enter( );
		break;
	}

	user( );
     }
public void search_book( )  //查詢通訊錄
  {
	int s = 0;

	System.out.println("請輸入要查詢的欄位：");
	System.out.println("A.姓名　　　　　　　　B.手機號碼　　　　　　C.上一頁");

	temp = in.next();
	while( true ) {
		if( temp.equalsIgnoreCase("A") ) {
		        s = 0;
		        System.out.println("請輸入要查詢的姓名：");
		        temp = in.next();
			for( int i = 0 ; i < myList.size( ) ; i++ ) {
				if( temp.equalsIgnoreCase( myList.get( i ).getName( ) ) ) {
					if( s == 0 )
						display_all_title( );
					System.out.printf( " %-5d", i+1 );
					display_all_elements( i );
					s++;
				}
			}

			if( s == 0 )
				System.out.println( "不存在" );

			System.out.println( );
			print_enter( );

			user( );
		}

		else if( temp.equalsIgnoreCase("B") ) {
			s = 0;
			System.out.println("請輸入要查詢的手機號碼：");
			temp = in.next();
			for( int i = 0 ; i < myList.size( ) ; i++ ) {
				if( temp.equalsIgnoreCase( myList.get( i ).getNumber( ) ) ) {
					if( s == 0 )
						display_all_title( );
					System.out.printf( " %-5d", i+1 );
					display_all_elements( i );
					s++;
				}
			}

			if( s == 0 )
				System.out.println( "不存在" );

			System.out.println( );
			print_enter( );

			user( );
		}

		else if ( temp.equalsIgnoreCase("C") )
			user( );

		else {
			System.out.println("錯誤，請重新選取：");
			System.out.println("A.姓名　　　　　　　　B.手機號碼　　　　　　C.上一頁");
			temp = in.next();
		}
	} 
    }
  public void edit_book( )  //修改通訊錄
  {
	System.out.println("請輸入想要修改的通訊錄序列(輸入0則回到上一頁)：");

	int sorting = in.nextInt( );
	while( sorting > 0 ) {
		if( sorting > myList.size( ) ) {
			System.out.println("請重新輸入想要修改的通訊錄序列(輸入0則回到上一頁)：");
			sorting = in.nextInt( );
			continue;
		}
		sorting--;

		System.out.println( "想要修改的通訊錄資料：" );
		display_all_elements( sorting );

		System.out.println("請選擇想要修改的欄位：");
		System.out.println("A.姓名　　　　　　　　B.生日　　　　　　　　C.手機號碼");
		System.out.println("D.分類　　　　　　　　E.E-mail");

		temp = in.next();
		while( true ) {
			if( temp.equalsIgnoreCase("A") ) {
				System.out.println("請輸入新的姓名：");
				temp = in.next( );
				while( !myList.get( sorting ).setName( temp ) )
					temp = in.next( );
			}

			else if( temp.equalsIgnoreCase("B") ) {
				System.out.println("請輸入新的生日：");
				temp = in.next( );
				while( !myList.get( sorting ).setBirthday( temp ) )
					temp = in.next( );
			}

			else if( temp.equalsIgnoreCase("C") ) {
				System.out.println("請輸入新的手機號碼：");
				temp = in.next( );
				while( !myList.get( sorting ).setNumber( temp ) )
					temp = in.next( );
			}
    
                       else if( temp.equalsIgnoreCase("D") ) {
				System.out.println("請輸入新的E-mail：");
				temp = in.next( );
				while( !myList.get( sorting ).setMail( temp ) )
					temp = in.next( );
			}

		       else if( temp.equalsIgnoreCase("E") ) {
				System.out.println("請輸入新的分類：");
				temp = in.next( );
				while( !myList.get( sorting ).setType( temp ) )
					temp = in.next( );
			}

			else {
				System.out.println("錯誤，請輸入想要修改的欄位：");
				System.out.println("A.姓名　　　　　　　　B.生日　　　　　　　　C.電話號碼");
		                System.out.println("D.E-mail　　　　　　　　E.分類");
                                temp = in.next();
			}

			display_all_title( );
			System.out.printf( " %-5d", sorting+1 );
			display_all_elements( sorting );
			System.out.print("\n修改成功!");
			print_enter( );
			break;
		}
		user( );
	}

	user( );
    }
  public void store_book( )  //儲存通訊錄資料到記事本
  {
	PrintWriter storeBook = null;
	try
	{
		storeBook = new PrintWriter( new FileOutputStream("book.txt") );
	}
	catch(FileNotFoundException e)
	{
		System.out.println("找不到檔案或檔案無法打開");
		System.exit(0);
	}

	storeBook.println( "姓名    生日          手機號碼      分類       E-mail           " );
	storeBook.println( "----------------------------------------------------------------" );
	for( int i = 0 ; i < myList.size( ) ; i++ ) {
		storeBook.printf( "%-6s", myList.get( i ).getName() );
		storeBook.printf( "%-14s", myList.get( i ).getBirthday() );
		storeBook.printf( "%-14s", myList.get( i ).getNumber() );
		storeBook.printf( "%-9s", myList.get( i ).getType() );
		storeBook.printf( "%-21s", myList.get( i ).getMail() );
		storeBook.println( );
	}

	storeBook.close( );
     }
public void display_all( )  //顯示所有分類
   {
	System.out.println("請選擇...");
        System.out.println("A.顯示所有資料　   　B.上一頁");
        boolean over =false ;
        int count = 0 ;
	temp = in.next();
	while( true ) {
		if( temp.equalsIgnoreCase("A") ) {
			System.out.println( );
			display_title( );
			for( int i = 0 ; i < myList.size( )&&!over ; i++ ){
				display_elements( i );
                                count++;
                                if(count%page==0&&count<myList.size()){
                                  System.out.println("A.下一頁　　　B.離開");
			          String temp2 = in.next();
				  while(true){
		                    if(temp2.equals("a")||temp2.equals("A")||temp2.equals("B")||temp2.equals("b"))break;
			            else{
	                              System.out.println("請輸入正確之英文代號");
				      System.out.println("A.下一頁　　　B.離開");
				      temp2 = in.next();
					}
					     }
				switch(temp2){
				  case "a" :
				  case "A" :continue ;
				  case "b" :
				  case "B" :over = true ;
				   break;
					     }
                                   }
                          }
			
			System.out.println( );
			print_enter( );

			user( );
		}
		
		else if( temp.equalsIgnoreCase("B") )
			display( );
		else {
			System.out.println("錯誤，請重新選擇...");
			System.out.println("A.顯示所有資料　　　B.上一頁");
			temp = in.next();
		}
	}
   }
public void display( )  //顯示
   {
	System.out.println("請選擇顯示的方式：");
		System.out.println("A.所有分類　　　　　　B.單一分類　　　　　　C.上一頁");

	temp = in.next();
	while( true ) {
		if( temp.equalsIgnoreCase("A") )
			display_all( );
		else if( temp.equalsIgnoreCase("B") )
			display_type( );
		else if( temp.equalsIgnoreCase("C") )
			user( );
		else {
			System.out.println("錯誤，請重新選擇顯示的方式：");
			System.out.println("A.所有分類　　　　　　B.單一分類　　　　　　C.上一頁");
			temp = in.next();
		}
	}
   }
public void display_type( )  //單一分類顯示
   {
	int i;
	String type;
	boolean b = true;

	System.out.println("請選擇想要顯示的個性類別：");
	System.out.println("A.可愛　　　　　　B.有趣　　　　　　　C.生氣");
	type = in.next( );
	while( b )
		switch( type ) {
			case "A":
			case "a":
				type = "可愛";	b = false;	break;
			case "B":
			case "b":
				type = "有趣";	b = false;	break;
			case "C":
			case "c":
				type = "生氣";	b = false;	break;
			default:
				System.out.println("錯誤，請重新選擇想要顯示的個性類別：");
				System.out.println("A.可愛　　　　　　B.有趣　　　　　　　C.生氣");
                                type = in.next( );
		}

	temp_list.clear( );
	for( i = 0 ; i < myList.size( ) ; i++ ) {
		if( type.equalsIgnoreCase( myList.get( i ).getType( ) ) )
			temp_list.add( myList.get( i ) );
	}
	if( temp_list.size( ) == 0 ) {

		System.out.println( "沒有此個性類別的人!" );
		System.out.println( );
		print_enter( );
		display_type( );
	}

	System.out.println("請選擇...");
	System.out.println("A.顯示所有此分類資料     B.上一頁");

	temp = in.next();
	while( true ) {
		if( temp.equalsIgnoreCase("A") ) {
			System.out.println( );
			display_title( );
			for( i = 0 ; i < myList.size( ) ; i++ ) {
				if( type.equalsIgnoreCase( myList.get( i ).getType( ) ) )
						display_elements( i );
		        }
			System.out.println( );
			print_enter( );

			user( );
		}
		else if( temp.equalsIgnoreCase("B") )
			display( );
		else {
			System.out.println("錯誤，請重新選擇...");
			System.out.println("A.顯示所有此分類資料     B.上一頁");
			temp = in.next();
		}
	}
    }
public void display_set( )  //管理者可以設定哪些欄位要顯示
{
	System.out.println("請選擇各欄位是否要顯示出來(輸入Y/N)：");

        System.out.print("序列：");
	temp = in.next( );
	while( true )
		if( temp.substring( 0, 1 ).equalsIgnoreCase( "Y" ) ) {
			Sorting = true;
			break;
		}
		else if( temp.substring( 0, 1 ).equalsIgnoreCase( "N" ) ) {
			Sorting = false;
			break;
		}
		else {
			System.out.print("錯誤，請重新輸入：");
			temp = in.next( );
		} 
		
	System.out.print("姓名：");
 	temp = in.next( );
	while( true )
	        if( temp.substring( 0, 1 ).equalsIgnoreCase( "Y" ) ) {
		 	Name = true;
			break;
		}
		else if( temp.substring( 0, 1 ).equalsIgnoreCase( "N" ) ) {
			Name = false;
			break;
		}
		else {
			System.out.print("錯誤，請重新輸入：");
			temp = in.next( );
		}

	System.out.print("生日：");
	temp = in.next( );
	while( true )
		if( temp.substring( 0, 1 ).equalsIgnoreCase( "Y" ) ) {
			Birthday = true;
			break;
		}
		else if( temp.substring( 0, 1 ).equalsIgnoreCase( "N" ) ) {
			Birthday = false;
			break;
		}
		else {
			System.out.print("錯誤，請重新輸入：");
			temp = in.next( );
		}

	System.out.print("電話號碼：");
	temp = in.next( );
	while( true )
		if( temp.substring( 0, 1 ).equalsIgnoreCase( "Y" ) ) {
			Number = true;
			break;
		}
		else if( temp.substring( 0, 1 ).equalsIgnoreCase( "N" ) ) {
			Number = false;
			break;
		}
		else {
			System.out.print("錯誤，請重新輸入：");
			temp = in.next( );
		}

	System.out.print("分類：");
	temp = in.next( );
	while( true )
		if( temp.substring( 0, 1 ).equalsIgnoreCase( "Y" ) ) {
			Type = true;
			break;
		}
		else if( temp.substring( 0, 1 ).equalsIgnoreCase( "N" ) ) {
			Type = false;
			break;
		}
		else {
			System.out.print("錯誤，請重新輸入：");
			temp = in.next( );
		}

	System.out.print("E-mail");
	temp = in.next( );
	while( true )
		if( temp.substring( 0, 1 ).equalsIgnoreCase( "Y" ) ) {
			Mail = true;
			break;
		}
		else if( temp.substring( 0, 1 ).equalsIgnoreCase( "N" ) ) {
			Mail = false;
			break;
		}
		else {
			System.out.print("錯誤，請重新輸入：");
			temp = in.next( );
		}
             
	System.out.print("\n設定顯示完成!");
	print_enter( );
	administrator( );
    }
public void print_enter( )  //暫停畫面
{
	System.out.print("按Enter鍵回到主選單");
	try
	{
         	System.in.read();
	}
	catch(Exception e) {}
 }
public void display_title( )   //控制標題的顯示
{
	int s = 0;

	if( Sorting ) {
		System.out.printf( "序列  " );
		s += 8;
	}
	if( Name ) {
		System.out.printf( "姓名    " );
		s += 8;
	}
	if( Birthday ) {
		System.out.printf( "生日          " );
		s += 14;
	}
	if( Number ) {
		System.out.printf( "手機號碼      " );
		s += 14;
	}
	if( Type ) {
		System.out.printf( "分類       " );
		s += 11;
	}
	if( Mail ) {
		System.out.printf( "E-mail               " );
		s += 21;
	}
	System.out.println( );

	for( ; s > 0 ; s-- )
		System.out.print( "-" );
	System.out.println( );
  }
public void display_all_title( )  //顯示所有欄位
{
        System.out.printf("序列 " );
	System.out.printf("姓名    " );
	System.out.printf("生日        " );
	System.out.printf("手機號碼      " );
	System.out.printf("分類       " );
	System.out.printf("E-mail               " );
        System.out.println();
	System.out.println( "-----------------------------------------------------------------------" );
 }
public void display_elements( int i )  //控制顯示時的欄位
{
	if( Sorting )
		System.out.printf( " %-5d", i+1 ); //序列編號
	if( Name )
		System.out.printf( "%-6s", myList.get( i ).getName() );
	if( Birthday )
		System.out.printf( "%-14s", myList.get( i ).getBirthday() );
	if( Number )
		System.out.printf( "%-14s", myList.get( i ).getNumber() );
	if( Mail )
		System.out.printf( "%-9s", myList.get( i ).getType() );
	if( Type )
		System.out.printf( "%-21s", myList.get( i ).getMail() );
	System.out.println( );
   }
public void display_all_elements( int i )  //顯示通訊錄所有欄位
{
	System.out.printf( "%-6s", myList.get( i ).getName() );
	System.out.printf( "%-14s", myList.get( i ).getBirthday());
	System.out.printf( "%-14s", myList.get( i ).getNumber() );
	System.out.printf( "%-9s", myList.get( i ).getType() );
	System.out.printf( "%-21s", myList.get( i ).getMail() );
	System.out.println( );
   }
public  void setpage() //顯示分頁資料
{
		System.out.println("請輸入每頁欲顯示之筆數(1~128)，輸入0回上一頁:");
		int temp = in.nextInt();
		if(temp>0&&temp<=128)
			page = temp ;
		else if(temp==0)
			user( );
		else
			System.out.println("請輸入範圍內的數字");
      }
public void time() //顯示電腦目前的時間
{   
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//定義時間格式
      Date dt=new Date();//使用java.util.Date取得現在時間
      //透過SimpleDateFormat的format方法將Date轉為字串
      String newdt=sdf.format(dt);
      System.out.println("現在時間:"+newdt);
 }
}