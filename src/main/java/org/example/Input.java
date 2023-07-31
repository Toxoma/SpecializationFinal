package org.example;

import java.util.Scanner;

public class Input {
    public  static  Scanner sc = new Scanner(System.in);
    public static String getInput(String msg) {
        try{
            System.out.print(msg);
            System.out.print("ввод: ");
            String str = sc.nextLine();
            return str;
        } catch (Exception e) {
//            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Integer getInteger(String msg) {
        try{
            System.out.print(msg);
            System.out.print("ввод: ");
            String str = sc.nextLine();
            return Integer.parseInt(str);
        } catch (Exception e) {
//            System.out.println(e.getMessage());
            return null;
        }
    }
}
