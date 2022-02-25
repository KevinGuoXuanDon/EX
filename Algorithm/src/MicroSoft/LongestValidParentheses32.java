package MicroSoft;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LongestValidParentheses32 {
    //1ms 100%
    public int longestValidParentheses(String s){
        char[] c = s.toCharArray();
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < c.length; i++) {
            if(c[i]==')'){
               if(i-dp[i-1]>0 && c[i-1-dp[i-1]]=='('){
                   //判断（左边是否还有有效括号，如()(()())
                    dp[i] = dp[i-1]+2+ (i-dp[i-1]-2>0 ? dp[i-2-dp[i-1]]:0);
                }
               max = Math.max(dp[i],max);
            }
        }

        return max;
    }
    //思路不对无法解决这类问题：()(()， 就算加一个数组来存储每次栈里多出来的（，时间和空间花销会变大
    // 更好的解法是用栈存储下表而不是括号。
    public int longestValidParenthesesByStack(String s) {
        char[] c=s.toCharArray();
        int max=0;
        Stack<Character> stack = new Stack<>();
        int count=0;
        for (int i = 0; i < c.length; i++) {
            if(c[i]=='(') stack.push(c[i]);
            else if(c[i]==')'){
                if(stack.isEmpty()) count=0;
                else{
                    count+=2;
                    stack.pop();
                    max=Math.max(max,count);
                }
            }
        }
        return max;
    }
    //2ms 55.62%
    public int longestValidParenthesesByStackCorrect(String s){
        char[] c = s.toCharArray();
        int max=0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(-1);
        for (int i = 0; i < c.length; i++) {
            if(c[i]=='('){
                stack.push(i);
            }
            else{
                //如果遇到的是),则弹出栈顶元素进行比对
                stack.pop();
                //如果弹出后栈空，则加入当前元素作为分割
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    //如果不为空，则这一段长度就是连续有效括号长,左开右闭直接减
                    max= Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
}
