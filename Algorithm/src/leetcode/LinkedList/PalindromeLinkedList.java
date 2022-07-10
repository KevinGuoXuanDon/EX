//package leetcode.LinkedList;
//
//public class PalindromeLinkedList {
//    public boolean isPalindrome(ListNode head) {
//        ListNode slow=head;
//        ListNode fast=head;
//        while(fast!=null && fast.next!=null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        if(fast!=null){
//            slow = slow.next;
//        }
//        ListNode left = head;
//        ListNode right = reverse(slow);
//        while(right!=null){
//            if(left.val!=right.val) return false;
//            left = left.next;
//            right = right.next;
//        }
//        return true;
//    }
//    public ListNode reverse (ListNode node){
//        ListNode pre = null, cur = node;
//        while(cur!=null){
//            ListNode next= cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }
//}
