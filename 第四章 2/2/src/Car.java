public class Car{
	public int speed;
	public int mileage;
	public String color;
	public String brand;
	
	public boolean setSpeed(int a) {
	return (speed==a);
	}	
	public boolean setMileage(int a) {
		return (mileage==a);
		}
	public boolean setColor(String b) {
		return (color==b);
		}
	public boolean setBrand(String b) {
		return (brand==b);
		}
	
	public boolean setCar(String a,String b) {
		return (color==a&&brand==b);
		}
	public boolean setCar(int a,int b,String c,String d) {
		return (speed==a&&mileage==b&&color==c&&brand==d);
		}
}