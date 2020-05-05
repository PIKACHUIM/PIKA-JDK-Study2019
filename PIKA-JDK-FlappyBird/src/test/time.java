import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
public class time extends Pane {

    private Timeline animation;
    private String S = "";
    private int tmp = 300;

    Label label = new Label("300");

    public void Clock() {
        label.setFont(javafx.scene.text.Font.font(20));

        getChildren().add(label);
        animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> timelabel()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    public void timelabel() {
        tmp--;
        S = tmp + "";
        label.setText(S);
    }

}
