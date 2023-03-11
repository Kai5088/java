/*組員:
 * ACS109151 楊竣凱
 * ACS109150 林裕晉
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
  //初始化使用者
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
  //找出使用者位置(若找無則回傳-1)
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
        
    	int PO= SearchUser(User);       //使用者位置

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
    //找出使用者之借書內容
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
    //列出使用者支借書清單
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
    
  
    //CMD執行
    public static void CommandExecute()
    {
        
    	try
        {
            
    		while(scanner.hasNextLine())
            {
                String Command= scanner.nextLine();
                
                StringTokenizer tokens= new StringTokenizer(Command);
                //判斷2個token的指令
                if(tokens.countTokens()==2)
                {
                    
                	
                	String User= tokens.nextToken();
                    String Program= tokens.nextToken();
                    
                    
                    int index= SearchUser(User);
                    
                    if(index== -1)	//若沒找到相同使用者
                        throw new Exception("HE_IS_NOT_USER\""+User +"\".");
                    
                    else if(!Program.equals("addBook"))		//錯誤指令
                        throw new Exception("COMMAND_ERROR\""+Command +"\".");
                    
                    else
                        UsingBook(index);
                }
                //判斷3個token的指令
                else if(tokens.countTokens()==3)
                {
                    String User= tokens.nextToken();
                    String Program= tokens.nextToken();
                    String Variable= tokens.nextToken();
                    int Direct= SearchUser(User);
                    
                    
                    //判斷是否找到使用者及指令
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
    
    //列出作者
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
    
    //還書
    public static void RETURN(String user, String Variable)
    {
        int Po= SearchUser(user);

        try
        {
           
        	int CopyId= Integer.valueOf(Variable);
            String BorrowerName= "";
           
            //由被借的書之ID找出借書者
            for(book Copy : CopyMenu)
            {
             
            	if(Copy.getId()== CopyId)
                   
            		BorrowerName= Copy.getBorrower();
            }
            
            CopyMenu= FuntionMenu.get(Po).returnBook(CopyId, CopyMenu);
            //若書尚未借出
            
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
    //初始化書
    
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
    //新增書
   
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
  //移除書
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
    //借書
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
