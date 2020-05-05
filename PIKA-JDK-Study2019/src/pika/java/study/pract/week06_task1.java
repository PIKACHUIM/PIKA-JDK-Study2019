package pika.java.study.pract;
import java.util.Scanner;
public class week06_task1 {
    public static void main(String[] args)
    {
        int[] DATA=new int[6];
        int[] MAPS={999999,100,50,10,5,2,1};
        Scanner IPUT=new Scanner(System.in);
        for(int LOOP=0;LOOP<=5;LOOP++)
            DATA[LOOP]=0;
        for(int LOOP=0;LOOP<=9;LOOP++)
        {
            System.out.printf("请输入第%02d个人的工资：",LOOP+1);
            int TEMP=IPUT.nextInt();
            for(int LOPS=0;LOPS<=5;LOPS++)
                DATA[LOPS]+=TEMP%MAPS[LOPS]/MAPS[LOPS+1];
        }
        for(int LOOP=0;LOOP<=5;LOOP++)
            System.out.printf("面额为%03d的需要：%04d张\n",MAPS[LOOP+1],DATA[LOOP]);
    }
}