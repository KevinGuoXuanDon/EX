package day12DoublePointer;

import java.util.Scanner;

public class HanioTower_DivideandConquer {
    private static int count=1;
    public void hanio(int n, char a, char b, char c){
        if (n<0) return;
        if(n==1){
            System.out.println("第"+count++ +"步 移动圆盘 "+n+" 从柱子 "+a+" 到柱子 "+c);
        }
        else{
            hanio(n-1,a,c,b);
            System.out.println("第"+count++ +"步 移动圆盘 "+n+" 从柱子 "+a+" 到柱子 "+c);
            hanio(n-1,b,a,c);
        }
    }

    public static void main(String[] args) {
        HanioTower_DivideandConquer h = new HanioTower_DivideandConquer();
        Scanner n = new Scanner(System.in);
        char a='A', b = 'B', c='C';
        h.hanio(n.nextInt(),a,b,c);
    }
}
