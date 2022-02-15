package first;

import Animal_test.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat=new Cat(); //會輸出動物的建構子 貓咪的建構子
	}
}

//**************************************************
package Animal_test;

public class Animal {
	public Animal() {
		System.out.println("動物的建構子");
	}
	public void eat() {
		System.out.println("咬");
	}
}
//***************************************************

package Animal_test;

public class Cat extends Animal{
	public Cat() {
    //super指的是當前操作父類的實體
    //this指的是當前操作類的實體
    super();//此行java隱藏起來，可打可不打，但要執行在第一行，不然會報錯
		System.out.println("貓咪的建構子");
	}
}
