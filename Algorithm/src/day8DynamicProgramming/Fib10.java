package day8DynamicProgramming;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 */
public class Fib10 {
    //1.如果直接递归,大概率要超时，因为当n大的时候，计算量太大了，包含了过多的重复计算
    public int fib(int n){
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        return (fib(n-1)+fib(n-2))%1000000007;
    }
    //2. 在递归的基础上做一点点优化：添加一个数组储存每次计算好的数字，避免重复计算
    //0ms 100%
    //35.3MB 23.44%
    int[] fibs = new int[101];
    public int fib2(int n) {
        return recur(n);
    }
    public int recur(int n){
        if(n==0) return fibs[0]=0;
        if(n==1||n==2) return fibs[n]=1;
        if(fibs[n]==0) fibs[n] = (recur(n - 1) + recur(n - 2))%1000000007;
        return fibs[n];
    }
    //3.但是可以看到上面初始化了一个全局变量，在每次递归的时候添加，这需要占用一些空间，更好的方法是直接循环解决.
    //num1和num2分别代表最近的两个数字f(n-2),f(n-1)，k用作标记。
    //每一次循环执行时，k标记在num1上，num1和num2分别前进一位，直到num2正好站在n上，对应的k和num1就分别时n-2和n-1.
    //0 ms 100%
    //35MB 89.69%
    public int fib3(int n){
        if(n<2) return n;
        int num1=0,num2=1,k;
        for (int i = 2; i <= n; i++) {
            k=num1;
            num1=num2;
            num2=(k+num1)%1000000007;
        }
        return num2;
    }
}
