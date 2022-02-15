package first;

import Animal_test.*;
public class Main {

	public static void main(String[] args) {
		Cat cat=new Cat();
		cat.getNum();
  }
}
//*****************************************
package Animal_test;
public class Cat extends Animal{
	private int num=1; //成員用private
  //但可用public間接提取
	public int getNum() {
		return num;
	}
}
