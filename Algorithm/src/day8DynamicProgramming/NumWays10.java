package day8DynamicProgramming;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class NumWays10 {
    //可以把这题看成斐波那契数列，因为除了n=1或者0时，其他任何情况最后一步都可以看作跳一步和跳两步。
    //如果是跳一步，此时的跳法就是f(n-1)个，如果是跳两步，此时的跳法就是f(n-2)
    //可以得出的是f(n)=f(n-1)+f(n-2)
    //0ms 100%
    public int numWays(int n){
        if(n<2) return 1;
        if(n==2) return 2;
        int num1=1,num2=2,sum;
        for (int i = 3; i <= n; i++) {
            sum=num1;
            num1=num2;
            num2=(num1+sum)%1000000007;
        }
        return num2;
    }
}
