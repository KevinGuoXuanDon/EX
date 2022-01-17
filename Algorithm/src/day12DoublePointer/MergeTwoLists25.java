package day12DoublePointer;

public class MergeTwoLists25 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x ){
            val=x;
        }
    }
    //这里双指针，一个用来指向头节点，一个用来遍历时加入值
    //0ms 100%
    //38MB 97.96%
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }
            else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next = l1!=null ? l1:l2;
        return head.next;
    }
}
