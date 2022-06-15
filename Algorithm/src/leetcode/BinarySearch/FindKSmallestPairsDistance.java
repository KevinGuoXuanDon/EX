package leetcode.BinarySearch;

/**
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 *
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,1], k = 1
 * 输出：0
 * 解释：数对和对应的距离如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 距离第 1 小的数对是 (1,1) ，距离为 0 。
 */
import java.util.Arrays;
public class FindKSmallestPairsDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        // 用二分的方式去定义要的数对距离
        int left = 0,  right = nums[n-1]-nums[0];
        // 取等(提交失败+1)
        while(left<=right){
            int mid = left + (right-left)>>1;
            int count = 0;
            //滑动窗口计算当前不超过绝对距离下总共满足多少个数对
            for(int i=0,j=0; j<n; j++){
                while(nums[j]-nums[i]>mid){
                    i++;
                }
                count += j-i;
            }
            if(count >=k){
                // mid-1而不是mid，提交失败+1
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
}
