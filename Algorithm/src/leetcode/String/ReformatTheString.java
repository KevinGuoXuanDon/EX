package leetcode.String;
import java.util.*;
public class ReformatTheString {
    public String reformat(String s) {
        /**
         * Time complexity O(n), Space complexity O(n)
         * Try to squeeze space complexity to O(1) By using DoublePointer
         */
        Queue<Character> num = new LinkedList<>();
        Queue<Character> chars = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num.add(c);
            }
            else{
                chars.add(c);
            }
        }
        if(Math.abs(num.size()-chars.size())<=1){
            for(int i =0; i<num.size(); i++ ){
                sb.append(num.poll());
                if(!chars.isEmpty()) sb.append(chars.poll());
            }
            if(!chars.isEmpty()){
                sb.insert(0,chars.poll());
            }
            return sb.toString();
        }
        else{
            return "";
        }
    }


    public String reformatByDoublePointer(String s){
        int numSize = 0;
        int stringSize = 0;
        char[] chars = s.toCharArray();
        for(char c: chars){
            if(Character.isDigit(c)){
                numSize++;
            }
            else stringSize++;
        }
        if(Math.abs(numSize-stringSize)>1){
            return "";
        }
        // flag 假设数字多，占据偶数位置,也就是下面的i为数字
        boolean flag = numSize>stringSize;
        int i =0, j =1;
        while(i<chars.length){
            // 那么什么时候需要交换？ i表示的位置不为数字，j为数字时，交换
            if(Character.isDigit(chars[i])!=flag){
                // j为字母的话自增,直到j为数字
                while(Character.isDigit(chars[j]) != flag){
                    j+=2;
                }
                swap(i,j,chars);
            }
            i+=2;
        }
        return new String(chars);
    }
    public void swap(int i, int j ,char[] chars){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
