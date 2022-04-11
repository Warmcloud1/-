
 public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        try {
            System.out.println("1");
            int a=scanner.nextInt();
            System.out.println("2");
        }catch (InputMismatchException e){
            System.out.println("3");
        }finally {
            System.out.println("4");
        } 
      //輸出134
    }
}
