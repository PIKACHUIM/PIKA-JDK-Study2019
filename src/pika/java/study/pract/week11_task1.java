package pika.java.study.pract;

import java.util.Date;
import java.util.Scanner;

public class week11_task1 {
    public static void main(String[] args){
        Scanner IPUT=new Scanner(System.in);
        Account[] ATM=new Account[10];
        int id,flag,se,tp;
        for(int loop=0;loop<10;loop++)
            ATM[loop]=new Account(100+loop,10000+loop*1000,new Date(System.currentTimeMillis()));
        while(true) {
            while(true){
                System.out.print("请输入I D :");
                id=IPUT.nextInt();
                if(id>=100&&id<=109) break; }
            flag=1;se=0;
            while(flag==1){

                switch (se) {
                    case 4:flag=0;break;
                    case 1:ATMS.c1(ATM[id-100]);se=0;break;
                    case 2:System.out.print("输入取款额:");tp=IPUT.nextInt();ATM[id-100].withdraw(tp);se=0;break;
                    case 3:System.out.print("输入存款额:");tp=IPUT.nextInt();ATM[id-100].deposit (tp);se=0;break;
                    default:ATMS.showmenu();System.out.print("请输入选项:");se=IPUT.nextInt();
                } } } }}
class ATMS{
    public static void showmenu() {
        System.out.println("---------ATM---------");
        System.out.println("1.查看余额");
        System.out.println("2.提取现金");
        System.out.println("3.存入现金");
        System.out.println("4.退出系统");
        System.out.println("---------------------"); }
    public static void c1(Account acc) {
        System.out.println("你的余额是:"+acc.get_ba());
    }
}