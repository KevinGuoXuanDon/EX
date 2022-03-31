package leetcode.String;

import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长连续子字符串的长度。
 *
 * 
 *
 * 示例j1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 */
public class NoRepeatLongestSubString {
    //我用了一个hashmap用作滑动窗口，当没有重复时一直添加，遇见重复时，从左边开始删除元素，直到重复元素被删除。
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1) return s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,i);
                max = Math.max(max,map.size());
            }
            else{
                int end= map.get(c);
                int start = i-map.size();
                for(int j = start; j<end;j++){
                    char rc = s.charAt(j);
                    map.remove(rc);
                }
                map.put(c,i);
            }
        }
        return max;
    }
}
