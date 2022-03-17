package Compete;

import java.util.ArrayList;

public class ParadolimeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        int first = 0;
        int last = list.size()-1;
        boolean flag = true;
        while(first<last){
            if(list.get(first) == list.get(last)){
                first ++;
                last--;
            }
            else{
                if(!flag) return flag;
                flag = false;
                if(list.get(first+1) == list.get(last)){
                    first++;
                }
                else if(list.get(first) == list.get(last-1)){
                    last--;
                }
            }
        }
        return true;
    }
}
