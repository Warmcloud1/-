


public class Main {

    public static void main(String[] args) throws IOException {
        串流寫檔
        writeStream();
        readStream();

    /**
     * 串流寫檔
     */
    public static void writeStream(){
        try{
            FileOutputStream fos=new FileOutputStream("1.ser");//如同FileWriter//副檔名可隨意取，讀檔要讀對即可
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new Data("AAA",2,"AA")); //用notePad++打開
            oos.flush();
            oos.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    /**
     * 串流讀檔
     */
    public static void readStream(){

        try {
            FileInputStream fis=new FileInputStream("1.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Data data=(Data)ois.readObject(); //讀出來的型態為Object
            System.out.println(data);
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) { //無法反序列化
            e.printStackTrace();
        }
    }
}
  //_______________________________________________________________________
  import java.io.Serializable;
//類別實現序列化 類別裡面的東西要都可以序列化，才可以序列化，EX:基本資料型態、String(看底層有實現序列化)、或自己做的類別也實現Serializable
public class Data implements Serializable {
   // private static final long serialVersionUID=1111111111L; UID不太懂
    private String s1;
    private int i1;
    private String s2;

    public Data(String s1,int i1,String s2){
        this.s1=s1;
        this.i1=i1;
        this.s2=s2;
    }
