package day4LookingUp;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 */
public class FirstUniqChar50 {
    //26ms 32.19%
    //38.9mb 8.39%
    public char firstUniqChar(String s) {
        char result=' ';
        Map<Character,Integer> map= new HashMap();
        for (int i = 0; i <s.length() ; i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1){
                result=s.charAt(i);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String i ="leetcode";
        FirstUniqChar50 f = new FirstUniqChar50();
        f.firstUniqChar(i);
    }
}
