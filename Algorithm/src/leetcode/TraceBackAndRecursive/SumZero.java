package leetcode.TraceBackAndRecursive;

import java.util.*;

/**
 * 回溯是不对的，去看findeZeroSet
 */
public class SumZero {
    int count = 0;

    public int solution(int[] arr) {

        for(int i=0;i<arr.length;i++){
            int sum =arr[i];
            if(sum==0){
                count++;
            }
            for (int j = i+1; j <arr.length ; j++) {
                sum+=arr[j];
                if(sum==0){
                    count++;
                }
            }
        }

        return count;
    }

    public void recursive(int index, int[] arr, int sum, boolean flag) {
        if (sum == 0 && flag) {
            count++;
        }
        if (index == arr.length) {
            return;
        }
        int i = index;
        sum += arr[i];
        recursive(i + 1, arr, sum, true);
    }

    public static void main(String[] args) {
        SumZero s = new SumZero();
       // s.solution(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
       s.solution(new int[]{2,-2,3,0,4,-7});
        System.out.println(s.count);
    }
}
