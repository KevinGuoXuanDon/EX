package leetcode.String;

/**
 * 请你设计一个文本编辑程序，需要编辑的稿件 article 为仅由大写字母、小写字母与空格组成的字符串（下标从 0 开始），光标所在字符串下标位置记作 index，程序运行后，若光标停留位置为空格，不作操作，返回原文本；否则光标所在位置对应的整个单词将被删除，并返回编辑后经过整理空格的文本。
 *
 * 注意：
 *
 * 输入保证字符串不以空格开头和结尾且不包含连续的空格。
 * 返回的字符串不以空格开头和结尾且不包含连续的空格。若删除单词后有多余的空格，需要删除。
 * 示例 1：
 *
 * 输入：article = "Singing dancing in the rain", index = 10
 *
 * 输出："Singing in the rain"
 *
 * 解释：
 * "Singing dancing in the rain" 光标位于 "dancing" 单词的字符 'n'
 * 删除光标所在的单词 "dancing" 及其前或后的一个空格。
 */
public class DesignTextEdit {
    public String deleteText(String article, int index) {
        StringBuilder sb = new StringBuilder();
        int start = index;
        int end = index;
        while(start>0 && article.charAt(start)!=' ') start--;
        while(end<article.length() && article.charAt(end)!=' ') end++;
        sb.append(article.substring(0,start)+article.substring(end));
        return sb.toString().trim();
    }
}
