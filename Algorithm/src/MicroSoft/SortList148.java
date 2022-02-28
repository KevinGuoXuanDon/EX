package MicroSoft;



public class SortList148 {
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

    public ListNode sortList(ListNode head){
         return sortList(head,null);
    }
    public ListNode sortList(ListNode head, ListNode tail){
        if(head==null) return head;
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=tail){
            slow=slow.next;
            //slow每次走一步，fast每次走两步，直到fast走到尾节点，此时slow指针指向的是中间节点
            fast= fast.next.next==tail? fast.next: fast.next.next;
        }
        ListNode mid = slow;
        //分:把链表逐渐拆分为两个两个的子链表
        ListNode left = sortList(head,mid);
        ListNode right = sortList(mid.next,tail);
        //治：把子链表有序地合并起来
        ListNode mergedList = merge(left,right);
        return mergedList;
    }
    public ListNode merge(ListNode left, ListNode right){
        //创建一个虚拟头节点(链表前缀，指向头节点)
        ListNode dummyNode = new ListNode();
        ListNode temp = dummyNode, lTemp = left, rTemp = right;
        //取两个链表中更小值的节点，并且取得后这个节点向后移动，直到某个链表取完
        while(lTemp!=null && rTemp!=null){
            if(lTemp.val<rTemp.val){
                temp.next=lTemp;
                lTemp=lTemp.next;
            }
            else{
               temp.next=rTemp;
               rTemp=rTemp.next;
            }
            temp=temp.next;
        }
        //把剩下还每天加完的链表加到结果中
        while (lTemp!=null){
            temp.next=lTemp;
            lTemp=lTemp.next;
            temp=temp.next;
        }
        while(rTemp!=null){
            temp.next=rTemp;
            rTemp=rTemp.next;
            temp=temp.next;
        }
        return dummyNode.next;
    }
}
