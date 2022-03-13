package Huawei;

import java.util.*;
//倒转单词，只是这一次字母以外的字符和空格一样也作为间隔符
public class ReverseWordsII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.trim();
        //用StringBuilder更好嗷
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                ch[i] = ' ';
            }
        }

        String[] strings = new String(ch).split(" ");
        int n = strings.length;
        for (int i = n - 1; i >= 0; i--) {
            if (i != 0) {
                System.out.print(strings[i] + " ");
            } else {
                System.out.print(strings[i]);
            }
        }
    }
}
