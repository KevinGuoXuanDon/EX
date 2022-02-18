package MicroSoft;

import java.util.*;

public class ReverseString151 {

    //清晰思路:
    public String reverseWords0(String s){
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length-1;
        StringBuilder str = new StringBuilder();
        //去除两端空格
        while(c[left]==' ') left++;
        while(c[right] == ' ') right--;
        while(left <= right){
            //从右往左找到一个单词，添加到stringbuilder里
            int index = right;
            while(index >= left && c[index] != ' ' ) index--;
            for(int i = index+1 ; i <= right ; i++ ) str.append( c[i] );
            //添加空格，更新右边界
            if(index > left) str.append(' ');
            while( index >= left && c[index]==' ' ) index--;
            right = index;
        }
        return str.toString();
    }

    //反向搜索6ms
    public String reverseWords(String s){
        boolean space=false;
        StringBuilder temp =new StringBuilder();
        StringBuilder stringBuilder =new StringBuilder();
        for (int i = s.length()-1; i >=0; i--) {
            char c = s.charAt(i);
            if(c!=' '){
                if(space && !temp.isEmpty()){
                    stringBuilder.append(temp);
                    stringBuilder.append(' ');
                    space=false;
                    temp=new StringBuilder();
                }
                temp.insert(0,c);
            }
            if(c==' ' && !temp.isEmpty()){
                space=true;
            }
        }
        stringBuilder.append(temp);
        return stringBuilder.toString();
    }
    //正向搜索5ms
    public String reverseWords2(String s){
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char c: s.toCharArray()) {
            if(c==' '){
                if(temp.isEmpty());
                else{
                    stringBuilder.insert(0,' ');
                    stringBuilder.insert(1,temp);
                    temp=new StringBuilder();
                }
            }
            else{
                temp.append(c);
            }
        }
        if(!temp.isEmpty()) stringBuilder.insert(0,temp);
        if(stringBuilder.charAt(0)==' ') stringBuilder.deleteCharAt(0);
        return stringBuilder.toString();
    }

    //8ms
    public String reverseWords3(String s){
        int left=0,right = s.length()-1;
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        while(left<right && s.charAt(left)==' ') left++;
        while(left<right && s.charAt(right)==' ') right--;
        while(left<=right){
            char cur=s.charAt(left);
            if(cur!=' ') builder.append(cur);
            if(cur==' ' && builder.length()!=0){
                deque.addFirst(builder.toString());
                builder.setLength(0);
            }
            left++;
        }
        deque.addFirst(builder.toString());
        return String.join(" ",deque);
    }

    //直接调用系统内部API似乎比我写的方法还要慢8s
    public String reverseWords4(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
    //官方给的solution也很慢 7s
    class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = trimSpaces(s);

            // 翻转字符串
            reverse(sb, 0, sb.length() - 1);

            // 翻转每个单词
            reverseEachWord(sb);

            return sb.toString();
        }

        public StringBuilder trimSpaces(String s) {
            int left = 0, right = s.length() - 1;
            // 去掉字符串开头的空白字符
            while (left <= right && s.charAt(left) == ' ') {
                ++left;
            }

            // 去掉字符串末尾的空白字符
            while (left <= right && s.charAt(right) == ' ') {
                --right;
            }

            // 将字符串间多余的空白字符去除
            StringBuilder sb = new StringBuilder();
            while (left <= right) {
                char c = s.charAt(left);

                if (c != ' ') {
                    sb.append(c);
                } else if (sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(c);
                }

                ++left;
            }
            return sb;
        }

        public void reverse(StringBuilder sb, int left, int right) {
            while (left < right) {
                char tmp = sb.charAt(left);
                sb.setCharAt(left++, sb.charAt(right));
                sb.setCharAt(right--, tmp);
            }
        }

        public void reverseEachWord(StringBuilder sb) {
            int n = sb.length();
            int start = 0, end = 0;

            while (start < n) {
                // 循环至单词的末尾
                while (end < n && sb.charAt(end) != ' ') {
                    ++end;
                }
                // 翻转单词
                reverse(sb, start, end - 1);
                // 更新start，去找下一个单词
                start = end + 1;
                ++end;
            }
        }
    }
    public static void main(String[] args) {
        ReverseString151 s = new ReverseString151();
        String a = s.reverseWords3(" Hello World ");
        System.out.println(a);
    }
}
