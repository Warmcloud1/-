StudentArray arr=new StudentArray();
        int a=0;
        int b=5;
        final int c=10;//final才不會報錯
        final Student sss1=new Student(1,2,"a");//
        sss1.setScore(10);//應用:可以改final裡面的變數，但不能改Student EX:s1=null X


        StudentArray result2=arr.where(new StudentArray.Filter() { //沒有名字的類實現介面，匿名內部類別，編譯時會產生檔案，效能較慢
            @Override
            public boolean filter(Student student1) {
                return student1.getScore()>10;
            }
        });
        //將new StudentArray.Filter()...裡面轉成變數
        
        StudentArray.Filter ff=new StudentArray.Filter() { //沒有名字的類實現介面
            @Override
            public boolean filter(Student student1) {
                System.out.println(a); //此寫法沒問題，但破壞結構
                //System.out.println(b); //會報錯當執行緒執行時 到底是ff上方有轉換b?或是執行目前上方的b轉換?，所以IDE回報錯誤
                return student1.getScore()> 10;
            }
        };
        //此為filter子類別實現 將其存入ff的變數中 與之前不同，不用建立Class類別
        b=7;
        StudentArray result=arr.where(ff);//將其一串換為變數，以便多此使用
        
        //Java8版本以後才有 Lambda 會省略寫方法，所以使用時介面只能有一個方法，編譯時會產生function，所以效能會比較好
        StudentArray.Filter filter=(Student student1) -> {
            //System.out.println(b); //還是會報錯
            return student1.getScore()>10;};
        //當lambda 只有第一行，return可以省略成以下
        StudentArray.Filter filter2=(Student ss1) -> ss1.getScore()> 10;
        //鏈式調用找到無限篩選。
        StudentArray result3=arr
                .where((Student s1)->s1.getScore()>0)
                .sort((Student s1,Student s2)->s1.getScore()- s2.getScore())
                .where((Student s1)->s1.getScore()<20);  

        //補充 沒有參數又沒有回傳值時又只做一件事 member reference
        Runnable runnable = System.out::println;

//______________________________________________________________________
public class StudentArray {
    // 2. 擁有一個類別 StudentArray
    //    a. 擁有屬性 Student[] arr, int count
    //    b. 要有一個排序的方法
    //    c. 要有加入/取得特定位置的學生的方法
    private Student[] studentArr;

    private int count;

    public interface Filter {
        public boolean filter(Student student1);
    }

    public interface Comparactor1 { //放內部較好
        public int compare1(Student s1, Student s2);
    }
    
            //最一般
    public void sort2(){
        for (int ii = 0; ii < count-1; ii++) {
            for (int n = 0; n < count-1-ii; n++) {
                if(studentArr[n].getNumber()>studentArr[n+1].getNumber()){ //用
                    swap(n,n+1);
                }
            }
        }
    }
       //sort一般寫法
    public void sort1(Comparactor1 c){
        for (int ii = 0; ii < count-1; ii++) {
            for (int n = 0; n < count-1-ii; n++) {
                if(c.compare1(studentArr[n],studentArr[n+1])>0){
                    swap(n,n+1);
                }
            }
        }
    }
        
   //sort鏈式調用的寫法 會傳StudentArray
    public StudentArray sort(Comparactor1 c){
        StudentArray tmpArr=new StudentArray();
        for (int ii = 0; ii < count; ii++) {
            tmpArr.add(studentArr[ii]);
        }
        for (int ii = 0; ii < count-1; ii++) {
            for (int n = 0; n < count-1-ii; n++) {
                if(c.compare1(tmpArr.get(n),tmpArr.get(n+1))>0){
                    tmpArr.swap(n,n+1);
                }
            }
        }
        return tmpArr;
    }
  
  
    public StudentArray where(Filter f){
        StudentArray tmpArr=new StudentArray();
        for (int ii = 0; ii < count; ii++) {
            if(f.filter(studentArr[ii])){
                tmpArr.add(studentArr[ii]);
            }
        }
        return  tmpArr;
    }

    private Student get(int index){
        if(index<0||index>=count){
            return null;
        }
        return studentArr[index];
    }


  
    public StudentArray() {
        studentArr = new Student[2];
        count = 0;
    }


    //新增一個動物
    public void add(Student student) {
        if (student == null) {
            return;
        }
        if (count == studentArr.length) {
            doubleArr();
        }
        studentArr[count++] = student;
    }

    private void doubleArr() {
        Student[] tmpArr = new Student[studentArr.length * 2];
        for (int ii = 0; ii < studentArr.length; ii++) {
            tmpArr[ii] = studentArr[ii];
        }
        studentArr = tmpArr;
    }

    public void print() {
        for(int ii=0;ii<count;ii++){
            System.out.println("座號:"+studentArr[ii].getNumber()+" 學生:"+ studentArr[ii].getName()+" 成績:"+studentArr[ii].getScore());
        }

    }



    private void swap(int i1, int i2) {
        Student tmp = studentArr[i1];
        studentArr[i1] = studentArr[i2];
        studentArr[i2] = tmp;
    }



//_______________________________________________________________________
    public interface Filter {
        public boolean filter(Student student1);
    }
    
//______________________________________________________________________
    public interface Comparactor1 { //放內部較好
        public int compare1(Student s1, Student s2);
    }
