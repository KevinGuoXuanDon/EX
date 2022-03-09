package Huawei;
//查找String中的最长回文字串
// caabbaad         和 cabad
// aabbaa              aba
public class LongestPalindromeString {
    public int getLongestPalindrome (String A) {
        // write code here
        int max =1;
        for(int i=0;i<A.length();i++){
            //奇数时，从两边扩张
            int left = i-1;
            int right = i+1;
            while(left>=0 && right<=A.length()-1){
                if(A.charAt(left)==A.charAt(right)){
                    max = Math.max(max,right-left+1);
                }else{
                    break;
                }
                left--;
                right++;
            }
            //偶数时,从i-1和i开始
            left = i-1;
            right =i;
            while(left>=0 && right<=A.length()-1){
                if(A.charAt(left)==A.charAt(right)){
                    max = Math.max(max,right-left+1);
                }else{
                    break;
                }
                left--;
                right++;
            }
        }
        return max;
    }
}

//返回字符串而不是长度
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
