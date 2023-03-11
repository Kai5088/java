public class Student {
	private int age;
	private int grade;
	private String name;
	
	public Student()
	{
		age=20;  grade=1;  name="NoName";
	}
	
	public Student(int a,int b,String c) {
		age=a;
		grade=b;
		name=c;
	}
	
	public int getGrade() {
		return grade;
	}
	public boolean setGrade(int a) {
		grade=a;
		return (grade==a);
	}
	
	public int getAge() {
		return age;
	}
	public boolean setAge(int a) {
		age=a;
		return (age==a);
	}
	
	public String getName() {
		return name;
	}
	public boolean setName(String a) {
		name=a;
		return (name==a);
	}
	
	public boolean setStudent() {
		age=20;  grade=1;  name="NoName";
		return (age==20&&grade==1&&name=="NoName");
	}
	public boolean setStudent(int a) {
		grade=a;
		return(grade==a);
	}
	public boolean setStudent(int a,int b,String c) {
		age=a; grade=b; name=c;
		return(age==a&&grade==b&&name==c);
	}
}