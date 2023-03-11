
public class Student {
	public int age;
	public int grade;
	public String name;
	public String id;
	public boolean setAge(int age)
	{
		this.age=age;
		return(this.age==age);
	}
	public boolean setId(String id)
	{
		this.id=id;
		return(this.id==id);
	}
	public boolean setStudent(int grade,String name,String id)
	{
		this.grade=grade;
		this.name=name;
		this.id=id;
		return(this.grade==grade && this.name==name && this.id==id);
	}
	
}
