package MicroSoft;

public class InsertionSortList147 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val, ListNode node){
            this.val=val;
            next=node;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode lastsorted = head;
        ListNode curNode = head.next;
        while(curNode!=null){
            if(curNode.val>=lastsorted.val){
                lastsorted=lastsorted.next;
            }
            else{
                ListNode pre = dummyHead;
                while(pre.next.val<=curNode.val){
                    pre=pre.next;
                }
                lastsorted.next = curNode.next;
                curNode.next = pre.next;
                pre.next = curNode;
            }
            curNode = lastsorted.next;
        }
        return dummyHead.next;
    }
}
