package Huawei;

import java.util.*;
public class BuyChicken{
    static List<String> result = new ArrayList<>();
    public static void main(String[] args){
        // int money = 100;
        // buyChicken(100,0,0,0);
        // result.stream().forEach(System.out::println);
        // x+y+z =100;   5x+3y+z/3 = 100; -> 7x+4y = 100, 0<x<15; 0<y <26
        for(int x = 0; x<15; x++){
            //能够计算出解
            if(0== ((100-7*x)%4)){
                int y = (100-7*x)/4;
                int z = 100 -x -y;
                System.out.println(x+" "+y+" "+z);
            }
        }
    }
    /**
     递归属于穷举算法了，其实可以列方程解决（数学问题）
     */
    public static void buyChicken(int money, int cock, int hen, int chick){
        if(cock+hen+chick == 100 && money ==0){
            result.add(cock+" "+hen+" "+chick);
            return;
        }
        if(money>5 && cock<20) buyChicken(money-5,cock+1,hen,chick);
        if(money>3 && hen<33) buyChicken(money-3,cock,hen+1,chick);
        if(money>1 && chick<100) buyChicken(money-1,cock,hen,chick+3);
    }
}