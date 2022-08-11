package leetcode.String;
import java.util.Collections;
import java.util.HashMap;
/**
 *
 */
public class LongestSubstringWithKDistinctCharacter {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, n=s.length();
        int max = 0;
        while(right<n){
            map.put(s.charAt(right),right);
            right++;
            if(map.size()>k){
                int idx = Collections.min(map.values());
                map.remove(s.charAt(idx));
                left = idx +1;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
