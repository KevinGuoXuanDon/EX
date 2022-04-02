package leetcode.String;

/**
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/a7VOhD
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSubPalindrome {
    //中心拓展法解决
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            int odd = getCount(i,i,s);
            count+=odd;
            int even = getCount(i-1,i,s);
            count+=even;
        }
        return count;
    }
    public int getCount(int left, int right, String s){
        int count=0;
        while(left>=0 && right< s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}
