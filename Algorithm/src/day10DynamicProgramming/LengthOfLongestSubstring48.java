package day10DynamicProgramming;

import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

 * 示例1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring48 {
    // 4ms 92.64%
    // 38.1MB 92.43%
    public int lengthOfLongestSubstring(String s){
        if(s==null) return 0;
        if(s.length()==1) return 1;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        int cur=1,max=1;//cur=currentLength, max = maxLength
        for (int i = 1; i < s.length(); i++) {
            int indexOfRepeat = map.getOrDefault(s.charAt(i),-1);//得到最左边的重复字符对应的索引
            cur = cur<i-indexOfRepeat ? cur+1 : i-indexOfRepeat;//如果在当前长度之中找到了重复元素，舍弃重复元素前半部分，接着往后遍历，如果当前长度之前出现重复元素，那么没关系接着遍历.
            max=Math.max(cur,max);
            map.put(s.charAt(i),i);
        }
        return max;
    }
}
