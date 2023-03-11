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
public void login()  //�n�J�t��
{
	String account = null, password = null;
	
		System.out.print( "�п�J�b���G" );
		account = in.next();
		System.out.print( "�п�J�K�X�G" );
		password = in.next();
		int a,b;
		b=(int)(Math.random()*1000);
		System.out.println("���ҽX:"+b);
		while(in.hasNextInt())
		{
		a=in.nextInt();
			if(a==b)
			break;
			else
			System.out.println("�ЬݲM�����J");
		}

		if( account.equals("cis") && password.equals("1234") )
			System.out.println( "�n�J���\!" );
                else if( account.equals(password))
			System.out.println( "�n�J���\!" );
		else
			System.out.printf( "�b���αK�X���~�A�Э��s��J!\n\n" );
	
 }
public void library()  //Ūlibrary��r��
{
    Scanner sc = null;
     try  
     {
       sc = new Scanner(new FileInputStream("library.txt"));
     }
     catch(FileNotFoundException e)
     {
      System.out.println("�ɮפ��s�b�ηl��");
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
public void welcome( )  // �D���
{
     System.out.println("\n�п�J�Q�n����\�઺�N�X�G");
     System.out.println("A:�޲z�̥\��@�@�@�@�@�@B:�ϥΪ̥\��@�@�@�@�@C:�����{��");

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
			System.out.println( "�]��ܵ����ҥH�t������" );
			System.exit( 0 );
		}
		else 
		{
			System.out.println("���~!�Э��s��J�N�X�G");
			temp = in.next();
		}
	}
 }
public void administrator()  //�޲z�̥\�઺���
{
	System.out.println("\n�п�J�Q�n����\�઺�N�X�G");
	System.out.println("A.�]�w��ܪ����@B.�]�w�C������  C.�W�@��");

	temp = in.next();
	while( true ) {
		if( temp.equalsIgnoreCase("A") )
			display_set( );
                else if( temp.equalsIgnoreCase("B") ){
                        setpage();
                        System.out.println( "�]�w����!!!" );
                        administrator();}
		else if( temp.equalsIgnoreCase("C") )
			welcome( );
		else {
			System.out.println("���~!�Э��s��J�Q�n����\�઺�N�X�G");
			System.out.println("A.�]�w��ܪ����  B.�]�w�C������  C.�W�@��");
			temp = in.next();
		}
	}
    }
public void user()  //�ϥΪ̥\����
{
	System.out.println("�п�J�Q�n����\�઺�N�X�G");
	System.out.println("A.�s�W�@�@�@�@�@�@�@�@B.�d�ߡ@�@�@�@�@�@�@�@C.�ק�");
	System.out.println("D.�R���@�@�@�@�@�@�@�@E.��ܡ@�@�@�@�@�@�@�@F.�s��");
	System.out.println("G.��^�W�@��");

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
			System.out.print( "\n�s�ɦ��\" );
			print_enter();
			welcome();
		}
                else if( temp.equalsIgnoreCase("G") )
                        welcome();
		
		else 
		{
			System.out.println("���~�A�Э��s����G");
			System.out.println("A.�s�W�@�@�@�@�@�@�@�@B.�d�ߡ@�@�@�@�@�@�@�@C.�ק�");
			System.out.println("D.�R���@�@�@�@�@�@�@�@E.��ܡ@�@�@�@�@�@�@�@F.�s��");
			System.out.println("G.��^�W�@��");
			temp = in.next();
		}
	}
 }
