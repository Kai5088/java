import java.util.*;
import java.io.*;
public class Control
{
    private static FileInputStream fileIn;
    private static int nextId;
    private static Scanner scanIn;
    public static ArrayList<book> bookList;
    public static ArrayList<user> userList;
    public static void main(String[] args)
    {
        File input= new File(args[0]);

        try
        {
            fileIn= new FileInputStream(input);
            scanIn= new Scanner(fileIn);
            
            bookInitialize();
            userInitialize();
            executeCmd();

        }
        catch(Exception e)
        {
            System.out.println("Error in main.");
            System.out.println(e.getMessage());
            System.exit(0);
        }    
    }

    private static void executeCmd()
    {
        try
        {
            while(scanIn.hasNextLine())
            {
                String cmd= scanIn.nextLine();
                StringTokenizer st= new StringTokenizer(cmd);
                
                if(st.countTokens()==2)
                {
                    String userName= st.nextToken();
                    String function= st.nextToken();
                    int index= findUser(userName);

                    if(index== -1)
                        throw new Exception("Unknown user \""+userName +"\".");
                    else if(!function.equals("addBook"))
                        throw new Exception("Unknown command \""+cmd +"\".");
                    else
                        callAddBook(index);
                }
                else if(st.countTokens()==3)
                {
                    String userName= st.nextToken();
                    String function= st.nextToken();
                    String par= st.nextToken();
                    int index1= findUser(userName);

                    if((index1==-1))
                        throw new Exception("Unknown user \""+userName+"\".");
                    else if(function.equals("removeBook"))
                        callRemoveBook(userName, par);
                    else if(function.equals("checkout"))
                        callCheckout(userName, par);
                    else if(function.equals("return"))
                        callReturn(userName, par);
                    else if(function.equals("listAuthor"))
                        callListAuthor(userName, par);
                    else if(function.equals("listSubject"))
                        callListSubject(userName, par);
                    else if(function.equals("findChecked"))
                        callFindChecked(userName, par);
                    else if(function.equals("findBorrower"))
                        callFindBorrower(userName, par);
                    else throw new Exception("Unknown command \""+cmd +"\".");
                }
                else
                {
                    throw new Exception("Unknown command \""+cmd +"\".");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error when executing command.");
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    private static void callFindBorrower(String userName, String par)
    {
        int userPos= findUser(userName);

        try
        {
            int bookId= Integer.valueOf(par);
            userList.get(userPos).findBorrower(bookId, bookList);
        }
        catch(Exception e)
        {
            System.out.println("Error when find borrower.");
            System.exit(0);
        }
    }

    private static void callFindChecked(String userName, String par)
    {
        int userPos= findUser(userName);

        try
        {
            int userPos2= findUser(par);
            userList.get(userPos).findChecked(userList.get(userPos2), bookList);
        }
        catch(Exception e)
        {
            System.out.println("Error when find checked.");
            System.exit(0);
        }
    }

    private static void callListSubject(String userName, String par)
    {
        int userPos= findUser(userName);

        try
        {
            userList.get(userPos).listSubject(par, bookList);
        }
        catch(Exception e)
        {
            System.out.println("Error when list subject.");
            System.exit(0);
        }
    }

    private static void callListAuthor(String userName, String par)
    {
        int userPos= findUser(userName);

        try
        {
            userList.get(userPos).listAuthor(par, bookList);
        }
        catch(Exception e)
        {
            System.out.println("Error when list author.");
            System.exit(0);
        }
    }

    private static void callReturn(String userName, String par)
    {
        int userPos= findUser(userName);

        try
        {
            int bookId= Integer.valueOf(par);
            String borrowerName= "";

            for(book b : bookList)
            {
                if(b.getId()== bookId)
                    borrowerName= b.getBorrower();
            }
            
            bookList= userList.get(userPos).returnBook(bookId, bookList);

            if(!borrowerName.equals("Nothing"))
            {
                int borPos= findUser(borrowerName);
                int lim= userList.get(borPos).getLimit();

                userList.get(borPos).setLimit(lim+1);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error when return.");
            System.exit(0);
        }
    }

    private static void callCheckout(String userName, String par)
    {
        int userPos= findUser(userName);
        int userPos2= findUser(par);

        try
        {
            StringTokenizer st= new StringTokenizer(scanIn.nextLine());
            ArrayList<Integer> idList= new ArrayList<Integer>();

            while(st.hasMoreTokens()) idList.add(Integer.valueOf(st.nextToken()));
            
            bookList= userList.get(userPos).checkout(userList.get(userPos2), idList, bookList);
        }
        catch(Exception e)
        {
            System.out.println("Error when checkout.");
            System.exit(0);
        }
    }

    private static void callRemoveBook(String userName, String par)
    {
        int userPos= findUser(userName);

        try
        {
            bookList= userList.get(userPos).removeBook(Integer.valueOf(par), bookList);
        }
        catch(Exception e)
        {
            System.out.println("Error when remove book.");
            System.exit(0);
        }
    }

    private static void callAddBook(int userPos)
    {
        try
        {
            StringTokenizer st= new StringTokenizer(scanIn.nextLine());
            book newBook= new book(st.nextToken(), st.nextToken(), nextId++);
            
            bookList= userList.get(userPos).addBook(newBook, bookList);
        }
        catch(Exception e)
        {
            System.out.println("Error when add book.");
            System.exit(0);
        }
    }

    private static int findUser(String name) //return index of user in list
    {
        for(int i=0;i< userList.size();i++)
        {
            if(name.equals(userList.get(i).getName()))
            {
                return i;
            }
        }
        return -1;
    }

    private static void bookInitialize()
    {
        bookList= new ArrayList<book>();
        nextId= 0;

        try
        {
            int num= Integer.valueOf(scanIn.nextLine());
            
            for(;num>0;num--)
            {
                StringTokenizer st= new StringTokenizer(scanIn.nextLine());
                bookList.add(new book(st.nextToken(), st.nextToken(), nextId++));
            }
        }
        catch(Exception e)
        {
            System.out.println("Error when book initialize.");
            System.exit(0);
        }
    }

    private static void userInitialize()
    {
        userList= new ArrayList<user>();
        try
        {
            int num= Integer.valueOf(scanIn.nextLine());
            
            for(;num>0;num--)
            {
                StringTokenizer st= new StringTokenizer(scanIn.nextLine());
                if(st.countTokens()==2)
                    userList.add(new user(st.nextToken(), st.nextToken()));
                else if(st.countTokens()==3)
                    userList.add(new user(st.nextToken(), st.nextToken(), Integer.valueOf(st.nextToken())));
            }
        }
        catch(Exception e)
        {
            System.out.println("Error when user initialize.");
            System.exit(0);
        }
    }
}
