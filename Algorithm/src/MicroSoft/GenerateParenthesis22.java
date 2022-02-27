package MicroSoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis22 {
    //回溯算法，当左括号右括号数量相等时优先添加左括号，然后在每个位置尝试插入括号，其实回溯就是暴力法的递归形式
    //1ms  74.99，顺带一提这里使用StringBuilder和String空间消耗类似，时间复杂度都为O(n)
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        if(n<=0) return list;
        StringBuilder s = new StringBuilder();
        recur(list,s,n,n);
        return list;
    }

    public void recur(List<String> list, StringBuilder s, int left, int right) {
        if(left == 0 && right ==0){
            list.add(s.toString());
            return;
        }
        if(left>=right){
            recur(list,s.append("("),left-1,right);
        }else{
            if(left>0) {
                recur(list,s.append("("),left-1,right);
                s.deleteCharAt(s.length()-1);
            }
            recur(list,s.append(")"),left,right-1);
        }
        s.deleteCharAt(s.length()-1);
    }
}
