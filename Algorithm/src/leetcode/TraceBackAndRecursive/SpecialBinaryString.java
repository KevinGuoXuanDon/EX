package leetcode.TraceBackAndRecursive;

/**
 * 特殊的二进制序列是具有以下两个性质的二进制序列：
 *
 * 0 的数量与 1 的数量相等。
 * 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
 * 给定一个特殊的二进制序列S，以字符串形式表示。
 * 定义一个操作 为首先选择S的两个连续且非空的特殊的子串，然后将它们交换。
 * （两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
 *
 * 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
 *
 * 示例 1:
 *
 * 输入: S = "11011000"
 * 输出: "11100100"
 * 解释:
 * 将子串 "10" （在S[1]出现） 和 "1100" （在S[3]出现）进行交换。
 * 这是在进行若干次操作后按字典序排列最大的结果。
 
 */
import java.util.*;
public class SpecialBinaryString {
    /**
     *
     * 思路：把他们比作括号parentheses
     * 1 10 1100 0
     * ( () (()) )
     * 把总字符串看成若干个组成括号的子字符串，这些子字符串都不能再分割
     * 那么以最大字典排序就是相当于把每一个括号内部的子括号们排序
     * 对最外层括号来说，只要处理 () (())  -> (()) ()
     */
    public String makeLargestSpecial(String s){
        return recursive(s,0,s.length()-1);
    }

    public String recursive(String s , int start, int end){
        if(start>end){
            return "";
        }
        List<String> list = new ArrayList<>();
        int count=0;
        int pre=start;
        for(int i= start; i<=end; i++){
            if(s.charAt(i) == '1'){
                count++;
            }
            else{
                count--;
                if(count == 0){
                    // 处理中间字串
                    String cur = "1"+recursive(s,pre+1,i-1)+"0";
                    list.add(cur);
                    pre = i+1;
                }
            }
        }
        list.sort(Comparator.reverseOrder());
        return String.join("",list);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("10");
        list.add("1100");
        list.sort(Comparator.reverseOrder());
        list.stream().forEach(System.out::println);

    }
}
