package day1LineStack;

import java.util.Stack;

/**
 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 1 <= values <= 10000
 最多会对 appendTail、deleteHead 进行 10000 次调用
 */
public class ImplementQueueByTwoStack09 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public ImplementQueueByTwoStack09() {
       stack1=new Stack<>();
       stack2=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.isEmpty() ? -1 : stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}
//时间复杂度O(2n),打败6%
//空间复杂度打败了80% （因为就两个栈在互相倒腾）
