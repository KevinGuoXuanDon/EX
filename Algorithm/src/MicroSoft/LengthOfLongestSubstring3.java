package MicroSoft;

import java.util.HashSet;

public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s){
        int count = 0;
        int max=Integer.MIN_VALUE;
        HashSet<Character> hashSet = new HashSet<>();
        for(char c:s.toCharArray()){
            if(hashSet.contains(c)){
                max=Math.max(count,max);
                count = 0;
                hashSet.clear();
            }
            count++;
            hashSet.add(c);
        }
        return count;
    }
}
