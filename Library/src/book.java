

public class book
{
	private String Borrower;
	private String Subject;
    private String Author;
    private Boolean Condition;
    private int ID;

    
    //作者
    public void setAuthor(String Author)
    {
    	
    	this.Author= Author;
    }
    public String getAuthor()
    {
    	
        return Author;
    }
    //主題
    public void setSubject(String Subject)
    {
    	
    	this.Subject= Subject;
    }
    public String getSubject()
    {
    	
        return Subject;
    }
    //借閱狀態
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
    //借閱人
    public void setBorrower(String borrower)
    {
    	
    	Borrower= borrower;
    }
    public String getBorrower()
    {
    	
        return Borrower;
    }
    //判定兩書是否相等
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
    //初始化
    
    book(String author, String subject, int Id)
    {
        Author= author;
     
        Subject= subject;
    
        Condition= true;
     
        
        this.ID= Id;
      
        Borrower= "Nothing";
    }
    //內容查詢(書)
    book(book Book)
    {
       
    	Author= Book.getAuthor();
      
    	Subject= Book.getSubject();
      
        Condition= Book.getStatus();
      
        
        this.ID= Book.getId();
     
        Borrower= Book.getBorrower();
    }
}