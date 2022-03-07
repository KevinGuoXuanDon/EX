package Huawei;

import java.util.Scanner;

/**
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出。
 *
 * 输入： W10, A5等
 *
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 *
 * 坐标之间以;分隔。
 *
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 */
public class MovePosition {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(";");
        int x =0;
        int y=0;
        for(String s : strings){
            if(isValid(s)){
                switch(s.charAt(0)){
                    case 'W':
                        y+= Integer.valueOf(s.substring(1));
                        break;
                    case 'S':
                        y-= Integer.valueOf(s.substring(1));
                        break;
                    case 'A':
                        x-= Integer.valueOf(s.substring(1));
                        break;
                    case 'D':
                        x+= Integer.valueOf(s.substring(1));
                        break;
                }
            }
        }
        System.out.println(x+","+y);
    }
    public static boolean isValid(String s){
        return s.matches("[WASD][0-9]{1,2}");
    }
}
