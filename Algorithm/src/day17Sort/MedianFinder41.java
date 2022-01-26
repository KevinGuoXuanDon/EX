package day17Sort;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder41 {
    //采用链表直接for循环找位置插入会超时，时间复杂度为o(n)太高了，至少需要使用插入排序或者二分查找来降低
    private boolean isOdd ;
    private int currentMideanIndex;
    private LinkedList<Integer> list;
    public MedianFinder41() {
        isOdd = false;
        currentMideanIndex = -1;
        list = new LinkedList<>();
    }


    public void addNum(int num) {
        isOdd = !isOdd;
        if (isOdd) currentMideanIndex++;
        if(list.size()==0) list.add(num);
        else{
            for (int i = 0; i < list.size(); i++) {
                if(num<list.get(i)) {
                    list.add(i,num);
                    break;
                }
                if(i==list.size()-1) list.addLast(num);
            }
        }
    }

    public double findMedian() {
        if(list.size()==0) return 0.0;
        if(isOdd) return list.get(currentMideanIndex);
        else return (list.get(currentMideanIndex)+list.get(currentMideanIndex+1))/2.0;
    }

    @Override
    public String toString() {
        return "MedianFinder41{" +
                "list=" + list +
                '}';
    }
    //更好一些的方法，控制插入在O(logn)，查找O(1)，方法为使用大小顶堆，PriorityQueue
    static class MedianFinder{
        Queue<Integer> min, max;
        public MedianFinder() {
            min = new PriorityQueue<>(); // 小顶堆，保存较大的一半
            max = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
        }
        public void addNum(int num) {
            if(min.size() != max.size()) {
                min.add(num);
                max.add(min.poll());
            } else {
                max.add(num);
                min.add(max.poll());
            }
        }
        public double findMedian() {
            return min.size() != max.size() ? min.peek() : (min.peek() + max.peek()) / 2.0;
        }
    }
    public static void main(String[] args) {
        MedianFinder41 m = new MedianFinder41();
        for (int i = 0; i <50000; i++) {
            m.addNum(1);
            m.findMedian();
        }
        System.out.println("ok");
    }
}
