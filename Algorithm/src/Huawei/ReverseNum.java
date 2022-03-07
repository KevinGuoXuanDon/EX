package Huawei;

import java.util.Scanner;
//数字反转
public class ReverseNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String getValue = sc.next();
        for(int i = getValue.length()-1; i>=0; i--){
            System.out.print(getValue.charAt(i));
        }
    }
}
