package StimulationTest;

import java.util.*;

public class FullPermutation {
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s= String.valueOf(chars);
        boolean[] visited = new boolean[s.length()];
        backTrace(0,s,sb,visited);
        set.stream().forEach(System.out::println);
    }
    public static void backTrace(int index, String s, StringBuilder sb, boolean[] visited){
        if(index == s.length()){
           set.add(sb.toString());
           return;
        }
        for(int i=0;i<s.length();i++){
            if(visited[i] || (i!=0 && !visited[i-1] &&s.charAt(i)==s.charAt(i-1))) continue;
            visited[i] = true;
            sb.append(s.charAt(i));
            backTrace(index+1,s,sb,visited);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }
}
