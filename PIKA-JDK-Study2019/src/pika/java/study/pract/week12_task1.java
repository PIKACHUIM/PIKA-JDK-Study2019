package pika.java.study.pract;
import java.util.Date;
import java.util.ArrayList;

public class week12_task1 {
    public static void main(String[] args){
        user pika=new user("George",1122,1000,0.15);
        pika.deposit(30);
        pika.deposit(40);
        pika.deposit(50);
        pika.withdraw(5);
        pika.withdraw(4);
        pika.withdraw(2);
        pika.showuser();
        pika.showtran();
    }
}

class user extends Account{
                  String name;
    ArrayList<Transation>tran;
    public user(String inmz,int inid,double inye,double inam){
        this.id                =inid;
        this.name              =inmz;
        this.balance           =inye;
        this.annualInterestRate=inam;
        this.dateCreated=new Date(System.currentTimeMillis());
        tran=new ArrayList();
        Transation temp=new Transation('i',this.balance,inye,"初始",0);
        tran.add(temp);
    }
    public double withdraw(double ip_mn){
        super.withdraw(ip_mn);
        Transation temp=new Transation('w',this.balance,ip_mn,"取款",this.balance+ip_mn);
        tran.add(temp);
        return ip_mn;
    }
    public double deposit(double ip_mn){
        super.deposit(ip_mn);
        Transation temp=new Transation('d',this.balance,ip_mn,"存款",this.balance-ip_mn);
        tran.add(temp);
        return ip_mn;
    }
    public void showtran() {
        System.out.printf("--------------------------------------------------------------------\n");
        System.out.printf("交易时间                     #T 原余额   交易额   现余额  类型\n");
        System.out.printf("--------------------------------------------------------------------\n");
        for (int loop = 0; loop < tran.size(); loop++) {
            System.out.print(tran.get(loop).date);
            System.out.printf(" %c %08.2f %08.2f %08.2f %s\n",
                    tran.get(loop).type,
                    tran.get(loop).orgi,
                    tran.get(loop).amou,
                    tran.get(loop).bala,
                    tran.get(loop).desc);
        }
        System.out.printf("--------------------------------------------------------------------\n");
    }
    public void showuser(){
        System.out.printf("--------------------------------------------------------------------\n");
        System.out.println("用户："+this.name+"   ID："+this.id+"   创建时间："+this.dateCreated);
    }
}

class Transation{
    public char   type;
    public Date   date;
    public double amou;
    public double bala;
    public double orgi;
    public String desc;
    public Transation(char   in1,
                      double in2,
                      double in3,
                      String in4,
                      double in5
    ){
        type=in1;
        amou=in2;
        bala=in3;
        desc=in4;
        orgi=in5;
        date=new Date(System.currentTimeMillis());
    }
}