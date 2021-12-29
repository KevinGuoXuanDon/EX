package day1;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class StackIncludeMin30 {
    private Stack<Integer> stack1;
    private Stack<Integer> stackMin;

    public StackIncludeMin30() {
        stack1 = new Stack<>();
        stackMin = new Stack<>();
    }
    public void push(int x) {
        stack1.push(x);
        if(stackMin.empty() || stackMin.peek()> x)
            stackMin.push(x);
        else stackMin.push(stackMin.peek());
    }

    public void pop() {
        stack1.pop();
        stackMin.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
//执行用时：17 ms, 在所有 Java 提交中击败了94.49%的用户
//内存消耗：40.4 MB, 在所有 Java 提交中击败了20.92%的用户
