package pika.game.flappybird;
/*--------------------------------------
               按钮事件类
           CODE BY PIKACHUIM
     作用：显示按钮并绑定触发事件
     用法：Push->setr->radd->seta
--------------------------------------*/
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class Push extends Imgs {
    public Button push_push;
    public Push(){}
    public Push(String text, Imgs imga){
        push_push=new Button(text,imga.imgs_view);
    }
    public void setr(double datx,double daty){
        push_push.setLayoutX(datx);
        push_push.setLayoutY(daty);
    }
    public void radd(){
        this.imgs_pane.getChildren().add(push_push);
    }
    public void seta(EventHandler<ActionEvent> inpu){
        push_push.setOnAction(inpu);
    }
    public void tran(){
        push_push.setStyle("-fx-background-color: #4ec0ca");
    }
}
