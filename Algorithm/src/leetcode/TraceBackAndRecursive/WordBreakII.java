package leetcode.TraceBackAndRecursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个字符串字典wordDict，在字符串s中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 *
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 *
 * 示例 1：
 *
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 */
public class WordBreakII {
    private List<String> res= new ArrayList<>();
    private HashSet<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        LinkedList<String> list = new LinkedList<>();
        traceBack(s,0,list);
        return res;
    }
    public void traceBack(String s, int index, LinkedList<String> list){
        if(index == s.length()){
            res.add(String.join(" ",list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index,i+1);
            if(set.contains(sub)){
                list.add(sub);
                traceBack(s,index+1,list);
                list.removeLast();
            }
        }
    }
}
