package exercise.date_0507;

import java.util.Scanner;

public class Login_01 {
    /**
     * 让用户输入用户名和密码,如果用户名和密码都是 admin 则显示登陆成功,如果不是则登陆失败,让用户重新登陆
     * 如果三次都登陆失败则结束程序.
     */

    public static void main(String[] args) {
        String username = "admin";
        String password = "admin";
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名:");
            String inputName = scan.next();
            if (username.equals(inputName)) {
                System.out.println("请输入密码:");
                String inputPassword = scan.next();
                if (password.equals(inputPassword)) {
                    System.out.println("登陆成功!");
                    return;
                } else {
                    System.out.println("登陆失败!");
                }
            }else{
                System.out.println("该用户不存在!");
            }
        }
        System.out.println("登陆失败,程序结束!");

    }


}
