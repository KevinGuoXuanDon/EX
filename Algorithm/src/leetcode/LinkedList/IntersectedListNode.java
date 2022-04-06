package leetcode.LinkedList;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class IntersectedListNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode pA = headA;
        ListNode pB = headB;
        if(lenA>lenB){
            for(int i =0; i<lenA-lenB; i++){
                pA = pA.next;
            }
        }
        else{
            for(int i =0; i<lenB-lenA; i++){
                pB = pB.next;
            }
        }
        while(pA!=null && pB!=null){
            if(pA==pB) {
                return pA;
            }
            else{
                pA = pA.next;
                pB = pB.next;
            }
        }
        return null;
    }
    public int getLength(ListNode node){
        ListNode p = node;
        int count=0;
        while(p!=null){
            count++;
            p = p.next;
        }
        return count;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
