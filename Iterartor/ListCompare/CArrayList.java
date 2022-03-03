import java.util.ArrayList;

public class CArrayList {
    private int[] arrTest1;
    private ArrayList<Integer> arrTest2;
    private int count;
    //arrTest1自己實現
    //arrTest2用ArrayList實現
    public CArrayList(){
        arrTest1=new int[2];
        count=0;
    }

    /**
     * 新增Integer
     * @param data
     */
    public void add1(int data){
        if(count==arrTest1.length){
            doubleArr();
        }
        arrTest1[count++]=data;
    }

    /**
     * 插入index位置
     * @param index
     * @param data
     */
    public void insert1(int index,int data){
        if(count==arrTest1.length){
            doubleArr();
        }
        //全部往右搬一格
        for (int i = count; i > index; i--) {
            arrTest1[i]=arrTest1[i-1];
        }
        arrTest1[index]=data;
        count++;
    }

    /**
     * 移除index位置的Integer
     * @param index
     */
    public void remove1(int index){
        for (int i = index; i < count-1; i++) {
            arrTest1[i]=arrTest1[i+1];
        }
        arrTest1[count-1]=0; //int不可為null預設為0 String預設為null
    }


    /**
     * 取得index位置的Integer
     * @param index
     * @return
     */
    public int get1(int index){
        return arrTest1[index];
    }


    /**
     * 當格子滿後在給予原來的兩倍空間
     */
    public void doubleArr(){
        int[] tmpArr=new int[arrTest1.length*2];
        for(int i=0;i<count;i++){
            tmpArr[i]=arrTest1[i];
        }
        arrTest1=tmpArr;
    }


    /**
     * 新增Integer 直接使用ArrayList的內建方法
     * @param data
     */
    public void add2(int data){
        arrTest2.add(data);
    }

    /**
     * 插入index位置 直接使用ArrayList的內建方法
     * @param index
     * @param data
     */
    public void insert2(int index,int data){
        arrTest2.add(index,data);
    }

    /**
     * 移除index位置的Integer 直接使用ArrayList的內建方法
     * @param index
     */
    public void remove2(int index){
        arrTest2.remove(index);
    }

    /**
     * 取得index位置的Integer 直接使用ArrayList的內建方法
     * @param index
     * @return
     */
    public int get2(int index){
        return arrTest2.get(index);
    }
}
