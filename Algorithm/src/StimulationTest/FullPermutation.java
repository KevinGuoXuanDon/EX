package StimulationTest;

import java.util.*;
//似乎排序不排序都可以
//但是如果只是需要计算重新排列的数量，参照下面的方法mmmain
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

    /**
     * 解题思路
     * 先把每个字符当成唯一出现过一次，计算所有排列数；再统计重复出现的字母，除去每个字母的排列次数
     *
     * 例如
     * 对于ABA，当成三个不同字符则排列数为S总=A33.其中A出现两次，排列数为sA=A22,B出现一次为SB=A11,最后s=s总/（sA*Sb）
     * @param args
     */
    public static void mmmain(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int allSort = Asort(n);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for (char key : map.keySet()) {
            allSort /= Asort(map.get(key));
        }
        System.out.println(allSort);
    }
    public static int Asort(int n){
        if(n == 1)
            return 1;
        return n * Asort(n-1);
    }
}
