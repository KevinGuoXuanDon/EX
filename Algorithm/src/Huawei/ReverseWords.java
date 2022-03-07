package Huawei;
import java.util.*;
//反转语言,记得处理空格.最简单的方法直接trim和split，然后倒序便利
// Hello World
//world Hello
public class ReverseWords {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s =  sc.nextLine();
        String result = reverseWords(s);
        System.out.println(result);
//        LinkedList<String> list = new LinkedList<>();
//        StringBuilder sb = new StringBuilder();
//        //最好解法还是下面的双指针
//        for(char c : s.toCharArray()){
//            if(c!=' '){
//                sb.append(c);
//            }
//            else{
//                if(sb.length()!=0) {
//                    list.addFirst(sb.toString());
//                    sb = new StringBuilder();
//                }
//            }
//        }
//        if(sb.length()!=0) list.addFirst(sb.toString());
//        for (int i = 0; i < list.size(); i++) {
//             System.out.print( i==(list.size()-1)? list.get(i): list.get(i)+" ");
//        }
    }
    public static String reverseWords(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length-1;
        StringBuilder str = new StringBuilder();
        while(c[left]==' ') left++;
        while(c[right] == ' ') right--;
        while(left <= right){
            int index = right;
            while(index >= left && c[index] != ' ' ) index--;
            for(int i = index+1 ; i <= right ; i++ ) str.append( c[i] );
            if(index > left) str.append(' ');
            while( index >= left && c[index]==' ' ) index--;
            right = index;
        }
        return str.toString();
    }
}
