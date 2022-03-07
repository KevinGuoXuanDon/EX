package Huawei;

import java.util.HashSet;
import java.util.Scanner;
//统计一个字符串中字符出现次数
public class StaticChar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        HashSet<Character> set = new HashSet<>();
        int result =0;
        for(int i = num.length()-1; i>=0; i--){
            char curChar = num.charAt(i);
            if(set.contains(curChar)) continue;
            else{
                result++;
                set.add(curChar);
            }
        }
        System.out.print(result);
    }
}
