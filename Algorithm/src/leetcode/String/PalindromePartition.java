package leetcode.String;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 */
import java.util.*;
public class PalindromePartition {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();
    public List<List<String>> partition(String s){
        traceBack(s,0);
        return res;
    }
    public void traceBack(String s, int index){
        if(index==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<s.length();i++){
            String sub = s.substring(index,i+1);
            if(isPalindrome(sub)){
                list.add(sub);
                traceBack(s,i+1);
                list.removeLast();
            }
        }
    }

    private boolean isPalindrome(String sub) {
        int left = 0, right = sub.length()-1;
        while(sub.charAt(left)==sub.charAt(right)){
            left++;
            right--;
            if(left>=right) return true;
        }
        return false;
    }

}
