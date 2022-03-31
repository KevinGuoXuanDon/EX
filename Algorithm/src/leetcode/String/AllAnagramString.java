package leetcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串jsj和jp，找到jsj中所有 p 的j变位词j的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 变位词 指字母相同，但排列不同的字符串。
 *
 * j
 *
 * 示例j1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 */
public class AllAnagramString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if(n>m) return list;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(char c : p.toCharArray()){
            count1[c-'a']++;
        }
        int left = 0;
        int right = n-1;
        for(int i=left; i<=right; i++){
            char c = s.charAt(i);
            count2[c-'a']++;
        }
        if(Arrays.equals(count1,count2)) list.add(left);
        while(right<m-1){
            char leftChar = s.charAt(left);
            count2[leftChar-'a']--;
            left++;
            right++;
            char rightChar = s.charAt(right);
            count2[rightChar-'a']++;
            if(Arrays.equals(count1,count2)) list.add(left);
        }
        return list;
    }
}
