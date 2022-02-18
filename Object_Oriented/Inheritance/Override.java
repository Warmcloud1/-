//main
//** 主函式略過
//*
//*
//__________________________________________________________________________________________________
package Animal_test;

public class Animal {
	public void eat() {
		System.out.println("咬");
	}
	public Animal Test() {
		return null;
	}
	public Animal Test_a() {
		return null;
	}
	public Cat Test2() {
		return null;
	}
	
	public Cat Test2_c() {
		return null;
	}
}
//_______________________________________________________________________________________________
package Animal_test;

public class Cat extends Animal{
	//Override 用來覆寫方法 eat為常見方法，方法名稱及參數一樣就可作@Override，但封裝等級和參數一定要一樣嗎?
	@Override
	public void eat() {
		System.out.println("咬咬");
	}
	
	//以下示範一點"宣告名稱"變化   宣告:動物 原宣告:貓 動物是貓嗎?是 OK
	@Override 
	public Animal Test() { //父類Animal、子類Animal可覆寫
		return null;
	}
	@Override
	public Cat Test_a() {  //父類Animal、子類Cat可覆寫，因貓是動物，貓涵蓋動物的全部
		return null;
	}
	@Override				//父類Cat、子類Cat可覆寫，因貓是動物，貓涵蓋動物的全部
	public Cat Test2() {
		return null;
	}
	//@Override				//父類Cat、子類Animal不可覆寫，因貓是動物，貓涵蓋動物的全部
	//public Animal Test2_c() {
	//	return null;
	//}
}
