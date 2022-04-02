package leetcode.String;

/**
 * 给定两个字符串 s 和t 。返回 s 中包含t的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 *
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 *
 * 
 *
 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC" 
 * 解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
 */
public class ContainsAllCharsInMinLengthSubString {
    // 方法和以前一行还是滑动窗口
    // 只是这次判断从Arrays.equal变成了包含,从只含小写变成有大小写，所以用60个位置储存
    public String minWindow(String s, String t) {
        int[] count1 = new int[60];
        int[] count2 = new int[60];
        int m = s.length();
        int n = t.length();
        if(m<n) return "";
        for(char c : t.toCharArray()){
            count1[c-'A']++;
        }
        int left = 0, right = n;
        for(int i = left; i<right; i++){
            char c = s.charAt(i);
            count2[c-'A']++;
        }
        String ans="";
        if(cover(count2,count1)) return s.substring(left,right);
        int minLength = m;
        while(left<right && right<m){
            char rightChar = s.charAt(right);
            count2[rightChar-'A']++;
            right++;
            while(cover(count2,count1)){
                //长度更小时更新
                if(right-left<=minLength){
                    minLength = right-left;
                    ans = s.substring(left, right);
                }
                char leftChar = s.charAt(left);
                count2[leftChar-'A']--;
                left++;
            }
        }
        return ans;
    }
    public boolean cover(int[] ct1, int[] ct2){
        for(int i=0; i<ct2.length; i++){
            if(ct1[i]<ct2[i]) return false;
        }
        return true;
    }
}
