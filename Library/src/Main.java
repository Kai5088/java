/*�խ�:
 * ACS109151 ������
 * ACS109150 �L�ή�
 */
import java.util.*;
import java.io.*;
public class Main
{
	public static FileInputStream SystemInput;
	public static int NextID;
	public static Scanner scanner;
    public static ArrayList<book> CopyMenu;
    public static ArrayList<Control> FuntionMenu;
    public static void main(String[] args)
    {
        File Enter= new File(args[0]);

        try
        {
            SystemInput= new FileInputStream(Enter);
            
            scanner= new Scanner(SystemInput);
            
            Copybuild();
            
            
            Funtionbuild();
            
            CommandExecute();

        }
        catch(Exception e)
        {
            
        	
        	System.out.println("Main_ERROR");
           
        	System.out.println(e.getMessage());
           
        	
        	System.exit(0);
        }    
    }
  //��l�ƨϥΪ�
    public static void Funtionbuild()
    {
        FuntionMenu= new ArrayList<Control>();
        try
        {
            int Count= Integer.valueOf(scanner.nextLine());
            
            for(;Count>0;Count--)
            {
                StringTokenizer Tokens= new StringTokenizer(scanner.nextLine());
               
                
                
                if(Tokens.countTokens()==2)
                    FuntionMenu.add(new Control(Tokens.nextToken(), Tokens.nextToken()));
               
                else if(Tokens.countTokens()==3)
                    FuntionMenu.add(new Control(Tokens.nextToken(), Tokens.nextToken(), Integer.valueOf(Tokens.nextToken())));
            }
        }
        catch(Exception e)
        {
            System.out.println("USER_BUILD_WRONG");
            
            System.exit(0);
        }
    }
  //��X�ϥΪ̦�m(�Y��L�h�^��-1)
    public static int SearchUser(String InputName) //return index of user in list
    {
        for(int i=0;i< FuntionMenu.size();i++)
        {
            
        	
        	if(InputName.equals(FuntionMenu.get(i).getName()))
            {
                
        		return i;
            }
        }
        return -1;
    }

