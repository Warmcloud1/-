//**抽象 public abstract void 方法();
//抽象類依然可以有屬性跟方法和建構子
//但沒抽象的屬性，只有抽象方法
//抽象類建構子無法呼叫自己，要靠子類呼叫其建構子(觀念:建構子先找父類再建構子類)
//為何要有抽象方法
//為了Shape arr=new Circle[];
//new Circle在Shape中找的到Area等方法
//抽象類別可以沒有抽象方法
//抽象方法必要搭抽象類別
//重點:抽象類別存在的意義
//沒抽象類別的話，Shape是不需要Area等方法，但其子類別需要，若不設置會找不到Shape的方法，
//_____________________________________________________________________________________________________________
package Shape;

public abstract class Point {
	public Point(double x,double y) {
	}
}
//____________________________________________________________________________________________________________
package Shape;

public abstract class Shape extends Point{
	private double x;
	private double y;
	public Shape(double x,double y) {
		super(x,y);
	}
	public abstract double area();

	public abstract double perimeter();

	public void printInfo() {
		System.out.println(myShape()+"=> 面積:"+ area() + " 周長:"+ perimeter());
	}
	public double getPointX() {
		return x;
	}
	public double getPointY() {
		return y;
	}
	public abstract String myShape();
}
//______________________________________________________________________________________________________________
package Shape;

public class Circle extends Shape{
	private static final double PI=3.14;
	private double r;
	private String myShape="Circle";
	public Circle(double r,double x,double y) {
		super(x,y);
		this.r=r;
	}
	
	@Override
	public double area() {
		return r*r*PI;
	}
	
	@Override
	public double perimeter() {
		return 2*r*PI;
	}

	@Override
	public String myShape() {
		return myShape;
	}
}
