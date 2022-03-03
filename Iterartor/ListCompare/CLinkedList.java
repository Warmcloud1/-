public class CLinkedList implements Iterator {

    @Override
    public boolean hasNext() {
        if (current.next == null) {
            current = root; //root保持空不會存入東西，index為-1
            return false;
        }
        return true;
    }

    @Override
    public int next() {
        current = current.next;
        return current.data;
    }

    /**
     * 結點為內部類別，另外data可以轉換成任意型態的data 例如:private Student data;
     */
    private static class Node {
        private Node next; //雖為private 但CLinkedList可以直接使用
        private int data;
    }

    private Node root;
    private int count;
    private Node current;

    public CLinkedList() {
        root = new Node();
        current = root;
        count = 0;
    }

    /**
     * 新增
     * @param data
     */
    public void add(int data) {
        Node tmp = root;
        for (int i = 0; i < count; i++) {
            tmp = tmp.next;
        }
        tmp.next = new Node();
        tmp.next.data = data;
        count++;
    }

    /**
     * 插入
     * @param index
     * @param data
     */
    public void insert(int index, int data) {
        Node tmp = root;
        if (index < 0 || index >= count) {
            System.out.println("不在收尋範圍");
            return;
        }
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        Node tmp2 = tmp.next; //儲存暫時要斷開的位置的下一個位置
        tmp.next.data = data;
        tmp.next = tmp2;
        count++;
    }

    /**
     * 移除
     * @param index
     */
    public void remove(int index) {
        Node tmp = root;
        if (index < 0 || index >= count) {
            System.out.println("不在收尋範圍");
            return;
        }
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        //到這
        tmp.next = tmp.next.next;
        count--;
    }

    /**
     * 取得
     * @param index
     * @return
     */
    public int get(int index) {
        Node tmp = root.next;
        if (index < 0 || index >= count) {
            System.out.println("不在收尋範圍");
            return 0; //int預設0(沒null) 、String 預設為null
        }
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }
}
