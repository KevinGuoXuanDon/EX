package day21BitOperation;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数
 * 输入：n = 11 (控制台输入 00000000000000000000000000001011)
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 */
public class HammingWeight15 {

    //0ms 100%
    public int hammingWeight(int n) {
       int result=0;
       while(n!=0){
           result+=n&1;
           n>>>=1;
       }
       return result;
    }

}
