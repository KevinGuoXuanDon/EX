package leetcode.LinkedList;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 
 */
public class LinkedListCycle {
    /**
     * 方法：快满指针。如果存在环，快慢指针总会相遇。如果不存在，遍历一边直接结束返回false
     * 如果要求环开始的位置：
     * 当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) return true;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) break;
        }
        if(quick==null || quick.next==null) return null;
        slow = head;
        while(slow != quick){
            slow =slow.next;
            quick = quick.next;
        }
        return slow;

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
