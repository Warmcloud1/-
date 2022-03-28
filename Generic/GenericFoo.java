public class MainSh {
	public static void main(String[] args) {
		ArrayList<Rectangle> shapes=new ArrayList<>();
		Shape sh=new Shape();
		Circle c=new Circle(2);
		Rectangle r= new Rectangle(3,4);
		Square sq= new Square(2);
		//shapes.add(sh);
		funDown(shapes);
		funUp(shapes);

	}
	//?:通配字元

	//上界通配 <? extends 型態> 只出不進(簡易來說:只能get不能add) 可保證傳入一定是Rectangle的子類或Rectangle
	public static void funUp(ArrayList<? extends Rectangle> arr){
		for (int i = 0; i < arr.size(); i++) {
			//arr.add(new Shape(new Point(20,30)));
			Shape shape=arr.get(0);
			Rectangle rectangle=arr.get(0);
			//Square square=arr.get(0); //報錯 因傳入的有可能是Rectangle 就會有問題
			//arr.add(new Rectangle(5,5)); //會報錯 因傳入的可能是Square 就不能加入
		}
	}

	//下界通配 <? super 型態> 只進不出(簡易來說:只能add不能get) 可保證傳入一定是Rectangle的父類或Rectangle
	public static void funDown(ArrayList<? super Rectangle> arr){
		for (int i = 0; i < arr.size(); i++) {
			Object rectangle=arr.get(0); //Object可以出為 出的例外
			//Rectangle rectangle2=arr.get(0); //報錯 因傳入的可能是Object 就會有問題
			//arr.add(new Shape()); //報錯 因傳入為Rectangle就不能新增
			arr.add(new Rectangle(5,5));
			arr.add(new Square(5));
		}
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////
public class Shape{
	private Point point;
	public Shape(Point point) {
		this.point=point;
	}
	public Shape() {

	}
	public double area(){
		return 0;
	}

	public double perimeter(){
		return 0;
	}

	public void printInfo() {
		System.out.println(myShape()+"=> 面積:"+ area() + " 周長:"+ perimeter());
	}
	public double getPointX() {
		return point.x();
	}
	public double getPointY() {
		return point.y();
	}
	public String myShape(){
		return "";
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////

public class Circle extends Shape{
	private static final double PI=3.14;
	private double r;
	private String myShape="Circle";
	public Circle(double r) {
		super();
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

////////////////////////////////////////////////////////////////////////////////////////////////////

public class Rectangle extends Shape{
	 private double height;
	 private double width;
	 private String myShape="Rectangle";
	 public Rectangle(double height, double width) {
		 this.height=height;
		 this.width=width;
	 }
	 
	 @Override
	 public double area() {
		 return height*width;
	 }
	 
	 @Override
	 public double perimeter() {
		 return (height+width)*2;
	 }

	 @Override
	 public String myShape() {
			return myShape;
	 }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

public class Square extends Rectangle{
	private String myShape="Square";
	public Square(double w) {
		super(w,w);
	}
	@Override
	 public String myShape() {
			return myShape;
	 }
}
