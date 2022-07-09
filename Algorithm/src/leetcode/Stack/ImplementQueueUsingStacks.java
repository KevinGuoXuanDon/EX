package leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks {
    public class MyQueue {
        Deque<Integer> inDeque;
        Deque<Integer> outDeque;

        public MyQueue() {
            inDeque = new ArrayDeque<>();
            outDeque = new ArrayDeque<>();
        }

        public void push(int x) {
            inDeque.push(x);
        }

        public int pop() {
            if(outDeque.isEmpty()){
                transfer();    
            }
            return outDeque.pop();
        }

        private void transfer() {
            while(!inDeque.isEmpty()){
                outDeque.push(inDeque.pop());
            }
        }

        public int peek() {
            if(outDeque.isEmpty()){
                transfer();
            }
            return outDeque.peek();
        }

        public boolean empty() {
            return inDeque.isEmpty() && outDeque.isEmpty();
        }
    }
}
