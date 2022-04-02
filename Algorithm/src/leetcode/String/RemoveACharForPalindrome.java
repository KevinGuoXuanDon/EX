package leetcode.String;

/**
 * 给定一个非空字符串s，请判断如果最多 从字符串中删除一个字符能否得到一个回文字符串。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * 示例 3:
 *
 * 输入: s = "abc"
 * 输出: false
 */
public class RemoveACharForPalindrome {
    //简单双指针,在遇到不同时，如果同时模拟删除左边和右边的，其中一个能得出结果就行
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return getValid(s,left+1,right) || getValid(s,left,right-1);
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
    public boolean getValid(String s, int left, int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}
