package test;

import javafx.concurrent.Task;
import javafx.stage.Stage;
import pika.game.flappybird.Imgs;

public class task extends Task<Void>
{
    Imgs data;
    Stage temp;
    public void sets(Imgs inpu, Stage intp){
        data=inpu;
        temp=intp;
    }
    @Override
    protected Void call() throws Exception
    {

        for(;;){
            for(int i=0;i<=10;i++) {
                data.setr(i * 10+500, data.imgs_posy);
                System.out.println("111111");
                data.clea();
                data.radd();
                data.show(temp);
                System.out.println("111111");
                Thread.currentThread().sleep(1000);
            }
        }
    }

}