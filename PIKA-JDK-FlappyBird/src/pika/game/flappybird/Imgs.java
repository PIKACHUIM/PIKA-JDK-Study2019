package pika.game.flappybird;
/*--------------------------------------
              图片渲染类
           CODE BY PIKACHUIM
作用：载入图片并执行渲染，并绑定面板布局
用法：Imgs->setp->setr->load->uppo->radd
全局：init传入场景->show一次性绑定节点值
--------------------------------------*/
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Imgs {
    public static Pane       imgs_pane;         //存储全局布局
    public static Scene      imgs_rend;         //存储全局场景
    public        String     imgs_path;         //存储图片位置
    public        Image      imgs_imgs;         //存储图形数据
    public        ImageView  imgs_view;         //存储图片参数
    public        double     imgs_posx;         //存储垂直坐标
    public        double     imgs_posy;         //存储水平坐标
    public        double     imgs_posw;         //存储水平宽度
    public        double     imgs_posh;         //存储垂直宽度
    //--------------------------构造函数--------------------------
    public Imgs() { this.news(); }              //默认构造函数
    public Imgs(String dirs, String name){      //只设置文件名
       this.setp(dirs,name);this.news();}
    public Imgs(String dirs, String name,       //同时设置状态
                double datx, double daty,
                double datw, double dath){
        this.setp(dirs,name);
        this.setr(datx,daty, datw,dath);}
    public void news() {                        //默认参数初始
        this.imgs_posx = 0;
        this.imgs_posw = 100;
        this.imgs_posy = 0;
        this.imgs_posh = 100; }
    //--------------------------设置函数--------------------------
    public void setp(String dirs,String name)  {//设置文件路径
        imgs_path = "file:" +
                System.getProperty("user.dir")
                + "\\" + dirs
                + "\\" + name + ".PNG";
        this.load(); }
    public void setr(double datx, double daty,
                     double datw, double dath) {//设置大小位置
        this.imgs_posw = datw;
        this.imgs_posh = dath;
        this.setr(datx, daty); }
    public void setr(double datx, double daty) {//改变图片位置
        this.imgs_posx = datx;
        this.imgs_posy = daty;
        this.uppo(); }
    //--------------------------载入函数--------------------------
    public void load() {
        this.imgs_imgs = new Image(imgs_path);  //载入图片文件
        this.imgs_view = new ImageView();
        this.imgs_view.setImage(imgs_imgs);
        if(Main.game_dbug_imgs==1)
            System.out.println(imgs_path);
        this.uppo(); }
    public void radd() {                        //向面板加节点
        this.imgs_pane.getChildren().add(imgs_view); }
    public void uppo() {                        //更新图片位置
        this.imgs_view.setFitHeight(imgs_posh);
        this.imgs_view.setFitWidth(imgs_posw);
        this.imgs_view.setX(imgs_posx);
        this.imgs_view.setY(imgs_posy); }
    //--------------------------全局函数--------------------------
    public void init(int high, int widh) {      //初始窗口界面
        this.imgs_pane = new Pane();
        this.imgs_rend = new Scene(
             imgs_pane,widh,high); }
    public void show(Stage runt) {              //更新窗口画面
        runt.setScene(imgs_rend);
        runt.show(); }
    public void clea() {                        //清空渲染内容
        this.imgs_pane.getChildren().clear(); }
    //------------------------------------------------------------
}
