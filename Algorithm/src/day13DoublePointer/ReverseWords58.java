package day13DoublePointer;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 */
public class ReverseWords58 {
    //1ms 100%
    //37.9MB    92.63%
    public String ReverseWords58(String s){
        StringBuilder stringBuilder = new StringBuilder();
        String[] sArray = s.split(" ");
        for (int i = sArray.length-1; i >=0 ; i--) {
            if(sArray[i].equals("")) continue;
            stringBuilder.append(sArray[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