    public static void FINDBORROWER(String User, String Variable)
    {
        
    	int PO= SearchUser(User);       //�ϥΪ̦�m

        try
        {
            
        	
        	int bookId= Integer.valueOf(Variable);
            
        	FuntionMenu.get(PO).findBorrower(bookId, CopyMenu);
        }
        catch(Exception e)
        {
           
        	
        	System.out.println("CAN_NOT_FIND");
            System.exit(0);
        }
    }
    //��X�ϥΪ̤��ɮѤ��e
    public static void FINDCHECKED(String user, String Variable)
    {
        int Po= SearchUser(user);

        try
        {
            int TryPo= SearchUser(Variable);
           
            
            FuntionMenu.get(Po).findChecked(FuntionMenu.get(TryPo), CopyMenu);
        }
        catch(Exception e)
        {
            System.out.println("Error when find checked.");
            
            
            System.exit(0);
        }
    }
    //�C�X�ϥΪ̤�ɮѲM��
    public static void LISTSUBJECT(String user, String Variable)
    {
        int Po= SearchUser(user);

        
        try
        {
            
        	FuntionMenu.get(Po).listSubject(Variable, CopyMenu);
        }
        catch(Exception e)
        {
            
        	System.out.println("LIST_ERROR");
            System.exit(0);
        }
    }
    
  
    //CMD����
    public static void CommandExecute()
    {
        
    	try
        {
            
    		while(scanner.hasNextLine())
            {
                String Command= scanner.nextLine();
                
                StringTokenizer tokens= new StringTokenizer(Command);
                //�P�_2��token�����O
                if(tokens.countTokens()==2)
                {
                    
                	
                	String User= tokens.nextToken();
                    String Program= tokens.nextToken();
                    
                    
                    int index= SearchUser(User);
                    
                    if(index== -1)	//�Y�S���ۦP�ϥΪ�
                        throw new Exception("HE_IS_NOT_USER\""+User +"\".");
                    
                    else if(!Program.equals("addBook"))		//���~���O
                        throw new Exception("COMMAND_ERROR\""+Command +"\".");
                    
                    else
                        UsingBook(index);
                }
                //�P�_3��token�����O
                else if(tokens.countTokens()==3)
                {
                    String User= tokens.nextToken();
                    String Program= tokens.nextToken();
                    String Variable= tokens.nextToken();
                    int Direct= SearchUser(User);
                    
                    
                    //�P�_�O�_���ϥΪ̤Ϋ��O
                    if((Direct==-1))
                        throw new Exception("HE_IS_NOT_USER\""+User+"\".");
                    
                    else if(Program.equals("removeBook"))
                        REMOVECOPY(User, Variable);
                    
                    else if(Program.equals("checkout"))
                        CHECKOUT(User, Variable);
                    
                    else if(Program.equals("return"))
                        RETURN(User, Variable);
                    
                    else if(Program.equals("listAuthor"))
                        LISTAUTHOR(User, Variable);
                    
                    else if(Program.equals("listSubject"))
                        LISTSUBJECT(User, Variable);
                    
                    else if(Program.equals("findChecked"))
                        FINDCHECKED(User, Variable);
                    
                    else if(Program.equals("findBorrower"))
                        FINDBORROWER(User, Variable);
                    
                    else throw new Exception("COMMAND_ERROR\""+Command +"\".");
                }
                
                else
                {
                    throw new Exception("COMMAND_ERROR\""+Command +"\".");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("COMMAND_EXECUTE_ERROR");
            
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    
    //�C�X�@��
    public static void LISTAUTHOR(String user, String Variable)
    {
        
    	int Po= SearchUser(user);

        try
        {
         
        	FuntionMenu.get(Po).listAuthor(Variable, CopyMenu);
        }
        catch(Exception e)
        {
        
        	System.out.println("AUTHOR_ERROR");
            System.exit(0);
        }
    }
    
    //�ٮ�
    public static void RETURN(String user, String Variable)
    {
        int Po= SearchUser(user);

        try
        {
           
        	int CopyId= Integer.valueOf(Variable);
            String BorrowerName= "";
           
            //�ѳQ�ɪ��Ѥ�ID��X�ɮѪ�
            for(book Copy : CopyMenu)
            {
             
            	if(Copy.getId()== CopyId)
                   
            		BorrowerName= Copy.getBorrower();
            }
            
            CopyMenu= FuntionMenu.get(Po).returnBook(CopyId, CopyMenu);
            //�Y�ѩ|���ɥX
            
            if(!BorrowerName.equals("Nothing"))
            {
               
            	int Po2= SearchUser(BorrowerName);
               
            	int lim= FuntionMenu.get(Po2).getMax();

            	
                FuntionMenu.get(Po2).setMax(lim+1);
            }
        }
        catch(Exception e)
        {
            
        	System.out.println("RETURN_ERROR");
            
        	System.exit(0);
        }
    }
    //��l�Ʈ�
    
    public static void Copybuild()
    
    {
        CopyMenu= new ArrayList<book>();
        NextID= 0;

        try
        {
           
        	int Count= Integer.valueOf(scanner.nextLine());
            
            for(;Count>0;Count--)
            {
                StringTokenizer Tokens= new StringTokenizer(scanner.nextLine());
            
                CopyMenu.add(new book(Tokens.nextToken(), Tokens.nextToken(), NextID++));
            }
        }
        catch(Exception e)
        {
            System.out.println("BOOK_BUILD_WRONG");
           
            System.exit(0);
        }
    }
    //�s�W��
   
    public static void UsingBook(int USERPO)
    {
        try
        {
            StringTokenizer Tokens= new StringTokenizer(scanner.nextLine());
            book AddCopy= new book(Tokens.nextToken(), Tokens.nextToken(), NextID++);
            
            CopyMenu= FuntionMenu.get(USERPO).addBook(AddCopy, CopyMenu);
        }
        catch(Exception e)
        {
          
        	System.out.println("ADD_BOOK_ERROR");
          
        	System.exit(0);
        }
    }
  //������
    public static void REMOVECOPY(String user, String Variable)
    {
        int USERPO= SearchUser(user);

        try
        {
          
        	CopyMenu= FuntionMenu.get(USERPO).removeBook(Integer.valueOf(Variable), CopyMenu);
        }
        catch(Exception e)
        {
            System.out.println("REMOVE_BOOK_WRONG");
           
            
            System.exit(0);
        }
    }
    //�ɮ�
    public static void CHECKOUT(String user, String Variable)
    {
        int USERPO= SearchUser(user);
       
        int USERPO2= SearchUser(Variable);

        try
        {
            StringTokenizer tokens= new StringTokenizer(scanner.nextLine());
         
            
            ArrayList<Integer> IDPRINT= new ArrayList<Integer>();

            while(tokens.hasMoreTokens()) IDPRINT.add(Integer.valueOf(tokens.nextToken()));
            
            CopyMenu= FuntionMenu.get(USERPO).checkout(FuntionMenu.get(USERPO2), IDPRINT, CopyMenu);
        }
        catch(Exception e)
        {
            System.out.println("CHECKOUT_ERROR");

            System.exit(0);
        }
    }
}
