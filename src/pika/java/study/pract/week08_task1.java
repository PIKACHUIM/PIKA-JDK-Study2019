package pika.java.study.pract;
public class week08_task1 {
    public static void main(String[] args)
    {
        int[][] maps=new int[5][5];
        int     max1=0,max2=0;
        System.out.println("---------生成矩阵---------");
        for(int lop1=1;lop1<=4;lop1++)
        {
            System.out.print("         ");
            for (int lop2 = 1; lop2 <= 4; lop2++)
            {
                double temp = Math.random() * 10000 % 2;          //生成随机
                maps[lop1][lop2] = (int) temp;                    //写入数值
                System.out.print(maps[lop1][lop2]+" ");           //输出阵列
                if(lop1==4) {
                    maps[0][lop2] = maps[1][lop2] + maps[2][lop2]
                                  + maps[3][lop2] + maps[4][lop2];//统计列值
                    if(maps[0][lop2]>max2)max2=maps[0][lop2];}    //统计极值
            }
            System.out.println("");
                    maps[lop1][0] = maps[lop1][1] + maps[lop1][2]
                                  + maps[lop1][3] + maps[lop1][4];//统计行值
                    if(maps[lop1][0]>max1)max1=maps[lop1][0];     //统计极值
        }
        System.out.println("-------------------------");
        for(int loop=1;loop<=4;loop++)
        {
            if(maps[loop][0]==max1)
                System.out.println("第"+loop+"行具有最多数值的1，数量："+max1);
            if(maps[0][loop]==max2)
                System.out.println("第"+loop+"列具有最多数值的1，数量："+max2);
        }
        System.out.println("-------------------------");
    }
}
