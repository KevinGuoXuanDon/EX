package leetcode.TraceBack;

/**
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 */
import java.util.*;
public class RecoverIP {
    List<String> list;
    public List<String> restoreIpAddresses(String s) {
        list = new ArrayList<>();
        backTrace(s,0,"",0);
        return list;
    }
    public void backTrace(String s, int index, String str, int seg){
        if(index == s.length() && seg==4){
            list.add(str.substring(0,str.length()-1));
            return;
        }
        //使用seg保证只有四个片段，如果到了四个还没遍历完s直接放弃，或者遍历了s还没找到四个片段也放弃
        if(seg == 4 || index==s.length()) return;
        for(int i=index; i<s.length(); i++){
            String target = s.substring(index,i+1);
            if(target.length()>3 ||(target.charAt(0)=='0' && target.length()>1))
                continue;
            int num = Integer.valueOf(target);
            if(num<0 || num>255) continue;
            backTrace(s,i+1,str+target+".",seg+1);
        }
    }

    public static void main(String[] args) {
        RecoverIP r = new RecoverIP();
        r.restoreIpAddresses("25525511135");
        r.list.stream().forEach(System.out::println);
    }
}
