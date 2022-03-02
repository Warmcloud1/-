...上述為自己實現LinkedList
public int get(int index){
        Node tmp=root.next;
        for (int i = 0; i < index; i++) {
            tmp=tmp.next;
        }
        return (int)tmp.getAverageScore();
    }

    public interface Action{
        public void action (int data);
    }

    //LinkedList 方式:用get(i)，尋找每一個結點，要找n*(n+1)/2次才能找到全部
    public void map2(Action action){
        for (int i = 0; i < count; i++) {
            action.action(get(i));
        }
    }

    //LinkedList 方式:紀錄下來後，並接著找下一次，尋找每一個，找n次就可以找到全部，迭代器用相同的原理，不同集合走訪方式不同，因此有了Iterartor用類似以下方式作為一個共同公開介面的存在
    public void map(Action action){
        Node tmp=root;
        for (int i = 0; i < count; i++) {
            tmp=tmp.next;
            action.action((int)tmp.getAverageScore());
        }
    }
