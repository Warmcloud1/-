//建構子的多載 overloading

package Constructor;

public class Main {

	public static void main(String[] args) {
		Test t;
		Test.Builder builder=new Test.Builder().setA(3).setB(2).setC(4);//鏈式方法
		t=builder.gen();
		t.print();
		//化簡
		Test t2=new Test.Builder().setA(3).setB(2).setC(4).gen();//鏈式方法
		t2.print();
	}
}
//___________________________________________________________________________________
package Constructor;

public class Test {
	//以下為標準Builder Pattern 為了建構建構子，做一內部類別
	
	public static class Builder {
		private int a;
		private int b;
		private int c;
		
		public Builder setA(int a) {
			this.a=a;
			return this;
		}
		public Builder setB(int b) {
			this.b=b;
			return this;
		}
		public Builder setC(int c) {
			this.c=c;
			return this;
		}
		public Test gen() {
			return new Test(a,b,c);
		}
	}

	private int a;
	private int b;
	private int c;
	//建構子多載無法指定位置不是好方法	
	public Test (int a) {
		this.a=a;
	}
	public Test (int a,int b) {
		this.a=a;
		this.b=b;
	}
	public Test (int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public void print() {
		System.out.print("a="+a+",b="+b+",c="+c+"\n");
	}
}
