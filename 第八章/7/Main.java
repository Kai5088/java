class Shape { // 代表任何形狀土地的父類別
	double area() { // 計算面積
		return 0;
	}
}

class Circle extends Shape { // 圓形的土地
	int r; // 半徑（單位：公尺）
	
	Circle(int  r) { // Constructor
		this.r = r;
	}
	
	double area() { // Overriding method
		return 3.14 * r * r;
	}
}

class Square extends Shape { // 正方形的土地
	int side; // 邊長（單位：公尺）
	
	Square(int  side) { // Constructor
		this.side = side;
	}
	
	double area() { // Overriding method
		return side * side;
	}
}

class Triangle extends Shape { // 正方形的土地
	int side; // 底邊長（單位：公尺）
	int height; // 高（單位：公尺）
	
	Triangle(int  side, int height) { // Consstructor
		this.side = side;
		this.height = height;
	}
	
	double area() { // Overriding method
		return (side * height)/2.0;
	}
}

class Calculator {
	double price; // 每平方公尺的價格（元）
	
	Calculator(double price) { // Constructor
		this.price = price;
	}
	
	double calculatePrice(Shape s) {
		return s.area() * price; // 透過多形叫用正確的area方法
	}
}



public class Main {
	public static void main(String[] argv) {
		Circle c = new Circle(5); // 一塊圓形的地
		Square s = new Square(5); // 一塊正方形的地
		Triangle t = new Triangle(10,10); // 一塊三角形的地
		
		Calculator ca = new Calculator(3000.0); // 每平方公尺3000元
		
		System.out.println("The price of Circle c =" + ca.calculatePrice(c));
		System.out.println("The price of Square s =" + ca.calculatePrice(s));
		System.out.print("The price of Triangle t =" + ca.calculatePrice(t));
	}
}