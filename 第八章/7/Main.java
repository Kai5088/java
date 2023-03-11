class Shape { // �N�����Ϊ��g�a�������O
	double area() { // �p�⭱�n
		return 0;
	}
}

class Circle extends Shape { // ��Ϊ��g�a
	int r; // �b�|�]���G���ء^
	
	Circle(int  r) { // Constructor
		this.r = r;
	}
	
	double area() { // Overriding method
		return 3.14 * r * r;
	}
}

class Square extends Shape { // ����Ϊ��g�a
	int side; // ����]���G���ء^
	
	Square(int  side) { // Constructor
		this.side = side;
	}
	
	double area() { // Overriding method
		return side * side;
	}
}

class Triangle extends Shape { // ����Ϊ��g�a
	int side; // ������]���G���ء^
	int height; // ���]���G���ء^
	
	Triangle(int  side, int height) { // Consstructor
		this.side = side;
		this.height = height;
	}
	
	double area() { // Overriding method
		return (side * height)/2.0;
	}
}

class Calculator {
	double price; // �C���褽�ت�����]���^
	
	Calculator(double price) { // Constructor
		this.price = price;
	}
	
	double calculatePrice(Shape s) {
		return s.area() * price; // �z�L�h�Υs�Υ��T��area��k
	}
}



public class Main {
	public static void main(String[] argv) {
		Circle c = new Circle(5); // �@����Ϊ��a
		Square s = new Square(5); // �@������Ϊ��a
		Triangle t = new Triangle(10,10); // �@���T���Ϊ��a
		
		Calculator ca = new Calculator(3000.0); // �C���褽��3000��
		
		System.out.println("The price of Circle c =" + ca.calculatePrice(c));
		System.out.println("The price of Square s =" + ca.calculatePrice(s));
		System.out.print("The price of Triangle t =" + ca.calculatePrice(t));
	}
}