public void add_book()   //�s�W�q�T��
{
	data = new library();

	System.out.println("�п�J�m�W�G");
	temp = in.next();
	while( data.setName( temp )==false )
		temp = in.next();

	System.out.println("�п�J�ͤ�G");
	temp = in.next();
	while( data.setBirthday(temp )==false )
		temp = in.next();

	System.out.println("�п�J������X�G");
	temp = in.next();
	while( data.setNumber(temp )==false )
		temp = in.next();

        System.out.println("�п�J�����G");
	temp = in.next();
	while( data.setType( temp )==false )
		temp = in.next();

	System.out.println("�п�JE-mail�G");
	temp = in.next();
	while( data.setMail( temp )==false )
		temp = in.next();

	myList.add( data );

	System.out.println();
	display_all_title();
	System.out.printf( " %-5d", myList.size() );
	display_all_elements( myList.size() - 1 );
	System.out.print("\n�s�W���\");
	print_enter();
	user();
 }
public void delete_book( )   //�R���q�T��
{
	System.out.println("�п�J�n�R�����q�T���ǦC(��J0�h�^��W�@��)�G");

	int sorting = in.nextInt( );
	while( sorting > 0 ) {
		if( sorting > myList.size( ) ) {
			System.out.println("�Э��s��J�Q�n�R�������y�ǦC(��J0�h�^��W�@��)�G");
			sorting =in.nextInt( );
			continue;
		}

		display_all_title( );
		System.out.printf( " %-5d", sorting );
		display_all_elements( --sorting );
		myList.remove( sorting );

		System.out.print("\n�R��OK!");
		print_enter( );
		break;
	}

	user( );
     }
public void search_book( )  //�d�߳q�T��
  {
	int s = 0;

	System.out.println("�п�J�n�d�ߪ����G");
	System.out.println("A.�m�W�@�@�@�@�@�@�@�@B.������X�@�@�@�@�@�@C.�W�@��");

	temp = in.next();
	while( true ) {
		if( temp.equalsIgnoreCase("A") ) {
		        s = 0;
		        System.out.println("�п�J�n�d�ߪ��m�W�G");
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
				System.out.println( "���s�b" );

			System.out.println( );
			print_enter( );

			user( );
		}

		else if( temp.equalsIgnoreCase("B") ) {
			s = 0;
			System.out.println("�п�J�n�d�ߪ�������X�G");
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
				System.out.println( "���s�b" );

			System.out.println( );
			print_enter( );

			user( );
		}

		else if ( temp.equalsIgnoreCase("C") )
			user( );

		else {
			System.out.println("���~�A�Э��s����G");
			System.out.println("A.�m�W�@�@�@�@�@�@�@�@B.������X�@�@�@�@�@�@C.�W�@��");
			temp = in.next();
		}
	} 
    }
  public void edit_book( )  //�ק�q�T��
  {
	System.out.println("�п�J�Q�n�ק諸�q�T���ǦC(��J0�h�^��W�@��)�G");

	int sorting = in.nextInt( );
	while( sorting > 0 ) {
		if( sorting > myList.size( ) ) {
			System.out.println("�Э��s��J�Q�n�ק諸�q�T���ǦC(��J0�h�^��W�@��)�G");
			sorting = in.nextInt( );
			continue;
		}
		sorting--;

		System.out.println( "�Q�n�ק諸�q�T����ơG" );
		display_all_elements( sorting );

		System.out.println("�п�ܷQ�n�ק諸���G");
		System.out.println("A.�m�W�@�@�@�@�@�@�@�@B.�ͤ�@�@�@�@�@�@�@�@C.������X");
		System.out.println("D.�����@�@�@�@�@�@�@�@E.E-mail");

		temp = in.next();
		while( true ) {
			if( temp.equalsIgnoreCase("A") ) {
				System.out.println("�п�J�s���m�W�G");
				temp = in.next( );
				while( !myList.get( sorting ).setName( temp ) )
					temp = in.next( );
			}

			else if( temp.equalsIgnoreCase("B") ) {
				System.out.println("�п�J�s���ͤ�G");
				temp = in.next( );
				while( !myList.get( sorting ).setBirthday( temp ) )
					temp = in.next( );
			}

			else if( temp.equalsIgnoreCase("C") ) {
				System.out.println("�п�J�s��������X�G");
				temp = in.next( );
				while( !myList.get( sorting ).setNumber( temp ) )
					temp = in.next( );
			}
    
                       else if( temp.equalsIgnoreCase("D") ) {
				System.out.println("�п�J�s��E-mail�G");
				temp = in.next( );
				while( !myList.get( sorting ).setMail( temp ) )
					temp = in.next( );
			}

		       else if( temp.equalsIgnoreCase("E") ) {
				System.out.println("�п�J�s�������G");
				temp = in.next( );
				while( !myList.get( sorting ).setType( temp ) )
					temp = in.next( );
			}

			else {
				System.out.println("���~�A�п�J�Q�n�ק諸���G");
				System.out.println("A.�m�W�@�@�@�@�@�@�@�@B.�ͤ�@�@�@�@�@�@�@�@C.�q�ܸ��X");
		                System.out.println("D.E-mail�@�@�@�@�@�@�@�@E.����");
                                temp = in.next();
			}

			display_all_title( );
			System.out.printf( " %-5d", sorting+1 );
			display_all_elements( sorting );
			System.out.print("\n�ק令�\!");
			print_enter( );
			break;
		}
		user( );
	}

	user( );
    }
  public void store_book( )  //�x�s�q�T����ƨ�O�ƥ�
  {
	PrintWriter storeBook = null;
	try
	{
		storeBook = new PrintWriter( new FileOutputStream("book.txt") );
	}
	catch(FileNotFoundException e)
	{
		System.out.println("�䤣���ɮש��ɮ׵L�k���}");
		System.exit(0);
	}

	storeBook.println( "�m�W    �ͤ�          ������X      ����       E-mail           " );
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
public void display_all( )  //��ܩҦ�����
   {
	System.out.println("�п��...");
        System.out.println("A.��ܩҦ���ơ@   �@B.�W�@��");
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
                                  System.out.println("A.�U�@���@�@�@B.���}");
			          String temp2 = in.next();
				  while(true){
		                    if(temp2.equals("a")||temp2.equals("A")||temp2.equals("B")||temp2.equals("b"))break;
			            else{
	                              System.out.println("�п�J���T���^��N��");
				      System.out.println("A.�U�@���@�@�@B.���}");
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
			System.out.println("���~�A�Э��s���...");
			System.out.println("A.��ܩҦ���ơ@�@�@B.�W�@��");
			temp = in.next();
		}
	}
   }
public void display( )  //���
   {
	System.out.println("�п����ܪ��覡�G");
		System.out.println("A.�Ҧ������@�@�@�@�@�@B.��@�����@�@�@�@�@�@C.�W�@��");

	temp = in.next();
	while( true ) {
		if( temp.equalsIgnoreCase("A") )
			display_all( );
		else if( temp.equalsIgnoreCase("B") )
			display_type( );
		else if( temp.equalsIgnoreCase("C") )
			user( );
		else {
			System.out.println("���~�A�Э��s�����ܪ��覡�G");
			System.out.println("A.�Ҧ������@�@�@�@�@�@B.��@�����@�@�@�@�@�@C.�W�@��");
			temp = in.next();
		}
	}
   }
public void display_type( )  //��@�������
   {
	int i;
	String type;
	boolean b = true;

	System.out.println("�п�ܷQ�n��ܪ��ө����O�G");
	System.out.println("A.�i�R�@�@�@�@�@�@B.����@�@�@�@�@�@�@C.�ͮ�");
	type = in.next( );
	while( b )
		switch( type ) {
			case "A":
			case "a":
				type = "�i�R";	b = false;	break;
			case "B":
			case "b":
				type = "����";	b = false;	break;
			case "C":
			case "c":
				type = "�ͮ�";	b = false;	break;
			default:
				System.out.println("���~�A�Э��s��ܷQ�n��ܪ��ө����O�G");
				System.out.println("A.�i�R�@�@�@�@�@�@B.����@�@�@�@�@�@�@C.�ͮ�");
                                type = in.next( );
		}

	temp_list.clear( );
	for( i = 0 ; i < myList.size( ) ; i++ ) {
		if( type.equalsIgnoreCase( myList.get( i ).getType( ) ) )
			temp_list.add( myList.get( i ) );
	}
	if( temp_list.size( ) == 0 ) {

		System.out.println( "�S�����ө����O���H!" );
		System.out.println( );
		print_enter( );
		display_type( );
	}

	System.out.println("�п��...");
	System.out.println("A.��ܩҦ����������     B.�W�@��");

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
			System.out.println("���~�A�Э��s���...");
			System.out.println("A.��ܩҦ����������     B.�W�@��");
			temp = in.next();
		}
	}
    }
