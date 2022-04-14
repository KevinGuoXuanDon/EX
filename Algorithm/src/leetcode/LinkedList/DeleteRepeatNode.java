package leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次。返回 已排序的链表。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 */
public class DeleteRepeatNode {
    // 如果有重复元素就进行删除
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        Set<Integer> set = new HashSet<>();
        ListNode p = head;
        set.add(p.val);
        while(p!=null && p.next!=null){
            while(p.next!=null && set.contains(p.next.val)){
                p.next = p.next.next;
            }
            if(p.next==null) break;
            set.add(p.next.val);
            p = p.next;
        }
        return head;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
