package Huawei;

import java.util.HashSet;
import java.util.Scanner;
//找出不重复的数字
public class NoRepeatNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        HashSet<Character> set = new HashSet<>();
        for(int i = num.length()-1; i>=0; i--){
            char curChar = num.charAt(i);
            if(set.contains(curChar)) continue;
            else{
                set.add(curChar);
                System.out.print(curChar);
            }
        }
    }
}
