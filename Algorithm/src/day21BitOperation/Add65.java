package day21BitOperation;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class Add65 {
    public int add(int a , int b){
        if(a==0) return b;
        if(b==0) return a;
        return  add(a^b,(a&b)<<1);
        //异或运算 + 与运算进位
        //    20 = 0 0 0 1 0 1 0 0
        //    17 = 0 0 0 1 0 0 0 1
        //   a^b = 0 0 0 0 0 1 0 1
        //   进位 = 0 0 1 0 0 0 0 0
        // result= 0 0 1 0 0 1 0 1  = 37
    }


}
