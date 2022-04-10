package leetcode.LinkedList;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 */
public class TwoAdd {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        ListNode p1 = l1, p2 = l2;
        // 标志进位
        Boolean carry = false;
        while(p1!=null & p2!=null){
            ListNode curNode = new ListNode(0);
            int sum = p1.val+p2.val;
            if(carry) sum++;
            curNode.val = sum%10;
            carry = false;
            head.next = curNode;
            head=head.next;
            if(sum>=10){
                carry = true;
            }
            p1=p1.next;
            p2=p2.next;
        }
        while(p1!=null){
            int value =p1.val;
            if(carry) value++;
            ListNode node = new ListNode(value%10);
            carry = false;
            if(value>=10) carry =true;
            head.next=node;
            p1=p1.next;
            head=head.next;
        }
        while(p2!=null){
            int value =p2.val;
            if(carry) value++;
            ListNode node = new ListNode(value%10);
            carry = false;
            if(value>=10) carry =true;
            head.next=node;
            p2=p2.next;
            head=head.next;
        }
        if(carry){
            ListNode node = new ListNode(1);
            head.next=node;
        }
        return dummyHead.next;
    }
}
