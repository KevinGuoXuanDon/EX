package leetcode.TraceBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombinationsOfPhoneNumber {
    private final String[] letters = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.length()==0) return res;
        recur(res,"",0,digits);
        return res;
    }

    // 并且这题用StringBuilder 是要比直接用String要快的
    public void recur(List<String> list, String s, int index, String digits){
        // 注意这里是 s.length() 而不是 index ,否则会出现最后数字对应的字母，比如输入"23",会得到"e"
        if(s.length() == digits.length()){
            list.add(s);
            return;
        }
        for(int i = index; i<digits.length();i++){
            String get = letters[digits.charAt(i)-'0'];
            for(char c: get.toCharArray()){
                recur(list,s+c,i+1,digits);
            }
        }

    }
}
