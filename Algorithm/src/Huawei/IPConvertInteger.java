package Huawei;
import java.util.*;

/**
 * ip地址的每段可以看成是一个0-255的整数
 * 把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变一个长整数。
 * 10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121
 * 同样的，十进制数字也可以转换为ip
 */
public class IPConvertInteger {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //int->ip
        String[] strings = sc.nextLine().split("\\.");
        StringBuilder sb = new StringBuilder();
        for(String s:strings){
            //每一个分组转换为2进制，不满8则添8
           String num =Integer.toBinaryString(Integer.valueOf(s));
           while(num.length()<8){
               num="0"+num;
           }
           sb.append(num);
        }
        //二进制转换为十进制
        long res = Long.parseLong(sb.toString(),2);
        System.out.println(res);

        //ip->int
        long input2 = sc.nextLong();
        String num2 = Long.toBinaryString(input2);
        //4*8=32，位数不满则添加
        while(num2.length()<32){
            num2 = "0" + num2;
        }
        String[] ans = new String[4];
        for(int i=0; i<4; i++){
            //每8位拆1份
            String s = num2.substring(8*i, 8*i+8);  //拆分
            s = Integer.toString(Integer.parseInt(s, 2));  //转化为10进制
            ans[i] = s;
        }
        System.out.println(String.join(".",ans));
    }
}
