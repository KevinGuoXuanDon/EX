package leetcode.Stimulate;

/**
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 *
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "011101"
 * 输出：5
 * 解释：
 * 将字符串 s 划分为两个非空子字符串的可行方案有：
 * 左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
 * 左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
 * 左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
 * 左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
 * 左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
 */
public class MaxScoreAfterSplittingAString {
    // 简单模拟即可，从index=0开始模拟分割点往右边移动过程
    public int maxScore(String s){
        int countOne =0;
        int res = 0;
        for(char i : s.toCharArray()){
            countOne+= i-'0';
        }
        int leftZero = 0;
        int leftOne = 0;
        // 一开始分割点在0，左边只有第一位，其他的都在右边.
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                leftZero++;
            }
            else{
                leftOne++;
            }
            // 计算此时的值, 右边的1+左边的0. 其中右边的1= 总1数量-左边的1的数量
            res = Math.max(res, countOne-leftOne+leftZero);
        }
        return res;
    }
}
