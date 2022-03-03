public class Main {
    public static void main(String[] args) {
        CLinkedList ll=new CLinkedList();
        CArrayList al=new CArrayList();
        for (int i = 0; i < 10; i++) {
            al.add1(i+1);
            ll.add(i+1);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(al.get1(i));
        }
        //跑很慢 每一次取得都要
        for (int i = 0; i < 10; i++) {
            System.out.println(ll.get(i));
        }
    }
}
