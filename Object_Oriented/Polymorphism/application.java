package Main_test;
import java.util.Scanner;
import Animal_test.*;
import Shape.*;
public class Main {
	public static void main(String[] args) {
//多型觀念
		Square square=new Square(5);
		square.area();
		Rectangle rect;
		rect=square; //多型 正方形為長方形的一種
		square.test(); //子類擴充一個方法	
		//rect.test();擴增的無法抓到，會報錯
		Rectangle rect2=new Square(5); //不會回溯覆寫，Override不會覆寫長方形的方法，依然是正方形(感覺不重要)
        	Square square;
        	square=rect2 //會報錯，因長方形不為正方形的一種，但可以強制轉型，先跳過。
//應用 
		Shape[] shapeArr=new Shape[5];
		for(int ii=0;ii<3;ii++) {
			Scanner sc=new Scanner(System.in);
			int opt=sc.nextInt();
			switch(opt) {
				case 1:
					System.out.println("輸入一個半徑");
					shapeArr[ii]=new Circle(sc.nextInt());
					break;
				case 2:
					System.out.println("輸入一個長度一個寬度");
					shapeArr[ii]=new Rectangle(sc.nextInt(),sc.nextInt());
					break;
				case 3:
					System.out.println("輸入一個寬度");
					shapeArr[ii]=new Square(sc.nextInt());
					break;
			}	
		}
		for(int ii=0;ii<3;ii++) {
			System.out.println("面積為:"+shapeArr[ii].area()+"周長為"+shapeArr[ii].perimeter());
		}
	}
}
//**********************************************************************
package  Shape;
//Shape 類型
public Abstract class Shape {
	public Shape() {
	//沒抽象類別的話，Shape是不需要Area等方法，但其子類別需要，若不設置會找不到Shape的方法，	
	}
	public Abstract double area();

	public Abstract double perimeter();
}
//**********************************************************************
//長方形
public class Rectangle extends Shape{
	private double height;
	private double width;
	 public Rectangle(double height,double width) {
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
}
//**********************************************************************
//正方形 類型
public class Square extends Rectangle{
	public Square(double w) {
		super(w,w);
	}
	public void test() {
		System.out.println("test");
	}
}

//**********************************************************************
//圓形
package Shape;

public class Circle extends Shape{
	private static final double PI=3.14;
	private double r;
	
	public Circle(double r) {
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
}
