package leetcode.TraceBack;
import  java.util.*;
public class GenerateBracket {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrace(n,n,sb);
        return list;
    }
    public void backTrace(int left, int right, StringBuilder sb){
        if(left==0 && right ==0){
            list.add(sb.toString());
        }
        if(left<0 || right<0 || right>left) return;
        backTrace(left-1,right,sb.append("("));
        sb.deleteCharAt(sb.length()-1);
        backTrace(left,right-1,sb.append(")"));
        sb.deleteCharAt(sb.length()-1);
    }
}
