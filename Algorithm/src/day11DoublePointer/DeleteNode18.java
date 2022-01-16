package day11DoublePointer;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class DeleteNode18 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    //0ms 100%
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null) return null;
        if(head.val==val) return head.next;
        ListNode node = head;
        while(node.next!=null){
            if(node.next.val==val){
                if(node.next.next!=null) node.next=node.next.next;
                else node.next=null;
                break;
            }
            node=node.next;
        }
        return head;
    }
}
