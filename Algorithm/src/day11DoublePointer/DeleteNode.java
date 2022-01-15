package day11DoublePointer;

public class DeleteNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null) return null;
        ListNode node = head;
        ListNode pre = head;
        while(node!=null){
            if(node.val==val){
                if(pre == node){

                }
            }
        }
    }
}
