//經典應用
public class TestMain {
	public static void main(String[] args) {
		//應用排序從大排到小跟從小排到大大部分都是一樣的只差在大小於
		int[] arr= {1,4,2,5,7,8,6,3,9};
		sort(arr,new Bigger()); //由小排到大
		print(arr);
		sort(arr,new Smaller());//由大排到小
		print(arr);
	}
	
	public static void sort(int[] arr,Comparator c) {
		for(int ii=0;ii<arr.length-1;ii++) {
			for(int n=0;n<arr.length-1-ii;n++) {
				if(c.compare(arr[n],arr[n+1])) { //換大到小 改成小於
					swap(arr,n,n+1);
				}
			}
		}
	}
	public static void swap(int[] arr,int i1,int i2) {
		int tmp=arr[i1];
		arr[i1]=arr[i2];
		arr[i2]=tmp;
	}
	public static void print(int[] arr) {
		for(int ii:arr) {
			System.out.printf(ii+" ");
		}
		System.out.println();
	}
}
//__________________________________________________________________________
/*		介面是一個只能有抽象方法和常數的類別 
		不能有屬性，不能有實現方法，也沒有建構子            新版Java有新增可以實現的抽象方法(這行忽略)
		public interface 介面名稱
		
		介面是為了實現多重繼承
		public class Rectangle extends Shape implement Test,Test2  //中文解釋:長方形繼承Shape實現Test,Test2
		implement後可以有多重繼承
		為何介面可以有多項繼承，因為皆未實現的方法，重名是沒有問題的 (方法不行，因為會重名)
		*/

public interface Comparator {
	public boolean compare(double a,double b);
}
//___________________________________________________________________________
public class Bigger implements Comparator {
	@Override
	public boolean compare(double a,double b) {
		return (a>b);
	}
}
//__________________________________________________________________________
public class Smaller implements Comparator {
	@Override
	public boolean compare(double a,double b) {
		return (a<b);
	}
}
