package day3;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace05 {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:s.toCharArray()) {
            if(c==' ') stringBuilder.append("%20");
            else stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：36.1 MB, 在所有 Java 提交中击败了85.87%的用户
}
