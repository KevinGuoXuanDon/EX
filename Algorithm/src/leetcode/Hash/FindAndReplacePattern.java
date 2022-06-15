package leetcode.Hash;

/**
 * 你有一个单词列表words和一个模式pattern，你想知道 words 中的哪些单词与模式匹配。
 *
 * 如果存在字母的排列 p，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 *
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 *
 * 返回 words 中与给定模式匹配的单词列表。
 *
 * 你可以按任何顺序返回答案。
 */
import java.util.*;
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(int i =0; i<words.length; i++){
            String word = words[i];
            if(match(word,pattern) && match(pattern,word))
                res.add(word);
        }
        return res;
    }
    public boolean match(String word, String pattern){
        HashMap<Character,Character> map = new HashMap<>();
        for(int i = 0; i<word.length(); i++){
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if(!map.containsKey(w)){
                map.put(w,p);
            }
            else if(map.get(w)!=p){
                return false;
            }
        }
        return true;
    }
}

