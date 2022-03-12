package Huawei;

import java.util.Scanner;

/**
 * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
 * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
 * 数据范围：输入的正整数满足 1-100
 *
 * 输入10，输出5
 * 用九个空瓶换三瓶汽水，剩四个空瓶再用三个空瓶换一瓶汽水，剩两个空瓶
 * 向老板借一瓶汽水喝完得三个空瓶换一瓶汽水还给老板
 */
public class SodaBottle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int count = 0;
            int res=0;
            while(n>0){
                n--;
                count++;
                if(count == 3){
                    n++;
                    res++;
                    count=0;
                }
                if(count==2 && n==0){
                    res++;
                    break;
                }
            }
            if(res>0) System.out.println(res);
        }

    }
}
