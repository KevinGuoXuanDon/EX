package day20DivideAndConquer;

/**
 * 实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 */
public class MyPow16 {

    //最快写法: return Math.pow(x,n)  (哒咩)..

    //0ms 100%
    //40.2MB 4.99%
    //这里节省时间复杂度的方式是，通过2来计算，每次递归都会使得指数减少一半
    //从x开始，每次直接把上一次的结果进行平方，计算 6 次就可以得到 x^{64} 的值，而不需要对x乘63次x。
    //而n为奇数时，则适当的多乘几次x
    //递归会用栈，迭代可以节省空间复杂度，其实这种算法可以看成把n转换成二进制来计算了。
    public double myPow(double x, int n){
        //改成long类型怕越界
        long N=n;
        //如果N>0,则自乘，小于0则取分母
        return n>0? recur(x,N):1.0/recur(x,-N);
    }
    public double recur(double x, long n){
        if (n==0) return 1.0;
        double y = recur(x, n/2);
        return n%2==0? y*y:y*y*x;
    }


    public double myPowByIteration(double x, int n){
        if(n==0) return x;
        long N = n;
        return n>0? itera(x,N):1.0/itera(x,-N);
    }
    public double itera(double x, long n){
        double result = 1.0;
        while(n>0){
            if(n%2==1) result *=x;
            x*=x;
            n/=2;
        }
        return result;
    }

    public static void main(String[] args) {
        MyPow16 my = new MyPow16();
        System.out.print(my.myPow(2.0,-1));
    }
}
