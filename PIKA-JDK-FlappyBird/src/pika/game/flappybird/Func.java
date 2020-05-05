package pika.game.flappybird;
/*--------------------------------------
              渲染事件类
           CODE BY PIKACHUIM
           作用：执行渲染操作
--------------------------------------*/
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.paint.Paint;
public class Func extends Main{
    public static void main_init(Stage inpu) {
        main_ctrl.init(game_wind_high, game_wind_wedh);main_ctrl.show(inpu);
    }
    public static void main_menu_init() {
        //----------------------------------------------主菜单图片初始化----------------------------------------------
        menu_bgmp.setp("Imgs", "PICTS_BGPBT");menu_bgmp.setr(000, 000, 864, 960);
        menu_titl.setp("Imgs", "PICTS_TITLE");menu_titl.setr(170, 100, 534, 144);
        menu_star.setp("Imgs", "PICTS_START");menu_star.setr(315, 330, 242, 146);
        menu_bars.setp("Imgs", "PICTS_LANGS");menu_bars.setr(000, 852, 864, 224);
        menu_bart.setp("Imgs", "PICTS_LANGS");menu_bart.setr(864, 852, 864, 224);
        ends_titl.setp("Imgs", "PICTS_OVERD");ends_titl.setr(130, 140, 612, 108);
        ends_pans.setp("Imgs", "PICTS_PANEL");ends_pans.setr(150, 500, 595, 315);
        ends_dold.setp("icon", "PICTS_MEDA3");ends_dold.setr(219, 625, 110, 110);
        menu_butt = new Push("", menu_star);         menu_butt.setr(295, 300);menu_butt.tran();
    }
    public static void main_game_init(){
        //----------------------------------------------游戏中图片初始化----------------------------------------------
        game_bird.setp("icon", "PICTS_BIRD1");game_bird.setr(340,330,   96,  96);
        main_bird_loop();bird_loop.play();Func.taps_loop.play();
    }
    public static void main_game_loop(){
        //----------------------------------------------游戏中水管主循环----------------------------------------------
        EventHandler<ActionEvent> main_taps_even = r -> {
            Taps.move();
            if(taps_spee_addd==0){
                int temp_addu=(int)System.currentTimeMillis()%150;
                int temp_flag=(int)(Math.random()*101)%2;
                if(Taps.taps_lens>0){
                    int temp_posy=(int)(-Taps.taps_dat1.get(Taps.taps_lens-1).imgs_posy);
                    if(temp_flag==0)
                        Taps.addt(temp_posy+temp_addu);
                    else
                        Taps.addt(temp_posy-temp_addu);
                    System.out.println("[增加水管]"+temp_flag+"[增加位置]"+temp_posy);
                }
                else
                    Taps.addt(700);
                taps_spee_init+=taps_spee_adda;
                taps_spee_addd=taps_spee_addb;
            }
            else{
                taps_spee_addd--;
            }
        };
        taps_loop.setb(game_fram_fpst, main_taps_even);
    }
    public static void main_menu_show(){
        //----------------------------------------------载入菜单图像数据----------------------------------------------
        main_ctrl.clea();/*清空*/menu_bgmp.radd();menu_titl.radd();menu_bars.radd();menu_bart.radd();menu_butt.radd();
    }
    public static void main_game_show(){
        //----------------------------------------------载入游戏图像数据----------------------------------------------
        main_ctrl.clea();/*清空*/menu_bgmp.radd();menu_bars.radd();menu_bart.radd();game_bird.radd();
        text_scor.setFont(Font.font ("Verdana", 42));
        text_scor.setText("SCORE: 0");
        text_scor.setTranslateX(20);
        text_scor.setTranslateY(70);
        text_scor.setFill(Paint.valueOf("#ffffff"));
        main_ctrl.imgs_pane.getChildren().add(text_scor);
    }
    public static void main_push_init(){
        //----------------------------------------------载入菜单按钮事件----------------------------------------------
        EventHandler<ActionEvent> menu_burr_acte=new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t){ main_game_init();main_game_show(); }};
        menu_butt.seta(menu_burr_acte);
    }
    public static void main_menu_loop(){
        //----------------------------------------------载入菜单底栏事件----------------------------------------------
        EventHandler<ActionEvent> main_menu_even = r -> {
            menu_bars.setr(menu_bars.imgs_posx -8, menu_bars.imgs_posy);
            menu_bart.setr(menu_bart.imgs_posx -8, menu_bart.imgs_posy);
            if(menu_bars.imgs_posx<=game_wind_wedh*(-1)) menu_bars.setr(  0,menu_bars.imgs_posy);
            if(menu_bart.imgs_posx<=0)                   menu_bart.setr(864,menu_bart.imgs_posy);};
        menu_loop.setb(game_fram_fpst,main_menu_even);
    }
    public static void main_bird_loop(){
        //----------------------------------------------载入小鸟下坠线程----------------------------------------------
        EventHandler<ActionEvent> main_bird_even = r -> {
            bird_data_spee+=bird_data_datg;bird_data_high+=bird_data_spee;
            if(bird_data_high>=778)bird_data_high=778;game_bird.setr(game_bird.imgs_posx,bird_data_high);};
        bird_loop.setb(game_fram_fpst,main_bird_even);
    }
    public static void main_mous_loop(){
        //----------------------------------------------载入小鸟上升线程----------------------------------------------
        main_ctrl.imgs_rend.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent m) { bird_data_spee=-bird_data_addq; }});
    }
    public static void main_game_rset(){
        //----------------------------------------------重置游戏状态函数----------------------------------------------
        bird_data_high = 330;    //记录小鸟位置
        bird_data_spee =   0;    //记录小鸟速度
        taps_spee_init =   6;    //记录水管速度
        taps_spee_addb = 140;    //水管递增间隔
        taps_spee_addd =   0;    //水管递增计数
        game_scor_data =   0;    //存储游戏分数
        for ( int i=Taps.taps_dat1.size()-1; i>=0;i--) {
            Taps.taps_dat1.remove(i);
            Taps.taps_dat2.remove(i);
        }
    }
    public static void main_endl_show(){
        //----------------------------------------------显示结尾标题函数----------------------------------------------
        bird_loop.stop();
        taps_loop.stop();
        main_ctrl.clea();
        menu_bgmp.radd();
        ends_titl.radd();
        ends_pans.radd();
        ends_dold.radd();
        text_scor.setTranslateX(620);
        text_scor.setTranslateY(620);
        main_ctrl.imgs_pane.getChildren().add(text_scor);
        Taps.clen();
        text_scor.setText(Integer.toString((int)game_scor_data));

        main_game_rset();
        menu_butt.radd();
    }

}
