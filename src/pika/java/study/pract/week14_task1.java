package pika.java.study.pract;
import java.util.Scanner;
public class week14_task1 {
    public static void main(String[] args) {
        ComparableCircle C1 = new ComparableCircle(6.8);                    //创建一个设定值对象
        System.out.println("请输入想要比较的对象的半径值：");
        Scanner scanner = new Scanner(System.in);                              //创建一个输入值对象
        double input = scanner.nextDouble();
        ComparableCircle C2 = new ComparableCircle(input);
        System.out.println("两者是否相等：");
        System.out.println(C1.equals(C2));
        System.out.println("两者具体大小情况：（相等为0，设定值大于输入值为1，小于为-1）");
        System.out.println(C1.compareTo(C2));
        ComparableCircle C3 = (ComparableCircle)C1.clone();                    //克隆对象
        ComparableCircle C4 = (ComparableCircle)C2.clone();                    //克隆对象
        System.out.println("克隆后---------------------");
        System.out.println("两者是否相等：");
        System.out.println(C3.equals(C4));
        System.out.println("两者具体大小情况：（相等为0，设定值大于输入值为1，小于为-1）");
        System.out.println(C3.compareTo(C4));
        if(C1.compareTo(C2) == C3.compareTo(C4))
            System.out.println("克隆正确完成！");
    }
}
class Circle extends GeometriObject{
    private double radius;
    public Circle(){}
    public Circle(double radius){
        this.radius = radius; }
    public Circle(double radius,String color,boolean filled){
        this.radius = radius;
        setColor(color);
        setFilled(filled); }
    public double getRadius(){
        return radius; }
    public void setRadius(double radius){
        this.radius = radius; }
    public double getArea(){
        return radius*radius*Math.PI; }
    public double getDiameter(){
        return 2*radius; }
    public double getPerimeter(){
        return 2*radius*Math.PI; }
    public void PrintCircle(){
        System.out.println("The circle is created " + getDateCreated() + "and the radius is " + radius); }
}
class ComparableCircle extends Circle implements Cloneable,Comparable<ComparableCircle>{
    public ComparableCircle(){}                               //ComparableCircle无参构造
    public ComparableCircle(double a){
        setRadius(a); }                                       //ComparableCircle含参构造
    public boolean equals(ComparableCircle a){                //比较是否相等的equals方法
        return this.getArea()==a.getArea();}
    public int compareTo(ComparableCircle a)                  //Cmparable接口，相等为0，设定值大于输入值为1，小于为-1
    {
        if(this.getArea()-a.getArea() > 0) return 1;
        else if(this.getArea()-a.getArea() < 0) return -1;
        else return 0; }
    public Object clone(){                                   //Cloneable接口，克隆对象
        try{
            return super.clone(); }
        catch (CloneNotSupportedException ex){
            return null; } }
}
class GeometriObject {                                      //课本GeometriObject类
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    public GeometriObject(){
        dateCreated = new java.util.Date(); }
    public GeometriObject(String color,boolean filled){
        this.color = color;
        this.filled = filled; }
    public String getColor(){
        return color; }
    public void setColor(String color){
        this.color = color; }
    public boolean isFilled() {
        return filled; }
    public void setFilled(boolean filled) {
        this.filled = filled; }
    public java.util.Date getDateCreated(){
        return dateCreated; }
    public String toString(){
        return "created on " + dateCreated + "\ncolor:" + color + " and filled: " + filled; }
}