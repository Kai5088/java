public class book
{
    private String author;
    private String subject;
    private Boolean status; //available for true
    private int id;
    private String whoBorrowed;

    book(String aut, String sub, int id)
    {
        author= aut;
        subject= sub;
        status= true;
        this.id= id;
        whoBorrowed= "Nothing";
    }
    book(book B)
    {
        author= B.getAuthor();
        subject= B.getSubject();
        status= B.getStatus();
        this.id= B.getId();
        whoBorrowed= B.getBorrower();
    }

    public Boolean equals(book B)
    {
        if(author== B.getAuthor()&&
        subject== B.getSubject()&&
        status== B.getStatus()&&
        this.id== B.getId()&&
        whoBorrowed== B.getBorrower())
        return true;
        else return false;
    }

    public void setAuthor(String aut)
    {
        author= aut;
    }
    public String getAuthor()
    {
        return author;
    }

    public void setSubject(String sub)
    {
        subject= sub;
    }
    public String getSubject()
    {
        return subject;
    }

    public void setStatus(Boolean sta)
    {
        status= sta;
    }
    public Boolean getStatus()
    {
        return status;
    }

    public void setId(int newId)
    {
        id= newId;
    }
    public int getId()
    {
        return id;
    }

    public void setBorrower(String name)
    {
        whoBorrowed= name;
    }
    public String getBorrower()
    {
        return whoBorrowed;
    }
}