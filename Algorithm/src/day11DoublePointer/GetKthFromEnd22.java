package day11DoublePointer;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class GetKthFromEnd22 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //0ms 100%
    //36.1mb
    public ListNode getKthFromEnd(ListNode head, int k) {
        int count=0;
        ListNode node = head;
        while(node!=null){
            count++;
            node=node.next;
        }
        for(int i=0;i<count-k;i++){
            head=head.next;
        }
        return head;
    }
    //更好的方法是使用双指针，时间复杂度为O(n)
    /**
     * 快慢指针的思想。我们将第一个指针 fast 指向链表的第 k + 1个节点，
     * 第二个指针 slow 指向链表的第一个节点，fast 与slow 二者之间刚好间隔 k 个节点。
     * 此时两个指针同步向后走，当第一个指针fast 走到链表的尾部空节点时，则此时 slow 指针刚好指向链表的倒数第k个节点。
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
    //或者写简单点
    //0ms 36.2mb
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode l = head;
        for(ListNode r = head; r != null; r = r.next) {
            if (--k < 0) l = l.next;
        }
            return l;
    }
}
