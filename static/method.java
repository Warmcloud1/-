//類似於類別變數，類別方法也可以於實體被創建前便調用；也因此類別方法中是不能使用到非靜態屬性的(調用方法時並不一定有任何實體)。

public class Circle {
    private static float pi = 3.14f;// 圓周率改為private讓外部不能直接存取
    
    private int r;// 圓形的半徑
    
    public Circle(int r) {
        this.r = r;
    }
    
    public float getArea() {
        return r * r * pi;// 靜態變數可以在一般方法中被調用(一般方法被調用時，靜態變數必然已存在於記憶體中)
    }
    
    // 這個靜態方法用來拿到pi的數值用來間接存取
    public static float getPi() {
        // 此處不能調用 r => 調用靜態方法時，並不一定會有實體
        return pi;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Circle.getPi());// 輸出:3.14
    }
}
