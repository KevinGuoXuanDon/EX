package Huawei;

import java.util.*;

public class CountChar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        String input2 = sc.nextLine().toLowerCase();
        char c = input2.charAt(0);
        int count=0;
        //通过遍历
        for(char ch : s.toCharArray()){
            if(ch == c){
                count++;
            }
        }
        //使用替换replaceAll
        int ct=0;
        ct = s.length()-s.replaceAll(input2,"").length();
        System.out.print(ct);

        //似乎遍历的时间复杂度要好些
    }
}
