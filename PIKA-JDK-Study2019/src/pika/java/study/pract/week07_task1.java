package pika.java.study.pract;

public class week07_task1 {
    public static void main(String[] args)
    {
        int[] MAPS=new int[101];
        for(int LOP1=0;LOP1<=100;LOP1++)
            MAPS[LOP1]=0;
        for(int LOP1=1;LOP1<=100;LOP1++)
            for(int LOP2=LOP1;LOP2<=100;LOP2+=LOP1)
                MAPS[LOP2]=(MAPS[LOP2]==1)?(0):(1);
        for(int LOP1=0;LOP1<=100;LOP1++)
             if(MAPS[LOP1]==1)
                 System.out.println("第"+LOP1+"个柜子是开着的");
    }
}
