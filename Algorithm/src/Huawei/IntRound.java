package Huawei;

import java.util.Scanner;

/**
 * 输入描述：
 * 输入一个正浮点数值
 * <p>
 * 输出描述：
 * 输出该数值的近似整数值
 * <p>
 * 示例1
 * 输入：
 * 5.5
 * 输出：
 * 6
 * 说明：
 * 0.5>=0.5，所以5.5需要向上取整为6
 */
public class IntRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float num = sc.nextFloat();
        int n = (int) (num);
        System.out.println(num);
        System.out.println(n);
        System.out.print(num - n >= 0.5 ? n + 1 : n);
    }
}
