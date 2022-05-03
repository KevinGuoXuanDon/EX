package leetcode.String;

/**
 * 给你一个表示某个正整数的字符串 number 和一个字符 digit 。
 *
 * 从 number 中 恰好 移除 一个 等于digit 的字符后，找出并返回按 十进制 表示 最大 的结果字符串。生成的测试用例满足 digit 在 number 中出现至少一次。
 *
 * 示例 1：
 *
 * 输入：number = "123", digit = "3"
 * 输出："12"
 * 解释："123" 中只有一个 '3' ，在移除 '3' 之后，结果为 "12" 。
 *
 */

public class RemoveDigitForMaxValue {
    // 严格来说其实算贪心算法，当前位置的值如果比后面的小，移除当前的整体值肯定要变大。基于这个思想解题
    public String removeDigit(String number, char digit) {
        int last=0;
        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);
            if(cur==digit){
                last = i;
                if(i==number.length()-1 || cur>number.charAt(i+1)){
                    return number.substring(0,last)+number.substring(last+1);
                }
            }
        }
        return number.substring(0,last)+number.substring(last+1);
    }
}
