package pika.game.flappybird;
/*--------------------------------------
               事件循环类
           CODE BY PIKACHUIM
           作用：读写事件操作
--------------------------------------*/
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Loop {
    public EventHandler<ActionEvent> loop_even;
    public Timeline                  loop_line;
    public double                    loop_time;
    public void setb(double inpu_time,EventHandler<ActionEvent>inpu_even){          //绑定事件
        loop_time=inpu_time;
        loop_even=inpu_even;
    }
    public void play(){
        loop_line=new Timeline(new KeyFrame(Duration.millis(loop_time),loop_even)); //执行动画
        loop_line.setCycleCount(Timeline.INDEFINITE);
        loop_line.play();
    }
    public void stop(){                                                             //停止执行
        loop_line.stop();
    }
}
