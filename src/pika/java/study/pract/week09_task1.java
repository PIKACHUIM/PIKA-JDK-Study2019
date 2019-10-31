package pika.java.study.pract;
import java.util.Date;
public class week09_task1 {
    public static void main(String[] args)
    {
        Account pika=new Account(1122,20000,new Date(System.currentTimeMillis()));
        pika.set_an(0.045);
        pika.withdraw(2500);
        pika.deposit(3000);
        System.out.println("【皮卡丘】ID："+pika.get_id()+" 余额："+pika.get_ba()+"  月利率："+pika.get_an()/12+"  创建日期："+pika.get_dt());
    }
}
class Account
{
       int    id;
       double balance;
static double annualInterestRate;
       Date   dateCreated;
       public Account(){
           annualInterestRate=0;
           id=0;
           balance=0;
           dateCreated=new Date(0);
       }
        public Account(int ip_id,double ip_mn,Date ip_da){
        annualInterestRate=0;
        id=ip_id;
        balance=ip_mn;
        dateCreated=ip_da;
        }
        public int    get_id(            ){return this.id;}
        public void   set_id(int    ip_id){this.id=ip_id;}
        public double get_ba(            ){return this.balance;}
        public void   set_ba(double ip_mn){this.balance=ip_mn;}
        public double get_an(            ){return this.annualInterestRate;}
        public void   set_an(double ip_an){this.annualInterestRate=ip_an;}
        public Date   get_dt(            ){return this.dateCreated;}
        public double getMonthlyInterestRate(){return this.annualInterestRate/12;}
        public double withdraw(double ip_mn){this.balance-=ip_mn;return this.balance;}
        public double deposit(double ip_mn){this.balance+=ip_mn;return this.balance;}
};