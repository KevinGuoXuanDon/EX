package StimulationTest;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 去除重复字符，只保留首位
 */
public class C3111 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(set.contains(c)) continue;
            sb.append(c);
            set.add(c);
        }
        System.out.println(sb.toString());
    }
}
