package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class ReversePrint06 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * 通过栈解决,性能明显不是很强
     * 时间消耗：1ms, 69.24%
     * 内存消耗：38.9MB，56.03%
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head){
        Stack<Integer> stack= new Stack<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=stack.pop();
        }
        return result;
    }

    /**
     * 通过数组解决
     * 时间消耗：0ms
     * 内存消耗：39.1MB，32.35%
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        int size=0;
        ListNode start = head;
        while (start!=null){
            size++;
            start=start.next;
        }
        start = head;
        int[] result = new int[size];
        for (int i = size-1; i >=0 ; i--) {
            result[i] = start.val;
            start = start.next;
        }
        return result;
    }
}
