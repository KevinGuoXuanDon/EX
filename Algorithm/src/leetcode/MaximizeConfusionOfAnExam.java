package leetcode;

/**
 * 给你一个字符串answerKey，其中answerKey[i]是第 i个问题的正确结果。除此以外，还给你一个整数 k，表示你能进行以下操作的最多次数：
 *
 * 每次操作中，将问题的正确答案改为'T' 或者'F'（也就是将 answerKey[i] 改为'T'或者'F'）。
 * 请你返回在不超过 k次操作的情况下，最大连续 'T'或者 'F'的数目。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：answerKey = "TTFF", k = 2
 * 输出：4
 * 解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
 * 总共有四个连续的 'T' 。
 
 */
public class MaximizeConfusionOfAnExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0, right = 0;
        int numsT = 0, numsF = 0;
        char[] chars = answerKey.toCharArray();
        int ans = 0;
        while(right<answerKey.length()){
            if(chars[right] == 'T'){
                numsT++;
            }
            else{
                numsF++;
            }
            if(numsF > k && numsT > k){
                if(chars[left] == 'T') {
                    numsT--;
                }
                else{
                    numsF--;
                }
                left++;
            }
            ans = Math.max(ans, right - left+1);
            right++;
        }
        return ans;
    }
}
