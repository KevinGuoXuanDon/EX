package Huawei;

import java.lang.reflect.Array;
import java.util.*;

public class BrotherWord {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String target = s[s.length-2];
        char[] tc= target.toCharArray();
        Arrays.sort(tc);
        List<String> list = new LinkedList<>();
        int k = Integer.parseInt(s[s.length-1]);
        int n = Integer.parseInt(s[0]);
        for (int i = 1; i < s.length-3; i++) {
            if(s[i].length()!=target.length() || s[i].equals(target)){
                continue;
            }
            else{
                char[] cc = s[i].toCharArray();
                Arrays.sort(cc);
                if(new String(cc).equals(new String(tc))){
                    list.add(s[i]);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        if(list.size()>=k) System.out.println(list.get(k-1));
    }
}
