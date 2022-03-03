//迭代器設計模式
//不管是ArrayList或LinkList都有迭代器，其目的是用來走訪一個集合中每一個結點所使用的設計模式
//foreach便是用迭代器，因此可以只跑一次找到所有資料，但缺點是如果刪除或插入，就找不到下一個的點
//達到走訪每一個結點，必要實現找到下一個點的方式與何時結束的判斷
public interface Iterator {
    public boolean hasNext();
    public int next();
}
