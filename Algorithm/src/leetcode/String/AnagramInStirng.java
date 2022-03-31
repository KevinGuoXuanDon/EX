package leetcode.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramInStirng {
    public boolean checkInclusionByWindow(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m>n) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(char i :s1.toCharArray()){
            count1[i-'a']++;
        }
        //从这里开始维护一个长度为m的窗口进行比对
        int left = 0;
        int right = m-1;
        for(int i = left; i<=right; i++){
            count2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(count1,count2)) return true;
        while(right<n-1){
            //左窗口往右移动
            char leftChar = s2.charAt(left);
            count2[leftChar-'a']--;
            left++;
            //右窗口同时也要往右边移动
            right++;
            char rightChar = s2.charAt(right);
            count2[rightChar-'a']++;
            if(Arrays.equals(count1,count2)) return true;
        }
        return false;
    }
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> temp = new HashMap<>();
        for(char i: s1.toCharArray()){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i=0; i<s2.length(); i++){
            char cur = s2.charAt(i);
            if(!map.containsKey(cur)){
                continue;
            }
            else{
                int j = i;
                int count=0;
                while(count<s1.length() && j<s2.length() && map.containsKey(s2.charAt(j))){
                    temp.put(s2.charAt(j),temp.getOrDefault(s2.charAt(j),0)+1);
                    j++;
                    count++;
                }
                if(map.equals(temp)) return true;
                else temp.clear();
            }
        }
        return false;
    }
    public static void main(String[] args) {
       AnagramInStirng a = new AnagramInStirng();
       a.checkInclusion("hello","ooolleoooleh");
    }
}
