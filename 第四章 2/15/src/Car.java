public class Car{
	public int speed;
	public int mileage;
	public String color;
	public String brand;
	
	public Car() {
		speed=0; mileage=0; color="NoColor"; brand="NoBrand";
	}
	public Car(int a) {
		speed=a; mileage=0; color="NoColor"; brand="NoBrand";
	}
	public Car(String a) {
		speed=0; mileage=0; color="NoColor"; brand=a;
	}
	public Car(String a,String b) {
		speed=0; mileage=0; color=a; brand=b;
	}
	public Car(int a,int b,String c,String d) {
		speed=a; mileage=b; color=c; brand=d;
	}
}