import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class IsValid {
    public boolean isValid(String s) {
        if(s.length()%2==1) return false;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if('('==c || '[' ==c || '{' ==c ){
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) return false;
                if(c ==')' && stack.pop()!='('){
                    return false;
                }
                if(c =='}' && stack.pop()!='{'){
                    return false;
                }
                if(c ==']' && stack.pop()!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
