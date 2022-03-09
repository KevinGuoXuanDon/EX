package leetcode;
import java.util.*;
public class StringArrangement {
    Set<String>  set = new HashSet<>();
    public String[] permutation(String s) {
        if(s.length()==0) return new String[0];
        boolean[] flag = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        backTrack(chars,sb,flag);
        return set.toArray(new String[0]);
    }
    public void backTrack(char[] chars, StringBuilder sb, boolean[] flag){
        if(sb.length() == chars.length){
            set.add(sb.toString());
            return;
        }
        for(int i=0; i<chars.length; i++){
            if(flag[i]) continue;
            flag[i] = true;
            sb.append(chars[i]);
            backTrack(chars,sb,flag);
            flag[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
