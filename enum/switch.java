public class Main {
    public enum NewGrade {
        A, B, INCOMPLETE;
        public static NewGrade valueOf(int index){
            switch (index){
                case 1:
                    return A;
                case 2:
                    return B;
                default:
                    return INCOMPLETE;
            }
        }
    }


    public static boolean getGradeDesc(NewGrade grade) {
        String desc = "……";

        switch (grade) {
            case A:
                return true;
            case B:
                return false;
            //以下略……
            default:
                return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        NewGrade option=NewGrade.valueOf(sc.nextInt());
        switch (option){
            case A:
                getGradeDesc(NewGrade.A);
                break;
            case B:
                getGradeDesc(NewGrade.B);
                break;
        }
    }
}
