package Huawei;
import java.util.*;

/**
 * 对输入的字符串进行加解密，并输出。
 *
 * 加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 */
public class StringEncryptionDecryption {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String org = sc.nextLine();
        String enc = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(char c: org.toCharArray()){
            if(Character.isUpperCase(c)){
                if(c=='Z'){
                    sb.append('a');
                }
                else{
                    sb.append((char) (Character.toLowerCase(c)+1));
                }
            }
            else if(Character.isLowerCase(c)){
                if(c=='z') sb.append('A');
                else sb.append(Character.toUpperCase((char)(c+1)));
            }
            else if(Character.isDigit(c)){
                if(c=='9') sb.append('0');
                else sb.append((char)(c+1));
            }
            else sb.append(c);
        }
        System.out.println(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        for(char c: enc.toCharArray()){
            if(Character.isUpperCase(c)){
                if(c=='A'){
                    sb2.append('z');
                }
                else{
                    sb2.append((char) (Character.toLowerCase(c)-1));
                }
            }
            else if(Character.isLowerCase(c)){
                if(c=='a') sb2.append('Z');
                else sb2.append(Character.toUpperCase((char)(c-1)));
            }
            else if(Character.isDigit(c)){
                if(c=='0') sb2.append('9');
                else sb2.append((char)(c-1));
            }
            else sb2.append(c);
        }
        System.out.println(sb2.toString());
    }
}