public void display_set( )  //�޲z�̥i�H�]�w�������n���
{
	System.out.println("�п�ܦU���O�_�n��ܥX��(��JY/N)�G");

        System.out.print("�ǦC�G");
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
			System.out.print("���~�A�Э��s��J�G");
			temp = in.next( );
		} 
		
	System.out.print("�m�W�G");
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
			System.out.print("���~�A�Э��s��J�G");
			temp = in.next( );
		}

	System.out.print("�ͤ�G");
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
			System.out.print("���~�A�Э��s��J�G");
			temp = in.next( );
		}

	System.out.print("�q�ܸ��X�G");
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
			System.out.print("���~�A�Э��s��J�G");
			temp = in.next( );
		}

	System.out.print("�����G");
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
			System.out.print("���~�A�Э��s��J�G");
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
			System.out.print("���~�A�Э��s��J�G");
			temp = in.next( );
		}
             
	System.out.print("\n�]�w��ܧ���!");
	print_enter( );
	administrator( );
    }
public void print_enter( )  //�Ȱ��e��
{
	System.out.print("��Enter��^��D���");
	try
	{
         	System.in.read();
	}
	catch(Exception e) {}
 }
public void display_title( )   //������D�����
{
	int s = 0;

	if( Sorting ) {
		System.out.printf( "�ǦC  " );
		s += 8;
	}
	if( Name ) {
		System.out.printf( "�m�W    " );
		s += 8;
	}
	if( Birthday ) {
		System.out.printf( "�ͤ�          " );
		s += 14;
	}
	if( Number ) {
		System.out.printf( "������X      " );
		s += 14;
	}
	if( Type ) {
		System.out.printf( "����       " );
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
public void display_all_title( )  //��ܩҦ����
{
        System.out.printf("�ǦC " );
	System.out.printf("�m�W    " );
	System.out.printf("�ͤ�        " );
	System.out.printf("������X      " );
	System.out.printf("����       " );
	System.out.printf("E-mail               " );
        System.out.println();
	System.out.println( "-----------------------------------------------------------------------" );
 }
public void display_elements( int i )  //������ܮɪ����
{
	if( Sorting )
		System.out.printf( " %-5d", i+1 ); //�ǦC�s��
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
public void display_all_elements( int i )  //��ܳq�T���Ҧ����
{
	System.out.printf( "%-6s", myList.get( i ).getName() );
	System.out.printf( "%-14s", myList.get( i ).getBirthday());
	System.out.printf( "%-14s", myList.get( i ).getNumber() );
	System.out.printf( "%-9s", myList.get( i ).getType() );
	System.out.printf( "%-21s", myList.get( i ).getMail() );
	System.out.println( );
   }
public  void setpage() //��ܤ������
{
		System.out.println("�п�J�C������ܤ�����(1~128)�A��J0�^�W�@��:");
		int temp = in.nextInt();
		if(temp>0&&temp<=128)
			page = temp ;
		else if(temp==0)
			user( );
		else
			System.out.println("�п�J�d�򤺪��Ʀr");
      }
public void time() //��ܹq���ثe���ɶ�
{   
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//�w�q�ɶ��榡
      Date dt=new Date();//�ϥ�java.util.Date���o�{�b�ɶ�
      //�z�LSimpleDateFormat��format��k�NDate�ର�r��
      String newdt=sdf.format(dt);
      System.out.println("�{�b�ɶ�:"+newdt);
 }
}