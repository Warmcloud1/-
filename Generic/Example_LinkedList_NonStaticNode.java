
public class CLinkedList<T> {
    /**
     * 必須有 加入/插入/刪除/取得 (40%)
     * 擁有依照使用者定義的規則進行排序的方法 (20%)
     * 擁有將鏈結串列中的所有物件分行印出的方法(10%)
     */
    public interface Comparator<T> { //靜態類一定要定義T
        public boolean compare(T t1, T t2);
    }

    private class Node {   //左邊為無定義T的情況 //若有定義T <T> 則吃43行註解的T
        //若改成非靜態的類
        //無定義T的情況下吃的到父類的T
        //有定義T的情況下優先吃子類的T
        T data;  //此為父類的T

        Node next;

        public Node(T data) {
            this.data=data;
        }

        private T getData() {
            return data;
        }

        private void setData(T data) {
            this.data = data;
        }

        private Node next() {
            return next;
        }

        public void setNext(Node node) {
            this.next = node;
        }
    }


    private Node root;  // private Node<T> root; 有定義T則吃這裡的T

    private int count;

    public CLinkedList() {
        root = new Node(null);  //index:-1
        count = 0;
    }

    //加入
    public void add(T data) { //傳data 不能傳Node 外面無法用Node 
        Node tmp = root;

        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = new Node(data);

        count++;
    }

    //插入
    public void insert(int index,T data){
        if(index<0 ||index>count){
            return;
        }

        Node tmp =root;

        for (int i = 0; i < index; i++) {
            tmp=tmp.next;
        }

        Node tmp2=tmp.next;
        tmp.next=new Node (data);
        tmp.next.next=tmp2;

        count++;
    }

    //刪除
    public void remove(int index){
        if(index<0 ||index>count){
            return;
        }

        Node tmp =root;

        for (int i = 0; i < index; i++) {
            tmp=tmp.next;
        }
        //以上可用 Node<T> tmp=getNode(index-1); 但index==0時 將tmp=root


        tmp.next=tmp.next.next;
        count--;
    }

    //取得
    public T getData(int index) {
        Node tmp =getNode(index);
        if (tmp == null) {
            return null;
        }
        return tmp.data;
    }

    //取得結點
    private Node getNode(int index) {
        if (index < 0 || index > count) {
            return null;  //T一定是參考資料型態 才可以null  反例:int不可null，T不可以是int
        }

        Node tmp = root;

        for (int i = 0; i < index + 1; i++) {
            tmp = tmp.next;
        }

        return tmp;
    }

    //插入
    public void sort(Comparator<T> c) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (c.compare(getData(j), getData(j + 1))) {
                    Node n1=getNode(j);
                    Node n2=getNode(j+1);
                    T tmp = n1.data;
                    n1.data= n2.data;
                    n2.data= tmp;
                }
            }
        }
    }

    //長度
    public int length() {
        return count;
    }

    //印出
    public void print() {
        Node tmp = root;
        while (tmp.next != null) {
            tmp = tmp.next;
            System.out.println(tmp.data);
        }
        return;
    }
}

/////////////////////////////////////////////////////////////////////////////////////////
public class Main {
    public static void main(String[] args) {
        CLinkedList<Integer> cLinkedList=new CLinkedList<>();
        System.out.println("加入");
        cLinkedList.add(1);
        cLinkedList.add(5);
        cLinkedList.add(11);
        cLinkedList.add(9);
        cLinkedList.add(2);
        cLinkedList.print();


        System.out.println("\n插入");
        cLinkedList.insert(2,10);
        cLinkedList.print();


        System.out.println("\n刪除");
        cLinkedList.remove(0);
        cLinkedList.print();


        System.out.println("\n取得");
        System.out.println(cLinkedList.getData(3));


        System.out.println("\n排序"); //未完成
        cLinkedList.sort(new CLinkedList.Comparator<Integer>() {
            @Override
            public boolean compare(Integer t1, Integer t2) {
                return (t1<t2);
            }
        });
        cLinkedList.print();
    }
}
