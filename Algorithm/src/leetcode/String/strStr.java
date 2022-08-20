package leetcode.String;

/**
 * 实现strStr()函数。
 *
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 *
 * 说明：
 *
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 *
 */
public class strStr {
    /**
     * 属于是shit代码= =， 不想写暴力但是对KMP还没有系统的去学习过,看来需要抽空去看一看。
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.equals("")){
            return 0;
        }
        for(int i=0; i<=haystack.length()-needle.length(); i++){
            boolean flag = false;
            for(int j =0; j< needle.length();j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    flag = false;
                    break;
                }
                else{
                    flag = true;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
}
