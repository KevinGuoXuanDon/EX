package leetcode;

import java.util.*;

/**
 * @author Xuandong Guo
 * @date 23/09/2022
 */
public class FindMlargerNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(find(arr, m, 0));
    }

    public static int find(int[] arr, int m, int start) {
        int n = arr.length;
        if (start == n-1) {
            return arr[start];
        }
        // 不可能有结果
        if (m > arr.length) {
            return -1;
        }
        // 边界情况
        if (m == 0) {
            return arr[start];
        }
        if (m == 1) {
            return Math.max(arr[start], arr[start+1]);
        }

        int count = 0;
        int cur = start;
        // 前面的元素都是更小的元素且不会满足 count>=m, 然后他们都会被移入队尾变成又小又靠后的元素，不可能是答案
        // 所以直接过滤，找到第一个符合 大于下一个元素的数字 arr[cur] > arr[cur+1]
        while (cur+1< n && arr[cur] <= arr[cur + 1]) {
            cur++;
        }
        // next指针去找到比这个元素大的下一个元素位置
        int next = cur+1;
        while (next < n && arr[cur] > arr[next]) {
            next++;
        }
        // 找到最后也没有比当前值大的元素，那么最大元素就是arr[cur]了，直接返回
        if (next == n) {
            return arr[cur];
        }
        // 如果有比当前更大的下一个元素，我们查询cur到next差了多少位就好了，这些元素都是比cur和next更小的元素，都要被放入队尾变成又小位置又靠后，不可能是答案了
        else {
            count += next - cur;
        }
        if (count >= m) {
            return arr[cur];
        } else {
            return find(arr, m, next);
        }
    }
    public static int findByQueue(int[] arr, int m){
        // 如果是通过显式的声明队列做，通过FIFO的特性会很容易实现

        // 不可能有结果
        if (m > arr.length) {
            return -1;
        }
        // 边界情况
        if (m == 0) {
            return arr[0];
        }
        if (m == 1) {
            return Math.max(arr[0], arr[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        // 把数组元素全部入队
        for(int i: arr){
            queue.add(i);
        }

        int loopTime = arr.length;
        // result用于记录结果，一般记录队列头就好了
        int result = -1;
        int count = 0;
        while(count<m){
            // 以 3 4 5 1 6为例子
            // 拿出头部元素3
            int head = queue.poll();
            result = head;
            // 3和4相比，如果头部元素3小
            while(head < queue.peek()){
                // 把3加入到队列尾部, 下一次循环拿出来的头部就会是4，一直循环到 5 1 6 3 4才会打破
                queue.add(head);
                head = queue.poll();
                result = head;
                count = 1;
            }
            while(head > queue.peek()){
                // 如果头部元素大，此时 5 1 6 3 4, head = 5, queue.peek = 1
                int smallEle = queue.poll();
                // 把1拿出来放入到队尾
                queue.add(smallEle);
                count++;
            }
            // 上一个循环一直到 5 6 3 4 1 打破, 此时头部为5，count = 2. 如果此时count依旧<m, 下一次head就会是6
            // 由于我写的while条件是count<m,最坏情况下可能永远达不到，所以用loopTime来限制总次数
            loopTime--;
            if(loopTime<0){
                break;
            }
        }
        return result;
    }
}
