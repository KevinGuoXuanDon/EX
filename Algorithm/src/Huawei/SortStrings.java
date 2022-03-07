package Huawei;
import java.util.*;
//对一堆字符串，按照字典的方式排序A-Z.区分大小写.
public class SortStrings {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        PriorityQueue<String> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            queue.offer(sc.nextLine());
        }
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
