import java.io.IOException;

public class MainTC {
    public static void main(String[] args) {
        System.out.println("Main:" +t2()); //會輸出3

    }

    private static int t(){
        try{
            test(8);
            System.out.println(1);
            return 1;
        }
        catch (IOException ex){
            System.out.println(2);
            return 2;
        }
        finally { //優先層級高
            System.out.println(3);
            return 3;  //就算前面return2 但還是return3
        }
    }

    private static int t2(){
        try{
            test(8);
            System.out.println(1);
            return 1;
        }
        catch (IOException ex){
            System.out.println(2);
            return 2;
        }
        finally { //優先層級高
            System.out.println(3); //就算return了還是會做
        }
    }

    private static void test(int num) throws IOException{
        if(num<10){
            throw new IOException("Hello World");
        }
        System.out.println(num);
    }
}
