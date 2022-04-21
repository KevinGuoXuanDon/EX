package leetcode.Windows;
import java.util.*;
//求滑动窗口最大值
public class MaxValueOfWindow {
    // 两种解 1. 使用双端队列，把大元素进队，之后如果有更大的，则进行替换。组成滑动窗口时，拿出队首元素，检查下标是否过期
    // 如果没有过期可以使用，则这就是当最大元素。时间复杂度n
    public ArrayList<Integer> maxInWindowsByDeque(int[] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        if(size<=0 || num.length==0) return res;
        Deque<Integer> deque = new ArrayDeque<>();
        // initialize deque
        for (int i = 0; i < num.length; i++) {
            while(!deque.isEmpty() && num[deque.peekLast()]<num[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            while(deque.peekFirst()+size<=i){
                deque.pollFirst();
            }
            if(i>=size-1){
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }
    // 2. 使用priorityQueue来模拟滑动窗口执行，时间复杂度n*size
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(size==0) return res;
        if(size>=num.length){
            int m = Arrays.stream(num).max().getAsInt();
            res.add(m);
            return res;
        }
       PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        int left = 0;
        int right = size-1;
        for(int i=left;i<=right;i++){
            queue.add(num[i]);
        }
        while(right<num.length){
            res.add(queue.peek());
            queue.remove(num[left]);
            left++;
            right++;
            if(right==num.length) break;
            queue.add(num[right]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxValueOfWindow m = new MaxValueOfWindow();
        ArrayList<Integer> list = m.maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
        list.stream().forEach(System.out::println);
    }
}
