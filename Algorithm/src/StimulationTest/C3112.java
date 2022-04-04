package StimulationTest;

import java.util.Scanner;

/**
 * 字符串压缩,返回压缩后的结果.
 * 字符串压缩规则：
 * 1. 只压缩连续出现的字符
 * 2. 压缩后把重复字符转变为数字表示
 * 输入：
 * xxxyyyyz
 * 输出：
 * 3x2yz
 */
public class C3112 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            int flag = 1;
            for (int i = 0; i < str.length() - 1; i++) {
                char cur = str.charAt(i);
                char next = str.charAt(i + 1);
                if (cur != next) {
                    sb.append(cur);
                    if(i==str.length()-2) sb.append(str.charAt(i+1));
                    flag = 1;
                    continue;

                } else {
                    while (cur == next) {
                        flag++;
                        i++;
                        if (i + 1 == str.length()) {
                            break;
                        }
                        cur = str.charAt(i);
                        next = str.charAt(i + 1);
                    }
                    sb.append(flag + "" + cur);
                    flag=1;
                    if(i==str.length()-2) sb.append(str.charAt(i+1));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
