package pika.java.study.pract;

public class week10_task1 {
<<<<<<< HEAD
    public void main(String[] args)
    {

    }
}

class queue
{
    int[] element;
    int   szie;
    public queue(int[] inpu)
    {

    }
    public void dequeue(int v)
    {

    }
    public bool empty()
    {

    }
    public getsize()
    {
        return
    }
}
=======
    public static void main(String[] args){
        queue test=new queue();                         //新建对象
        System.out.println("当前长度："+test.getsize());//获取长度
        for (int loop=1;loop<=20;loop++)
            test.enqueue(loop);                         //循环入队
        System.out.println("当前长度："+test.getsize());//获取长度
        System.out.print("出队数据：");
        for (int loop=1;loop<=20;loop++)
        System.out.print(test.dequeue()+" ");           //循环出队
        System.out.println("");
        System.out.println("当前长度："+test.getsize());//获取长度
    }
}
class queue{
    int[]    elements;//存储数据
    int      size;    //分配长度
    int      occp;    //使用长度
    boolean  lock;    //读写锁定
    public queue(){
        elements=new int[8];
        size=8;occp=0;
        lock=false;
    }
    public void enqueue(int inpu){
        while(lock);lock=true;               //加锁防止冲突
        if(occp<size){                       //占不满的情况
            elements[occp]=inpu;
            occp++; }
        else{                                //满占用的情况
            int[] temp=elements;             //保存当前数据
            elements=new int[size+1];
            for(int loop=0;loop<size;loop++) //写入原有数据
                elements[loop]=temp[loop];
            elements[size]=inpu;             //写入新的数据
            temp=null;size++;occp++;}
        lock=false;                          //释放互斥锁定
    }
    public int  dequeue(){
        while(lock);lock=true;               //加锁防止冲突
        int   outp=elements[0];              //保存当前数据
        int[] temp=new int[size-1];
        for(int loop=1;loop<size;loop++)     //保存当前数据
            temp[loop-1]=elements[loop];
        elements=temp;size--;occp--;         //应用当前数据
        lock=false;
        return outp;                         //释放互斥锁定
    }
    public boolean empty(){
        return (size<=0);
    }
    public int getsize(){
        return size;
    }
}
>>>>>>> 907367e437d5347405242d996649e9145f8457cc
