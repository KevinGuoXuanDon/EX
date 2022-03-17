package Huawei;

/**
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 例如，当输入5时，应该输出的三角形为：
 *
 * 1 3 6 10 15
 *
 * 2 5 9 14
 *
 * 4 8 13
 *
 * 7 12
 *
 * 11
 */
import java.util.*;
public class Triangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int yCount=1;
        int y=1;
        for(int i =1; i<=n;i++){
            int x =y;
            int xCount = i+1;
            for(int j =1; j<=n-i+1; j++){
                System.out.print(x+" ");
                x+=xCount;
                xCount++;
            }
            System.out.println("");
            y+=yCount;
            yCount++;
        }
    }
}
