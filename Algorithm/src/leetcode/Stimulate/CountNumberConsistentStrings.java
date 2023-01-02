package leetcode.Stimulate;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xuandong Guo
 * @date 10/11/2022
 */
public class CountNumberConsistentStrings {

    public int countByIterator(String allowed, String[] words){
        int ans = words.length;
        for(String s : words){
            for(char c : s.toCharArray()){
                if(!allowed.contains(String.valueOf(c))){
                    ans --;
                    break;
                }
            }
        }
        return ans;
    }


    public int countConsistentStrings(String allowed, String[] words){
        Set<Character> set = new HashSet<>();
        for(char ele : allowed.toCharArray()){
            set.add(ele);
        }
        int count = 0;
        for(String s : words){
            boolean flag = true;
            for(char c : s.toCharArray()){
                if(!set.contains(c)){
                    flag = false;
                }
            }
            if(flag){
                count++;
            }
        }
        return count;
    }
}
