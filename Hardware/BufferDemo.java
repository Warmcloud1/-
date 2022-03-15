import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import static com.sun.webkit.perf.WCFontPerfLogger.log;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<FileIoInterface> datas=new ArrayList<>(5);
        datas.add(new Data("a",1,"c"));
        datas.add(new Data("A",2,"C"));
        write3("3",datas);

    }
    /**
     * 寫檔1
     */
    private static void write1 () {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("1.txt"));//建檔 找不到檔案會自動建立，若已存在會覆寫
            bw.write("111");
            bw.newLine();
            bw.write("222");
            bw.newLine();
            bw.write("333");
            bw.newLine(); //換行 在write中寫windows\n\r也可換行 在不同的作業系統換行指令不同 因此用newLine
            bw.write("123\n\r");
            bw.write("12");
            bw.flush(); //flush把目前緩衝區的東西寫入檔案裡 。緩衝區滿會存入，但沒滿不會存，
            bw.close(); //檔案關閉
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 讀檔
     */
    private static void read1 () {
        try {
            BufferedReader br = new BufferedReader(new FileReader("1.txt"));
            while (br.ready()) {//回傳boolean 當光標已走到檔案尾巴沒東西時return false;
                br.readLine(); //第一次讀111 執行光標從原本在第0行第0個位置跑到第1行第0個位置
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 寫檔2 嘗試寫CSV格式
     */
    private static void write2 () {
        BufferedWriter bw; //建檔 找不到檔案會自動建立，若已存在會覆寫
        try {
            bw = new BufferedWriter(new FileWriter("1.csv")); // 附檔名可隨意取不影響內容，系統會建議你用excel開
            bw.write("123,456,789");
            bw.newLine();
            bw.flush(); //flush把目前緩衝區的東西寫入檔案裡 。緩衝區滿會存入，但沒滿不會存，
            bw.close(); //檔案關閉
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 讀CSV格式檔
     */
    private static void read2 () {
        try {
            BufferedReader br = new BufferedReader(new FileReader("1.csv"));
            while (br.ready()) {
                String str=br.readLine();
                String[] tmp=str.split(",");
                for (int i = 0; i < tmp.length; i++) {
                    System.out.println(tmp[i]);
                }

            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 寫檔3 寫CSV格式,可傳入資料
     */
    private static void write3 (String fileName,ArrayList<FileIoInterface> data) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName+".csv"));
            for(FileIoInterface fii:data){
                bw.write(fii.write());
                bw.newLine();
            }
            bw.flush(); //flush把目前緩衝區的東西寫入檔案裡 。緩衝區滿會存入，但沒滿不會存，
            bw.close(); //檔案關閉
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//_____________________________________________________________________________________
public class Data implements FileIoInterface{
    private String s1;
    private int i1;
    private String s2;

    public Data(String s1,int i1,String s2){
        this.s1=s1;
        this.i1=i1;
        this.s2=s2;
    }

    @Override
    public String write() {
        return (this.s1 +","+ this.i1+"," +this.s2);
    }
}
//_____________________________________________________________________________________
public interface FileIoInterface {
    public String write();
}
