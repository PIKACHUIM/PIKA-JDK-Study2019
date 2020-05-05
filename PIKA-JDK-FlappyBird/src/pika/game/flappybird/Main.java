package pika.game.flappybird;
/*--------------------------------------
              Flappy Bird
            Code by Pikachu
              Java课程设计
          任浩龙2018141461344
--------------------------------------*/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.text.Text;
public class Main extends Application {
        //----------------------------------------------全局游戏设置参数----------------------------------------------
        public static final int    game_wind_high = 960;    //全局窗口高度
        public static final int    game_wind_wedh = 864;    //全局窗口宽度
        public static final int    game_fram_fpst =  17;    //全局同步间隔
        public static final int    game_dbug_imgs =   0;    //图像调试标识
        public static final int    game_dbug_taps =   1;    //水管调试标识
        public static final double bird_data_datg =0.45;    //记录小鸟重力
        public static       double bird_data_high = 330;    //记录小鸟位置
        public static       double bird_data_spee =   0;    //记录小鸟速度，每一帧执行后自增的速度
        public static final double bird_data_addq =  10;    //小鸟上升速度，每次按下鼠标设置的速度
        public static       double taps_spee_init =   6;    //记录水管速度
        public static final double taps_spee_adda =   0;    //水管递增速度，每隔多少帧增加多少速度
        public static       double taps_spee_addb = 140;    //水管递增间隔，每隔多少帧增加一根水管
        public static final double taps_spee_addc =   2;    //水管递增递减，每通过一根水管减多少帧
        public static       double taps_spee_addd =   0;    //水管递增计数，统计当前执行的是多少帧
        public static final double taps_spee_adde =  30;    //水管递增下界，记录最少间隔多少帧自增
        public static       double game_scor_data =   0;    //存储游戏分数
        public static       Imgs   main_ctrl = new Imgs();  //全局渲染对象
        public static       Imgs   menu_bgmp = new Imgs();  //菜单背景图片
        public static       Imgs   menu_titl = new Imgs();  //菜单标题图片
        public static       Imgs   menu_star = new Imgs();  //菜单开始图片
        public static       Imgs   menu_bars = new Imgs();  //菜单底纹图片
        public static       Imgs   menu_bart = new Imgs();  //菜单底纹图片
        public static       Imgs   game_bird = new Imgs();  //游戏小鸟图像
        public static       Imgs   ends_titl = new Imgs();  //游戏结束标题
        public static       Imgs   ends_pans = new Imgs();  //游戏结束标题
        public static       Imgs   ends_dold = new Imgs();  //游戏结束标题
        public static       Push   menu_butt = new Push();  //存储按钮数据
        public static       Loop   menu_loop = new Loop();  //存储菜单循环
        public static       Loop   bird_loop = new Loop();  //小鸟下坠循环
        public static       Loop   taps_loop = new Loop();  //水管移动循环
        public static       Taps   taps_maps = new Taps();  //水管图像数据
        public static       Text   text_scor = new Text();  //存储文字信息
    public void start(Stage views) {
        Func.main_init(views);
        Func.main_menu_init();
        Func.main_menu_show();
        Func.main_menu_loop();
        Func.menu_loop.play();
        Func.main_push_init();
        Func.main_mous_loop();
        Func.main_game_loop();
    }
}


