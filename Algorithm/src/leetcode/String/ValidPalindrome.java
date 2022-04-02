package leetcode.String;

import java.util.Locale;

/**
 * 给定一个字符串 s ，验证 s是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 本题中，将空字符串定义为有效的回文串。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/XltzEq
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidPalindrome {
    //简单双指针+Characters.isLetterOrDigit()
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        String target = s.toLowerCase();
        while(left<right){
            char leftChar = target.charAt(left);
            char rightChar = target.charAt(right);
            while(left<right && !Character.isLetterOrDigit(leftChar)){
                left++;
                leftChar=target.charAt(left);
            }
            while(left< right && !Character.isLetterOrDigit(rightChar)) {
                right--;
                rightChar= target.charAt(right);
            }
            if(leftChar!=rightChar) return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}
