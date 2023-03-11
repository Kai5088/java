public class Car {
	public int speed;
	public int mileage;
	public String color;
	public String brand;
	
	public Car() {
		speed=0; mileage=0; color="NoColor"; brand="NoBrand";
	}
	
	public Car(int a,int b,String c,String d) {
		speed=a; mileage=b; color=c; brand=d;
	}
	
	public int getSpeed() {
		return speed;
	}
	public int getMileage() {
		return mileage;
	}
	public String getColor() {
		return color;
	}
	public String getBrand() {
		return brand;
	}
	
	public boolean setSpeed(int a) {
		speed=a;
		return (speed==a);
	}
	public boolean setMileage(int a) {
		mileage=a;
		return (mileage==a);
	}
	public boolean setColor(String a) {
		color=a;
		return (color==a);
	}
	public boolean setBrand(String a) {
		brand=a;
		return (brand==a);
	}
	public boolean setCar(String a,String b) {
		color=a; brand=b;
		return (brand==b&&color==a);
	}
	public boolean setCar(int a,int b,String c,String d) {
		speed=a; mileage=b; color=c; brand=d;
		return (speed==a&&mileage==b&&brand==c&&color==d);
	}
	public boolean setColor(String a,String b) {
		color=a; brand=b;
		return (brand==b&&color==a);
	}
	public boolean setColor(int a,int b,String c,String d) {
		speed=a; mileage=b; color=c; brand=d;
		return (speed==a&&mileage==b&&brand==c&&color==d);
	}
}