import java.util.*;
public class user {
	private String type;
	private String name;
	private int limit;

	public user(String type, String name)
	{
		if(type.equals("Borrower"))
		{
			System.out.println("Wrong format when adding user.");
			return;
		}
		setType(type);
		setName(name);
	}

	public user(String type, String name, int limit)
	{
		if(type.equals("Staff")&&limit!=0)
		{
			System.out.println("Wrong format when adding user.");
			return;
		}
		setType(type);
		setName(name);
		setLimit(limit);
	}

	public void setLimit(int lim)
	{
		limit= lim;
	}
	public int getLimit()
	{
		return limit;
	}

	public void setType(String typ)
	{
		this.type = typ;
	}
	public String getType()
	{
		return this.type;
	}

	public void setName(String nam)
	{
		this.name = nam;
	}
	public String getName()
	{
		return this.name;
	}

	public void listAuthor(String aut,ArrayList<book> a)
	{
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i).getAuthor().equalsIgnoreCase(aut))
			{
				System.out.println("ID:"+a.get(i).getId()+
									" Author:"+a.get(i).getAuthor()+
									" Subject:"+a.get(i).getSubject());
			}
		}
	}
	public void listSubject(String sub,ArrayList<book> a)
	{
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i).getSubject().equalsIgnoreCase(sub))
			{
				System.out.println("ID:"+a.get(i).getId()+
						" Author:"+a.get(i).getAuthor()+
						" Subject:"+a.get(i).getSubject());
			}
		}
	}
	public ArrayList<book> addBook(book Book, ArrayList<book> a)
    {
        //int id = 1;//id in main or other way
        book temp = new book(Book.getAuthor(), Book.getSubject(), Book.getId());
		
		if(type.equals("Staff"))
        	a.add(temp);
		else
			System.out.println("Not staff.");

		return a;
    }

    public ArrayList<book> removeBook(int id, ArrayList<book> a)
    {
		if(!type.equals("Staff"))
		{
			System.out.println("Not staff.");
			return a;
		}

        for(int i=0; i<a.size();i++)
        {
            if(a.get(i).getId() == id)
                a.remove(i);break;
        }

		return a;
    }

    public ArrayList<book> checkout(user user2, ArrayList<Integer> id, ArrayList<book> a)
    {
		//borrower can't check out the books
		if(!type.equals("Staff"))
		{
			System.out.println("Not staff.");
			return a;
		}
        //if amount of books more than predefined borrow book number
        if(id.size() > user2.limit){
            System.out.println("Can not check out since the number of books exceed the limitation of user can check-out");
            return a;
        }
        //check whether the book is checked out and set the status false
        for(int i : id)
        {
            for(book s : a)
            {
                if(s.getId() == id.get(i)){
                    if(!s.getStatus())
                    {
                        System.out.println(i + " " + s.getAuthor() + " " + s.getSubject() + "is already checked out");
                        break;
                    }
                    else
					{
                        s.setStatus(false);
						s.setBorrower(user2.getName());
						user2.setLimit(user2.getLimit()-1);
                    }
                }        
            }
        }
		return a;
    }

    public ArrayList<book> returnBook(int id, ArrayList<book> a)
    {
        for(book s : a)
            {
                if(s.getId() == id)
                {
                    if(s.getStatus())
                    {
                        System.out.println("Can not return since the book isn't checked out ");
						return a;
                    }
                    else
                    {
						s.setStatus(true);
						s.setBorrower("Nothing");
                    }
                }
            }
		return a;
    }

    public void findChecked(user user2, ArrayList<book> a)
    {
		boolean flag = false;//check whether there is any book whose last borrower is user2

		//user1 = user2, both of them are borrower
        if(type.equals("Borrower") && name.equals(user2.getName()))
		{
			for(book s : a)
			{
				if(s.getBorrower().equals(user2.getName()))
				{
					flag = true;
					System.out.printf("ID:"+s.getId()+
									" Author:"+s.getAuthor()+
									" Subject:"+s.getSubject());
				}
			}	
		}
		//user 1 is the staff
		else if(type.equals("Staff"))
		{
			for(book s : a)
			{
				if(s.getBorrower().equals(user2.getName()))
				{
					flag = true;
					System.out.println("ID:"+s.getId()+
									" Author:"+s.getAuthor()+
									" Subject:"+s.getSubject());
				}
			}
		}
		//(user1 != user2, both of them are borrower)
		else if(type.equals("Borrower") && user2.getType().equals("Borrower"))
		{
			System.out.println("Borrower can not find books checked out by other users");
			return;
		}
		else
		{
			System.out.println("Staff can not find books checked out by other staffs");
			return;
		}

		if(!flag)
			System.out.println("there isn't any book whose last borrower is " + user2.getName());
    }

    public void findBorrower(int id, ArrayList<book> a)
    {
		if(type.equals("Staff"))
		{
			for(book s : a)
			{
				if(s.getId() == id)
				{
					System.out.println("User: "+s.getBorrower());
				}
			}	
		}
    }
}
/*
public static void main(String[] arcs)
{
	ArrayList<String> index=listAuthor("AuthorA");
	for(String s:index)
	{
		System.out.println(s);
	}
}
*/
