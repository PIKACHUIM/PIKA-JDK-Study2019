package pika.game.flappybird;
import java.util.ArrayList;
import java.util.List;
/*--------------------------------------
               水管移动类
           CODE BY PIKACHUIM
     作用：操作水管移动并判断
--------------------------------------*/
public class Taps extends Main{
    public static List<Imgs> taps_dat1;
    public static List<Imgs> taps_dat2;
    public static int        taps_lens;
    public Taps(){
        taps_lens=0;
        taps_dat1= new ArrayList<Imgs>();
        taps_dat2= new ArrayList<Imgs>();
    }
    public static void clen(){
        taps_lens=0;
        taps_dat1= new ArrayList<Imgs>();
        taps_dat2= new ArrayList<Imgs>();
    }
    public static void addt(int high){
        if(high<300) high=300;
        if(high>600) high=600;
        taps_lens++;
        Imgs tmp1=new Imgs("icon","PICTS_PIPUP",
                820,      -high,        52,768);
        Imgs tmp2=new Imgs("icon","PICTS_PIPDO",
                820,-high+768+300,52,768);
        taps_dat1.add(tmp1);taps_dat1.get(taps_dat1.size()-1).radd();
        taps_dat2.add(tmp2);taps_dat2.get(taps_dat2.size()-1).radd();
    }
    public static void delt(int inde){
        if(taps_dat1.size()>=1){
            main_ctrl.imgs_pane.getChildren().remove(taps_dat1.get(inde).imgs_view);
            main_ctrl.imgs_pane.getChildren().remove(taps_dat2.get(inde).imgs_view);
            taps_dat1.remove(taps_dat1.get(inde));
            taps_dat2.remove(taps_dat2.get(inde));
            taps_lens--;
        }
    }
    public static void move(){
        if(taps_lens>0)
            for(int lotp=0;lotp<taps_lens;lotp++){
                taps_dat1.get(lotp).setr(taps_dat1.get(lotp).imgs_posx-taps_spee_init,taps_dat1.get(lotp).imgs_posy);
                taps_dat2.get(lotp).setr(taps_dat2.get(lotp).imgs_posx-taps_spee_init,taps_dat2.get(lotp).imgs_posy);
                if(taps_dat1.get(lotp).imgs_posx<=-64) {
                    game_scor_data++;
                    String temp="SCORE: "+Integer.toString((int)game_scor_data);
                    text_scor.setText(temp);
                    if(Main.game_dbug_taps==1)
                        System.out.println("[当前得分]"+game_scor_data
                                          +"[帧率间隔]"+taps_spee_addb
                                          +"[水管速度]"+taps_spee_init
                                          +"[水管数量]"+taps_lens);
                    taps_spee_addb-=taps_spee_addc;
                    if(taps_spee_addb<=taps_spee_adde)taps_spee_addb=taps_spee_adde;
                }
                if(taps_dat1.get(lotp).imgs_posx<=-64){
                    delt(lotp);
                }
                if(taps_dat1.get(lotp).imgs_posx>=244&&taps_dat1.get(lotp).imgs_posx<=436){
                    if(bird_data_high<= taps_dat1.get(lotp).imgs_posy+750
                    || bird_data_high>= taps_dat2.get(lotp).imgs_posy-80){
                        System.out.println("[撞到柱子]"+lotp);
                        Func.main_endl_show();
                    }
                }
            }
    }
}
