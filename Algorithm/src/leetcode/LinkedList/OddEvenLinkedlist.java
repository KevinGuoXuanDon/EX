package leetcode.LinkedList;

/**
 * 第一个节点的索引被认为是奇数，第二个节点的索引为偶.以此类推。
 * 目标：把奇数放在一起，偶数放在一起
 *
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 */
public class OddEvenLinkedlist {

    public ListNode oddEvenList(ListNode head){
        // 忘了加判断条件
        if(head==null || head.next==null || head.next.next==null) return head;
        ListNode pre = head, cur = pre.next, next = cur.next;
        while(next!=null){
            ListNode newNode = new ListNode(next.val);
            newNode.next= pre.next;
            pre.next = newNode;
            cur.next = cur.next.next;
            pre=pre.next;
            cur=cur.next;
            next=cur.next;
        }
        return head;
    }
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
}
