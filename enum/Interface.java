public class Main {


    public static void main(String[] args) {

        Slime slimeA=new Slime(Slime.inputRange(Slime.MINHP,Slime.MAXHP),Slime.inputRange(Slime.MINATK,Slime.MAXATK));
        Slime slimeB=new Slime(Slime.inputRange(Slime.MINHP,Slime.MAXHP),Slime.inputRange(Slime.MINATK,Slime.MAXATK));
        int count=0;//第0回合
        System.out.println("史萊姆A能力值 初始的血量:"+slimeA.getHp()+" 初始攻擊力:"+slimeA.getAtk());
        System.out.println("史萊姆B能力值 初始的血量:"+slimeB.getHp()+" 初始攻擊力:"+slimeB.getAtk());
        while (slimeA.getHp()>0 && slimeB.getHp()>0 && count<20000){
            System.out.printf("第%d回合\n",++count);
            System.out.printf("史萊姆A");

            slimeA.castSkill().cast(slimeA,slimeB);
            System.out.printf("史萊姆B"); //若血量低於0，補血後大於0，這一回合不會死
            slimeB.castSkill().cast(slimeB,slimeA);
            System.out.println("目前史萊姆A的血量:"+slimeA.getHp());
            System.out.println("目前史萊姆B的血量:"+slimeB.getHp());
        }
    }
}
//____________________________________________________________________________________________________________________________________________
public class Slime {
    public static final int MAXATK=80;
    public static final int MINATK=40;
    public static final int MAXHP=200;
    public static final int MINHP=50;
    public static final int MAXHEAL=100;//攻擊的1.25倍
    public static final int MINHEAL=50;

    private int hp;
    private int atk;
    Skill[] Skills;

    public interface SkillTree {
        public void cast(Slime slime1,Slime slime2);
    }

    public enum Skill implements SkillTree{
        RECOVER(0){
            @Override
            public void cast(Slime slime1,Slime slime2) {
                int val=inputRange(MINHEAL,MAXHEAL);
                System.out.println("對自己回血"+val);
                slime1.addHp(val);
            }
        },
        ATK(1){
            @Override
            public void cast(Slime slime1,Slime slime2) {
                System.out.println("使出一般攻擊,造成 "+slime1.getAtk()+" 點傷害");
                slime2.setHp(slime2.getHp()-slime1.getAtk());
            }
        },
        CRIT(2){
            @Override
            public void cast(Slime slime1,Slime slime2) {
                System.out.println("使出爆擊,造成 "+slime1.getAtk()*15/10+" 點傷害");
                slime2.setHp(slime2.getHp()-slime1.getAtk()*15/10);
            }
        };

        private final int value;
        private Skill(int value){
            this.value=value;
        }

        public static Skill getSkillByInt(int option){
            for(Skill skill:values()){
                if(skill.value==option){
                    return skill;
                }
            }
            return RECOVER;
        }
    }
  
  
    public static int inputRange(int min,int max){
        return new Random().nextInt(max-min)+min;
    }

    public Slime(int hp,int atk){
        setAtk(atk);
        setHp(hp);
        setSkill(); //隨機兩個技能
    }

    public void setSkill(){
        Skills=new Skill[2];
        Random r=new Random();
        int first=r.nextInt(3);
        int second=r.nextInt(2);
        if(second>=first){
            second++;
        }
        Skills[0]=Skill.getSkillByInt(first);
        Skills[1]=Skill.getSkillByInt(second);
    }
    public Skill castSkill(){
        return Skills[new Random().nextInt(2)];
    }

    public int getHp() {
        return hp;
    }


    public void addHp(int val) {
        setHp(getHp()+val);
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }


}
