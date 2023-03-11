import java.util.*;
public class Control {
	public int maxborrow;
	public String name;
	public String identity;
	//�ɮѼƤW��
	public void setMax(int max)
	{
		maxborrow= max;
	}
	public int getMax()
	{
		
		return maxborrow;
	}
	
	
	
	
	public void setName(String nam)
	{
		
		this.name = nam;
	}
	public String getName()
	{
		
		return this.name;
	}
	
	
	
	
	public void setIdentity(String iden)
	{
		
		this.identity = iden;
	}
	public String getIdentity()
	{
		
		return this.identity;
	}
	
	
	
	//�]�m�ɾ\�H
	public Control(String iden, String name)
	{
		if(iden.equals("Borrower"))
		{
			System.out.println("Error! Wrong format for adding borrower.");
			
			return;
		}
		
		setIdentity(iden);
		
		setName(name);
	}
	//�]�m���u
	public Control(String iden, String name, int mxborrow)
	{
		if(iden.equals("Staff")&&mxborrow!=0)
		{
			System.out.println("Error! Wrong format for adding staff.");
			return;
		}
		
		setIdentity(iden);
		
		setName(name);
		
		
		setMax(mxborrow);
	}
	
	
	
	//�C�X�ŦX�@�̤��ѥ��Ψ䤺�e
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
	
	
	
	
	//�C�X�ŦX�D�D���ѥ��Ψ䤺�e
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
	
	
	
	//����s�W��
	public ArrayList<book> addBook(book Book, ArrayList<book> a)
    {
        book temp = new book(Book.getAuthor(), Book.getSubject(), Book.getId());
		
		if(identity.equals("Staff"))
        	a.add(temp);
		else
			System.out.println("Borrower can not add book.");

		return a;
    }
	
	
	
	//���沾����
    public ArrayList<book> removeBook(int id, ArrayList<book> a)
    {
		if(!identity.equals("Staff"))
		{
			System.out.println("Borrower can not remove book.");
			return a;
		}

        for(int i=0; i<a.size(); i++)
        {
            if(a.get(i).getId() == id)
                a.remove(i);break;
        }

		return a;
    }
    
    
    
    //����ɮ�
    public ArrayList<book> checkout(Control user2, ArrayList<Integer> id, ArrayList<book> a)
    {
		if(!identity.equals("Staff"))
		{
			System.out.println("Borrower can not check out the books.");
			
			return a;
		}
		
        //�Y�W�L�ɮѤW��
        if(id.size() > user2.maxborrow){
            
        	System.out.println("Can not check out since the number of books exceed the limitation of user can check-out");
            
        	return a;
        }
        //�ˬd�ѬO�_�w�Q�ɥX�ó]�mfalse
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
						user2.setMax(user2.getMax()-1);
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
    //��X�ɾ\�H
    public void findChecked(Control user2, ArrayList<book> a)
    {
		
    	boolean flag = false;//�ˬd�Ѫ��̫�ɾ\�H�O�_�� user2

        
    	if(identity.equals("Borrower") && name.equals(user2.getName()))	//��̬Ҭ��ɮѤH
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
		else if(identity.equals("Staff"))	//user1 �����u
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
    	
		else if(identity.equals("Borrower") && user2.getIdentity().equals("Borrower"))	//user1 != user2,�B��̬Ҭ��ɮѤH
		{
			
			System.out.println("Borrower can not find books checked out by other users.");
			
			return;
		}
		else
		{
			
			System.out.println("Staff can not find books checked out by other staffs.");
			
			return;
		}

		if(!flag)
			System.out.println("there isn't any book whose last borrower is " + user2.getName());
    }
    //��X�ɮѤH
    public void findBorrower(int id, ArrayList<book> a)
    {
		if(identity.equals("Staff"))	//only���u�i�d��
		{
			for(book s : a)
			{
				if(s.getId() == id)
				{
					System.out.println("User: "+s.getBorrower());
				}
			}	
		}
		else
			System.out.println("Borrower can not find borrower");
    }
}