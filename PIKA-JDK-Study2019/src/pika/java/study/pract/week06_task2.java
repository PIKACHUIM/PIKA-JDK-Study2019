package pika.java.study.pract;
import java.util.Scanner;
public class week06_task2 {
    public static void main(String[] args) {
        System.out.printf("请输入矩阵的边长：");            //输入边长
        Scanner IPUT = new Scanner(System.in);
        int   TEMP = IPUT.nextInt();
        int[] MAPS = new int[TEMP * TEMP];
        for (int LOOP = 0; LOOP < TEMP * TEMP; LOOP++) { //生存随机
            double RAND = Math.random() * 100000;
            MAPS[LOOP] = (int)RAND;
            MAPS[LOOP] = MAPS[LOOP] % 2;
            System.out.print(MAPS[LOOP] + " ");
            if ((LOOP + 1) % TEMP == 0)
                System.out.println("");
        }
        int COUN_FLAG = 0, COUN_DATA = 0, COUN_OBBA, COUN_OBBB,COUN_FLAU=11;
        for (int LOOP = 0; LOOP < TEMP; LOOP++) {
            COUN_FLAG = 11;                             //标识初始
            COUN_OBBA = MAPS[LOOP * TEMP];              //保存行头
            COUN_OBBB = MAPS[LOOP];                     //保存列头
            for (int TOOP = 0; TOOP < TEMP; TOOP++)     //遍历行值
                if (MAPS[LOOP * TEMP + TOOP] != COUN_OBBA) {
                    COUN_FLAG -= 10;
                    break;}
            for (int TOOP = 0; TOOP < TEMP; TOOP++)     //遍历列值
                if (MAPS[TOOP * TEMP + LOOP] != COUN_OBBB) {
                    COUN_FLAG -= 1;
                    break; }
            if (COUN_FLAG >= 10) {
                System.out.printf("第%03d行是全%d\n", LOOP + 1, COUN_OBBA);
                COUN_DATA++; }
            if (COUN_FLAG % 2 == 1){
                System.out.printf("第%03d列是全%d\n", LOOP + 1, COUN_OBBB);
                COUN_DATA++; }
        if (MAPS[LOOP * TEMP + LOOP] !=        MAPS[0]   
                &&COUN_FLAU>=10 ) COUN_FLAU -= 10;
        if (MAPS[LOOP * TEMP+TEMP-LOOP-1]!= MAPS[TEMP]
                &&COUN_FLAU%2==1) COUN_FLAU -= 1;
    }
        if (COUN_FLAU >= 10) {
            System.out.printf("左对角线是全%d\n", MAPS[0]   );
            COUN_DATA++; }
        if (COUN_FLAU % 2 == 1){
            System.out.printf("右对角线是全%d\n", MAPS[TEMP]);
            COUN_DATA++; }
        System.out.printf("-----共有%3d行/列/对角线是全0/1-----\n", COUN_DATA);
}}