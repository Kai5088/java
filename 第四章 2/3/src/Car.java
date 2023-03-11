public class Car{
	public int speed;
	public int mileage;
	public String color;
	public String brand;
	
	public Car() {
		speed=0;
		mileage=0;
		color="NoColor";
		brand="NoBrand";
	}
	
	public Car(int a,int b,String c,String d) {
		speed=a;
		mileage=b;
		color=c;
		brand=d;
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
	public boolean setColor(String b) {
		color=b;
		return (color==b);
		}
	public boolean setBrand(String b) {
		brand=b;
		return (brand==b);
		}
	
}	