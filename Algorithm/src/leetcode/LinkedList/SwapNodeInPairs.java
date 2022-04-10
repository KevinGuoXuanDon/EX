package leetcode.LinkedList;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class SwapNodeInPairs {
    class ListNode{
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        if(p2 == null) return head;
        ListNode pre = new ListNode();
        pre.next = p2;
        ListNode next = new ListNode();
        while(p2!=null && p1!=null){
            next = p2.next;
            p2.next = p1;
            if(next == null || next.next == null){
                p1.next = next;
                break;
            }
            p1.next = next.next;
            p1 = next;
            p2 = p1.next;
        }
        return pre.next;
    }
}
