package leetcode.String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 */
public class DecodeString {
    /**
     * Stack模拟，用了ArrayDeque双端队列来帮助处理，一次遍历，但是在中间需要对编码进行解码模拟，中间的数字会影响迭代次数
     * 比如300[abc], 则temp = "abc", number = 300, 在stack中添加abc三百次。
     * 如果是嵌套的编码，比如 300[300[ab]c], 先对300[ab]进行解码，加上c后在进行300次解码，迭代次数就会变成900
     * 所以时间复杂度其实主要取决于中间的嵌套次数和前面的数字大小.
     *
     * 官方解决思路中的栈解决和我相同，但是下方评论区有指出逻辑更强的解决思路： 双栈，一个装数字，一个装字符，类似于四则运算
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            StringBuilder temp = new StringBuilder();
            if (cur == ']') {
                while (!stack.isEmpty() && stack.peek() != '[') {
                    temp.insert(0,stack.pop());
                }
                stack.pop();
                int number = 0;
                // 32[ab]
                int carry = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    number += stack.pop() * carry;
                    carry *= 10;
                }
                for (int j = 0; j < number; j++) {
                    for (char c : temp.toString().toCharArray()) {
                        stack.push(c);
                    }
                }
                System.out.println(number + " " + temp.toString());
            } else {
                stack.push(cur);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}
