package MicroSoft;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthNumber_215 {
    //2ms
    public int findKthLargest(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //tailCall的快排  时间复杂度平均还是nlogn, tailcall似乎优化更多的是空间复杂度a
    public int findKthLargestByQuickSort(int[] nums, int k){
        quickSort(nums,nums.length-k,0,nums.length-1);
        Arrays.stream(nums).forEach(System.out::println);
        return nums[nums.length-k];
    }

    public void quickSort(int[] nums, int k, int left, int right){
        if(left>=right) return;
        int i=left,j=right;
        while(i<j){
            while(i<j && nums[j]>=nums[left]) j--;
            while(i<j && nums[i]<=nums[left]) i++;
            swap(nums,i,j);
        }
        swap(nums,i,left);
        if(i>k) quickSort(nums,k,left,i-1);
        else quickSort(nums,k,i+1,right);
    }

    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //基于随机函数优化的快排，平均时间复杂度能优化到O(n), 1ms 98%
    public int findKthLargestByQuickSortOptimization(int nums[],int k){
        return quickSortOptimization(nums,0,nums.length-1, nums.length-k);
    }
        public int quickSortOptimization(int[] nums, int left, int right, int k){
            int i =randomPartition(nums,left,right);
            if(i==k) return nums[k];
            if(i>k) return quickSortOptimization(nums,left,i-1,k);
            else return  quickSortOptimization(nums,i+1,right,k);
        }
        public int randomPartition(int[] nums, int left, int right){
            if(left>=right) return left;
            int ra = (int)(left+Math.random()*(right-left+1));
            swap(nums,left,ra);
            int i=left,j=right;
            while(i<j){
                while(i<j && nums[j]>=left) j--;
                while(i<j && nums[i]<=left) i++;
                swap(nums,i,j);
            }
            swap(nums,i,left);
            return i;
    }

    //5ms 46.7
    public int findKthLargestByPriorityQueue(int[] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o2-o1);
        for (Integer i:nums) {
            queue.offer(i);
        }
        int result=0;
        for (int i = 0; i <k ; i++) {
            result = queue.poll();
        }
        return result;
    }
}
