package day19SearchAndBacktracking;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 输入: n = 3
 * 输出: 6
 * 输入: n = 9
 * 输出: 45
 */
public class SumNums64 {
    public int sumNumsFalse(int n){
        if(n==1) return 1;
        return n+sumNums(n-1);
    }
    //用布尔值来代替if,只有n>0的时候才会进行后半句的操作
    //0ms
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        SumNums64 s = new SumNums64();
        System.out.println(s.sumNums(9));
    }
}
