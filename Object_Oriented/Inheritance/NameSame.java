//子類與父類"方法"同名加@Override

//子類與父類"成員"同名
package Main_test;

import Animal_test.*;
import Shape.*;
public class Main {
	public static void main(String[] args) {
		Cat cat=new Cat();
		cat.printA();//printA Cat a=100;Animal a=1;	
		System.out.println(cat.toString());
	}
}
//**********************************************************
package Animal_test;

public class Animal {
	public Animal() {
		a=1;
	}
	private int a; //改成protected可以供子類使用
	//原來getA()方法
	public int getA() {
		return a;
	}
}
//packagepackagepackagepackagepackagepackagepackagepackagepackage
package Animal_test;

public class Cat extends Animal{
	public Cat() {
		a=100;
	}
	private int a; //改成protected可以供子類使用

	@Override    //同名方法時覆寫@Override
	public int getA() {
		return a;
	}
	public void printA() {
		System.out.println(a+ "  "+ getA()); //print(100    100)。若沒覆寫則呼叫父類的getA()=1，可用於呼叫父類的值，protected也可以辦到
        //
	}
	
}
