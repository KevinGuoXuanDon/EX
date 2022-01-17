package day12DoublePointer;

import java.util.HashMap;
import java.util.HashSet;

public class GetIntersectionNode52 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val =x;
        }
    }
    //7ms 20.78%
    //42.1MB 10.12%
    //简单粗暴
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        HashSet<ListNode> set = new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(set.contains(headB)) return headB;
            headB=headB.next;
        }
        return null;
    }
    //先算两个链表长度len1,len2，然后让长的链表先走掉Math.abs(len1-len2)长度，然后两个链表一起推进找共同LinkList
    //1ms 99.99%
    //40.8MB 94.49%
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if(headA==null || headB==null) return null;
        ListNode node1 = headA;
        ListNode node2 = headB;
        int len1=0,len2=0;
        while(node1!=null){
            len1++;
            node1=node1.next;
        }
        while(node2!=null){
            len2++;
            node2=node2.next;
        }
        node1=headA;node2=headB;
        if(len1>len2){
            for (int i = 0; i < len1-len2; i++) {
                node1=node1.next;
            }
        }
        else{
            for (int i = 0; i < len2-len1; i++) {
                node2=node2.next;
            }
        }
        while(node1!=node2){
            node1=node1.next;
            node2=node2.next;
        }
        return node1;
    }

    //1ms 99.99%
    //40.4MB 99.64%
    // 假设俩链表交叉长度为c，链表A的长度为a，链表B长度为B，则有：
    // 链表遍历😩自己长度，遍历对方直到交叉点时，A走了a + (b-c), B走了b+(a-c)，此时交叉点，有 a+(b-c)=b+(a-c)
    // 有公共尾部，此时node为尾部第一元素 c>0, ，无公共尾部，此时为null,c=0,a+b=b+a
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB){
        ListNode node1=headA,node2=headB;
        while(node1!=node2){
            node1 = node1==null? headB:node1.next;
            node2 = node2==null? headA:node2.next;
        }
        return node1;
    }
}
