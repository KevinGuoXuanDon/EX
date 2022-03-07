package Huawei;

import java.util.Scanner;

public class Binary {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        //位运算
        int count=0;
        for (int j = 0; j < 32; j++) {
            if((i&j)==1){
                count++;
            }
            i =i>>1;
        }
        System.out.println(count);
        // 转换二进制进行计算
        // String s =Integer.toBinaryString(i);
        // System.out.print(s.length() - s.replaceAll("1","").length());
    }
}
