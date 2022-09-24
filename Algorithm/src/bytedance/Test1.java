package bytedance;
import java.util.*;
import java.math.*;

/**
 * @author Xuandong Guo
 * @date 19/09/2022
 *
 * Question:
 * 字符串的全排列
 * 简单题，字节跳动技术一面的算法题.
 *
 * input: String s = "abc"
 * output: abc acb bac bca cba cab
 *
 */
public class Test1 {
    public static void main(String[] aregs){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            dfs(chars,0);
        }
    }

    public static void dfs(char[] chars, int index){
        if(index == chars.length){
            for(char c: chars){
                System.out.print(c);
            }
            System.out.println();
            return;
        }
        for(int i = index; i < chars.length; i++){
            swap(i,i+1,chars);
            dfs(chars,index+1);
            swap(i,i+1,chars);
        }
    }
    public static void swap(int i, int j, char[] chars){
        if(j==chars.length){
            return;
        }
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
