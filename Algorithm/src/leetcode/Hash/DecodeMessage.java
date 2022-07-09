package leetcode.Hash;
import java.util.*;


public class DecodeMessage {
    // Hash解题
    public String decodeMessage(String key, String message) {
        Map<Character,Character> map = new HashMap<>(26,0.75f);
        map.put(' ',' ');
        char idx = 'a';
        for(char c:key.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,idx);
                idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:message.toCharArray()){
            if(map.containsKey(c)){
               sb.append(map.get(c));
            }
        }
        return sb.toString();
    }

    // 使用数组模拟MAP
    public String decodeMessageByArr(String key, String message){
        char[] chars = new char[26];
        char idx = 'a';
        for(char c:key.toCharArray()){
            if(c==' ')
                continue;
            if(chars[c-'a']==0){
                chars[c-'a']=idx;
                idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:message.toCharArray()){
            if(c==' ')
                sb.append(' ');
            else
                sb.append(chars[c-'a']);
        }
        return sb.toString();
    }

}
