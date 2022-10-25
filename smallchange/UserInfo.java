package com.ts.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class UserInfo {
    private final String name;
    private final int age;   //final 表示只能初始化一次不能在进行修改。
    private double balance;  //余额
    Date time = null;
    SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Scanner in = new Scanner(System.in);
    private String record = "----------------零钱明细---------------"; //字符串拼接

    public UserInfo(String name, int age, double balance) {
        this.name = name;
        this.age = age;
        setBalance(balance); //调用set方法进行限定初始化
    }
    //余额限定初始化大于等于0如果不对默认为0；
    public void setBalance(double balance) {
        if(balance >= 0){
            this.balance = balance;
        } else {
            System.out.println("余额初始化失败，默认为0！");
            this.balance = 0;
        }

    }

    //1.零钱通菜单
    public void homepage(){
        System.out.println("\n---------零钱通--------");
        System.out.println("|         菜单        |");
        System.out.println("| 1.账户信息           |");
        System.out.println("| 2.存钱              |");
        System.out.println("| 3.花钱              |");
        System.out.println("| 0.退出              |");
        System.out.println("| 其他数字回到菜单页！！！|");
        System.out.println("----------------------");

    }


    //2.零钱明细
    public void show(UserInfo user){
        System.out.println("----------------账户信息---------------");
        System.out.println("姓名："+user.name);
        System.out.println("年龄："+user.age );
        System.out.println("账户余额："+user.balance);
        System.out.println(record);
    }

    //3.存钱
    public double save(UserInfo user) {
        System.out.println("请输入要存的钱：");
        double money = in.nextDouble();
        if(money <= 0 ){
            System.out.println("存钱金额不对！！！");
            return 0;
        } else {
            time = new Date();    //获取当前系统时间
            System.out.println("存钱完毕，本次存钱：" + money);
            System.out.println("当前账户余额：" + (user.balance + money));

            //sim.format(time)对time格式化
            user.record = user.record + "\n" + "存钱：" + "    " + sim.format(time) + "    +" + money;    //字符串拼接
            return user.balance = user.balance + money;
        }
    }

    //4.取钱
    public double use(UserInfo user) {
        System.out.println("请输入要花费的钱：");
        double money = in.nextDouble();
        if(money > user.balance){
            System.out.println("余额不足，请先充值！！");
            return 0;
        }else if(money < 0) {
            System.out.println("你确定你是在花钱？？？");
            return 0;
        } else {
            time = new Date();   //获取当前时间
            System.out.println("花钱完毕，本次花钱："+money);
            System.out.println("当前账户余额："+ (user.balance - money));
            user.record = user.record + "\n" + "花钱：" + "    " + sim.format(time) + "    -" + money;  //字符串拼接
            return user.balance = user.balance - money;
        }

    }

    //5.退出
    public boolean exit(){
        System.out.print("你确定退出吗？(y/n):  ");
        String se = in.next();
        boolean result = true;
        if( se.equals("y")){
            result = false;
        }else if (se.equals("n") ){
            return true;
        } else {
            System.out.println("请正确输入！！！");
            exit();
        }
        return result;
    }
}
