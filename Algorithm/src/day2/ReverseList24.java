package day2;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList24 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 利用head遍历。通过尾插法形成新的链biao
     * 时间消耗0ms
     * 内存38.1，54.7%
     * 在遍历链表时，将当前节点的指针改为指向前一个节点。
     * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode h = null;
        while(head!=null){
            h=head;
            head = head.next;
            h.next=p;
            p=h;
        }
        return p;
    }
}
