import java.text.*;
import java.util.Date;
public class library
{
    private String name;
    private String birthday;
    private String type;
    private String mail;
    private String number;
    

  public library()
  {
    name = null;
    birthday = null;    
    number = null;
    type = null;
    mail = null;
   }

  public library(String newName,String newBirthday,String newNumber,String newType,String newMail)
  {
    setName(newName);
    setBirthday(newBirthday);
    setNumber(newNumber);
    setType(newType);
    setMail(newMail);
   }

  public boolean setName(String newname){
   if(newname.equals(null)){
      System.out.println("請重新輸入名字:");
      return false;
      }
   else{
      name = newname;
      return true;
      }
    }

  public String getName()
   {
    return name;
   }

  public boolean setBirthday(String newbth){
  SimpleDateFormat newsdf = new SimpleDateFormat("yyyy/MM/dd");
  try{
      Date date = newsdf.parse(newbth);
      birthday = newbth;
      return true;
     } 
  catch (ParseException e){
      
      System.out.println("錯誤-請重新輸入生日:");
      return false;
     }
  
     }

  public String getBirthday()
  {
   return birthday;
  }

  public boolean setNumber(String newnumber){
   if(newnumber.substring(0,1).matches("[0]")&&newnumber.substring(1,2).matches("[9]"))
    { 
      number = newnumber;
      return true;
      }
   else{
      System.out.println("請重新輸入號碼(格式錯誤):");
      return false;
      }
    }

  public String getNumber()
   {
    return number;
   }

  public boolean setType(String newtype){
   if(newtype.equals(null)){
      System.out.println("請重新輸入分類:");
      return false;
      }
   else{
      type = newtype;
      return true;
      }
    }

  public String getType()
   {
    return type;
   }


  public boolean setMail(String newmail){ 
  if(newmail.equals(null)){
      System.out.println("請重新輸入E-mail:");
      return false;
      }
   else{
      mail = newmail;
      return true;
      }
    }

  public String getMail()
  {
   return mail;
  }

 }
