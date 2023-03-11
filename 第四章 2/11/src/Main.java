import java.util.Scanner;




public class Main {

	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		Student student1=new Student();
		Student student2=new Student(sc.nextInt());
		Student student3=new Student(sc.next());
		Student student4=new Student(sc.nextInt(),sc.nextInt(),sc.next(),sc.next());
		
		System.out.println("Student1 use constroctor(1):age="+student1.age+" grade="+student1.grade+" name="+student1.name+" id="+student1.id);
		System.out.println("Student2 use constroctor(2):age="+student2.age+" grade="+student2.grade+" name="+student2.name+" id="+student2.id);
		System.out.println("Student3 use constroctor(3):age="+student3.age+" grade="+student3.grade+" name="+student3.name+" id="+student3.id);
		System.out.println("Student4 use constroctor(4):age="+student4.age+" grade="+student4.grade+" name="+student4.name+" id="+student4.id);
	}

}
