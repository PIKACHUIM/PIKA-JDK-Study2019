package pika.java.study.pract;
public class week13_task1 {
    public static void main(String[] args){
        complex t1=new complex( 1,5);
        complex t2=new complex( 4,6);
                       show("源复数：");t1.com_pnt();
                       show("源复数：");t2.com_pnt();
        t1.com_add(t2);show("做加法：");t1.com_pnt();
        t1.com_mul(t2);show("做乘法：");t1.com_pnt();
        t1.com_sub(t2);show("做减法：");t1.com_pnt();
        t1.com_div(t2);show("做除法：");t1.com_pnt();
                       show("绝对值：");
                       System.out.println(t1.com_abs());
    }
    static void show(String in){System.out.print(in);}
}
class complex{
    public double a;                                   //存储实部
    public double b;                                   //存储虚部
    public complex(                   ){a= 0;b= 0;}    //无参构造
    public complex(double ia          ){a=ia;b= 0;}    //实部构造
    public complex(double ia,double ib){a=ia;b=ib;}    //完整构造
    public double getreal(){return a;}                 //获取实部
    public double getimag(){return b;}                 //获取虚部
    public void   com_add(complex is){a+=is.a;b+=is.b;}//复数加法
    public void   com_sub(complex is){a-=is.a;b-=is.b;}//复数减法
    public void   com_mul(complex is){                 //复数乘法
        a=a*is.a-b*is.b;       b=a*is.b+b*is.a;}
    public void   com_div(complex is){                 //复数除法
        a=a*is.a+b*is.b/(is.a*is.a-is.b*is.b);
        b=a*is.b+b*is.a/(is.a*is.a-is.b*is.b); }
    public double com_abs(){return a*a+b*b; }
    public String com_str(          ){                 //转换字符
        String t=String.format(" %.4f",a);
        if(b-0.000001!=0)
            if(b>0)
                t=t+String.format("+%.4f",b);
            else
                t=t+String.format("%.4f",b);
        return t; }
    public void   com_pnt(          ){                 //显示复数
        System.out.println(this.com_str()); }
}
