package leetcode.Stimulate;

/**
 * 求解一个给定的方程，将x以字符串 "x=#value"的形式返回。该方程仅包含 '+' ， '-' 操作，变量x和其对应系数。
 *
 * 如果方程没有解，请返回"No solution"。如果方程有无限解，则返回 “Infinite solutions” 。
 *
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 *
 * 
 *
 * 示例 1：
 *
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 *
 */
public class SolveEquation {
    /**
     * 思路：可以进行先移项，再计算.
     * 需要计算普通值value的大小，计算x的prefix
     */
    public String solveEquation(String equation){
        int xNum = 0, value = 0;
        int ope = 1;
        int index = 0;
        int n = equation.length();
        while(index < n){
            int ope2 = ope;
            if(equation.charAt(index) =='='){
                ope2 = -1;
                index++;
            }
            if(equation.charAt(index)=='+' || equation.charAt(index) =='-'){
                ope2 = equation.charAt(index) == '-'? -ope2 : ope2;
                index++;
            }
            int number = 0;
            boolean prefix = false;
            if(index< n && Character.isDigit(equation.charAt(index))){
                number = number *10 + (equation.charAt(index)-'0');
                prefix = true;
                index++;
            }
            if(equation.charAt(index) == 'x'){
                // 可能是单个的x，也可能前面有前缀数字比如2x
                xNum += prefix? number * ope2 : ope2;
                index++;
            }
            else{
                // 不是x就是常数
                value += number * ope2;
            }
        }

        // 统计完了进行计算
        if(xNum==0){
            // 如果 0x =0， 无限解。 如果 0x = 常数,无解
            return value==0? "Infinite solutions" : "No solution";
        }
        return "x="+ (-value/xNum);
    }
}
