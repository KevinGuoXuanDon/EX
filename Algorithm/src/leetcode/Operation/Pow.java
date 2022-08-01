package leetcode.Operation;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Pow {

    /**
     *  倍增乘法.
     *  O(logn).
     *  use thought : divide and conquer.
     *  Reduce the range of given target.
     *  2^4 = 2^2^2
     *  2^5 = 2* 2^4
     *  Deal with odd and even
     */
    public double pow(int x, int n){
        if(n<0){
            return pow(1/x, -n);
        }
        if(n==0){
            return 1;
        }
        else if(n==1){
            return x;
        }
        if(n==Integer.MIN_VALUE){
            return (x==1 || x==-1)? 1:0;
        }
        if(n%2==0){
            return pow(x*x, n/2);
        }
        else{
            return x * pow(x,n-1);
        }
    }
}
