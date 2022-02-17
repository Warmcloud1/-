//比較有無繼承
//****************************************************
//main檔
package first;
import Animal_test.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat=new Cat();
		cat.eat();
		Dog dog=new Dog();
		dog.eat();
	}
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//無繼承
package Animal_test;

public class Cat {
	public void eat() {
		System.out.println("咬");
	}
}
//packagepackagepackagepackagepackagepackagepackage
package Animal_test;
public class Dog {
	public void eat() {
		System.out.println("咬");
	}
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//轉換成有繼承
package Animal_test;

public class Animal {
	public void eat() {
		System.out.println("咬");
	}
}
//packagepackagepackagepackagepackagepackagepackage
package Animal_test;
public class Cat extends Animal { //子類 extends 父類
}
//packagepackagepackagepackagepackagepackagepackage
package Animal_test;
public class Dog extends Animal{ //子類 extends 父類
}
