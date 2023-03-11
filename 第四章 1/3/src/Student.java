import java.util.Scanner;




public class Student {
	private int grade;
	private String name;
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		Student student1=new Student();
		Student student2=new Student();
		student1.set();
		student2.set();
		student1.get(1,"Noname");
		student2.get(1,"Noname");
		System.out.println("student1 use getGrade and setGrade, student2 use getName and setName");
		student1.setGrade(sc.nextInt());
		student2.setName(sc.next());
		
		System.out.println("Student1:"+"grade="+student1.getGrade()+" name="+student1.getName());
		System.out.println("Student2:"+"grade="+student2.getGrade()+" name="+student2.getName());
	}
	
	public void set() {
		grade=1;
		name="Noname";
	}
	
	public void get(int grade, String name) {
		grade=getGrade();
		name=getName();
	}
	
	public boolean setGrade(int grade) {
		this.grade=grade;
		return (this.grade==grade);
	}
	public boolean setName(String name) {
		this.name=name;
		return (this.name==name);
	}
	public int getGrade() {
		return grade;
	}
	
	public String getName() {
		return name;
	}
}

    