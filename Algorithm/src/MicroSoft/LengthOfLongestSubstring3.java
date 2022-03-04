package MicroSoft;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring3 {

    public int lengthOfLongestSubstringByHashMap(String s){
        int start = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            //如果已经包含当前字符
            if(map.containsKey(c)){
                //开始位置就从重复元素下一位开始,只能往后不能往前更新，防止abba
                start = Math.max(map.get(c)+1,start);
            }
            max = Math.max(max,i-start+1);
            map.put(c,i);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring3 l = new LengthOfLongestSubstring3();
        System.out.println(l.lengthOfLongestSubstringByHashMap("abba"));
    }

    //"dvdf"测试失败
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
        max=Math.max(count,max);
        return count;
    }
}
