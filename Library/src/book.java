

public class book
{
	private String Borrower;
	private String Subject;
    private String Author;
    private Boolean Condition;
    private int ID;

    
    //�@��
    public void setAuthor(String Author)
    {
    	
    	this.Author= Author;
    }
    public String getAuthor()
    {
    	
        return Author;
    }
    //�D�D
    public void setSubject(String Subject)
    {
    	
    	this.Subject= Subject;
    }
    public String getSubject()
    {
    	
        return Subject;
    }
    //�ɾ\���A
    public void setStatus(Boolean Status)
    {
    	
        Condition= Status;
    }
    public Boolean getStatus()
    {
    	
        return Condition;
    }
    //ID
    public void setId(int Id)
    {
    	
        ID= Id;
    }
    public int getId()
    {
    	
        return ID;
    }
    //�ɾ\�H
    public void setBorrower(String borrower)
    {
    	
    	Borrower= borrower;
    }
    public String getBorrower()
    {
    	
        return Borrower;
    }
    //�P�w��ѬO�_�۵�
    public Boolean equals(book B)
    {
    	
        if(Author== B.getAuthor()&&
        Subject== B.getSubject()&&
        Condition== B.getStatus()&&
        this.ID== B.getId()&&
        Borrower== B.getBorrower())
        
        	
        	return true;
       
        else return false;
    }
    //��l��
    
    book(String author, String subject, int Id)
    {
        Author= author;
     
        Subject= subject;
    
        Condition= true;
     
        
        this.ID= Id;
      
        Borrower= "Nothing";
    }
    //���e�d��(��)
    book(book Book)
    {
       
    	Author= Book.getAuthor();
      
    	Subject= Book.getSubject();
      
        Condition= Book.getStatus();
      
        
        this.ID= Book.getId();
     
        Borrower= Book.getBorrower();
    }
}