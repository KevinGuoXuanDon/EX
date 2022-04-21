package leetcode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class ReverseInteger {
    public int re(int x){
        long n = 0;
        while(x!=0){
            n = n*10 + x%10;
            x/=10;
        }
        return (int)n==n? (int)n:0;
    }
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        int flag = 1;
        long z = x;
        if(z<0){
            flag = -1;
            z=-z;
        }
        sb.append(z);
        double y=Double.valueOf(sb.reverse().toString())*flag;
        if(y>Integer.MAX_VALUE || y<Integer.MIN_VALUE){
            return 0;
        }
        else return (int)y;
    }
}
