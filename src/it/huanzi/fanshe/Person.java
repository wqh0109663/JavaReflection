package it.huanzi.fanshe;

/**
 * Created by wqh on 2018/2/3.
 */
public class Person {

    public int age ;

    public int getAge() {
        return age;
    }

    private String name ;

    public String getName() {
        return name;
    }

    private  static String addr ;

    public Person() {
        System.out.println("默认无参构造器");
    }

    private Person(int age) {
        System.out.println("私有age构造器");
    }

    public Person(String name) {
        System.out.println("name带参数的输出了");

    }

    public Person(String name, int age) {
        System.out.println("age带参数的输出了");

    }

    public Person(String name, int[] a) {
        System.out.println("int[]带参数的输出了");

    }

    public void show(){
        System.out.println("无参数的方法");
    }
    public void show(String name,String[] strings){
        System.out.println("name参数的方法");
    }

    public static void show1(){
        System.out.println("无参数的静态方法");
    }

    public static void main(String[] args) {
        System.out.println("main");
    }





}
