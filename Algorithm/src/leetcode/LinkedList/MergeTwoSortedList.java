package leetcode.LinkedList;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 */
public class MergeTwoSortedList {
    //使用技巧：双指针和虚拟头节点
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while(p1!=null && p2 !=null){
            if(p1.val<p2.val){
                p.next = p1;
                p1 = p1.next;
            }
            else{
                p.next = p2;
                p2 = p2 .next;
            }
            p = p.next;
        }
        if(p1 == null){
            p.next = p2;
        }
        else if(p2 == null){
            p.next = p1;
        }
        return dummyHead.next;
    }

     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
