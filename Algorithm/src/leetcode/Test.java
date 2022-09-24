package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author Xuandong Guo
 * @date 14/09/2022
 */
public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            Node dummyHead = new Node();
            Node head = dummyHead;
            for(int i=0; i<n; i++){
                int value = sc.nextInt();
                Node temp = new Node();
                temp.val = value;
                dummyHead.next = temp;
                dummyHead = dummyHead.next;
            }
            int flag = 1;
            head = head.next;
            Node tempHead = head;
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();
            Deque<Integer> stack = new ArrayDeque<>();
            while(tempHead!=null){
                if(flag%2==1){
                    odd.append(tempHead.val).append(" ");
                }
                else{
                    stack.push(tempHead.val);
                }
                tempHead = tempHead.next;
                flag++;
            }
            while(!stack.isEmpty()){
                even.append(stack.pop()).append(" ");
            }
            System.out.println(odd.toString());
            System.out.println(even.toString());
        }
    }

    static class Node{
        int val;
        Node next;
        Node(){}
        Node(int value){
            val = value;
        }
        Node(int value, Node nextNode){
            val = value;
            next = nextNode;
        }

    }
}
