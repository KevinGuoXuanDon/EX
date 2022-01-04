package day3;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 使用切片可以拿内存消耗换时间复杂度
 * 使用StringBuilder拿时间复杂度换内存消耗
 */
public class ReverseLeftWords58 {
    //第一次切片加添加
    //3 ms 44%；	38.2 MB	57%
    public String reverseLeftWords(String s, int k) {
        StringBuilder stringBuilder= new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return s.substring(k)+stringBuilder.toString();
    }
    //第二种 添加和删除
    //时间11ms，7.99%；空间38.1mb，71.96
    public String reverseLeftWords2(String s, int k) {
        //通过字符串得到stringbuilder
        StringBuilder stringBuilder= new StringBuilder(s);
        //实现左旋
        for (int i = 0; i < k; i++) {
            //在末尾添加字符
            stringBuilder.append(s.charAt(i));
            //在头部删除字符
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }
    //第三种：纯切片
    // 0ms, 100%; 38.3ms, 24.32%
    public String reverseLeftWords3(String s, int k){
        return s.substring(k) + s.substring(0, k);
    }
}
