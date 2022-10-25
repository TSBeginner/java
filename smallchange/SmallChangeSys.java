package com.ts.smallchange;

import java.util.Scanner;

public class SmallChangeSys {
    static UserInfo user1 = new UserInfo("小张",23,10000);

    public static void main(String[] args) {
        boolean loop = true;
        Scanner in = new Scanner(System.in);

        //利用do-while完成初始化菜单。

        do{
            user1.homepage();  //调用菜单显示函数
            //输入选择
            System.out.print("请选择你的操作：");
            int sel = in.nextInt();

            //利用switch-case 完成进入选择的对应功能
            switch (sel){
                case 1:
                    user1.show(user1);  //调用零钱通明细函数
                    break;
                case 2:
                    user1.save(user1);  //调用存钱函数
                    break;
                case 3:
                    user1.use(user1);  //调用花钱函数
                    break;
                case 0:
                    loop = user1.exit();   //调用退出函数
                    break;
                default:
                    System.out.println("菜单选择有误,请重新选择！！！");
                    break;
            }

        }while (loop);
        System.out.println("你已安全退出！！！");
    }
}
